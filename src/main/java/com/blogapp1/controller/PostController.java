package com.blogapp1.controller;


import com.blogapp1.payload.ListPostDto;
import com.blogapp1.payload.PostDto;
import com.blogapp1.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    // http://localhost:8080/api/posts
    @PostMapping
public ResponseEntity<?>createpost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
  PostDto dto  = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

}
// http://localhost:8080/api/posts/2

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("post is deleted!!",HttpStatus.OK);



    }
    //http://localhost:8080/api/posts?pageNo=1&pageSize=10&sortBy=description&sortDir=desc
    @GetMapping
    public ResponseEntity<ListPostDto>fetchAllPosts(
            @RequestParam(name="pageNo",defaultValue = "0",required = false)int pageNo,
            @RequestParam(name="pageSize",defaultValue = "5",required = false)int pageSize,
            @RequestParam(name="sortBy",defaultValue = "id",required = false)String sortBy,
            @RequestParam(name="sortDir",defaultValue = "asc",required = false)String sortDir
    ){
        ListPostDto listpostDto = postService.fetchAllPosts(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(listpostDto,HttpStatus.OK);
    }
    //http://localhost:8080/api/posts?id=1
    @GetMapping("/{id}")
public ResponseEntity<PostDto> getPostById(@PathVariable("id") long id){
        PostDto dto = postService.getPostById(id);
return new ResponseEntity<>(dto,HttpStatus.OK);

    }


}
