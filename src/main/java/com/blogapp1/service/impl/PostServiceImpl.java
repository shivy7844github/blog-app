package com.blogapp1.service.impl;

import com.blogapp1.entity.Post;
import com.blogapp1.exception.ResourceNotFound;
import com.blogapp1.payload.ListPostDto;
import com.blogapp1.payload.PostDto;
import com.blogapp1.repository.PostRepository;
import com.blogapp1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private ModelMapper modelMapper;
    public PostServiceImpl(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
    Post post   = mapToEntity(postDto);
       // Post post =new Post();
       // post.setTitle(postDto.getTitle());
        //post.setDescription(postDto.getDescription());
       // post.setContent(postDto.getContent());
      Post savedPost  =postRepository.save(post);
     PostDto dto =mapToDto(savedPost);

      //PostDto dto = new PostDto();
     // dto.setId(savedPost.getId());
     // dto.setTitle(savedPost.getTitle());
     // dto.setContent(savedPost.getContent());
     // dto.setDescription(savedPost.getDescription());

        return dto;
    }

    @Override
    public void deletePost(long id) {
       postRepository.deleteById(id);


    }
    public PostDto getPostById(long id){
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFound("Post not found with id:"+id)


        );
      return mapToDto(post);
    }

    @Override
    public ListPostDto fetchAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
      // List<Post> post= postRepository.findAll();
  Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending()
          :Sort.by(sortBy).descending();

        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> all=postRepository.findAll(pageable);
        List<Post>post=all.getContent();
        List<PostDto> postDtos=post.stream().map(p->mapToDto(p)).collect(Collectors.toList());

        ListPostDto listPostDto=new ListPostDto();
        listPostDto.setPostDto(postDtos);
        listPostDto.setTotalpages(all.getTotalPages());
        listPostDto.setTotalElements((int)all.getTotalElements());
        listPostDto.setFirstPage(all.isFirst());
        listPostDto.setLastPage(all.isLast());
        listPostDto.setPageNumber(all.getNumber());

        return listPostDto;
    }

    Post mapToEntity(PostDto postDto){
     Post post = modelMapper.map(postDto,Post.class);

        // Post post =new Post();
       // post.setTitle(postDto.getTitle());
       // post.setDescription(postDto.getDescription());
       // post.setContent(postDto.getContent());
        return post;



    }
    PostDto mapToDto(Post post){

     PostDto dto  = modelMapper.map(post,PostDto.class);
       // PostDto dto = new PostDto();
       // dto.setId(post.getId());
       // dto.setTitle(post.getTitle());
        //dto.setContent(post.getContent());
        //dto.setDescription(post.getDescription());
        return dto;
    }


    }

