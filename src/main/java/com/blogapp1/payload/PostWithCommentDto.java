package com.blogapp1.payload;

import com.blogapp1.entity.Post;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PostWithCommentDto {
    private PostDto post;
    private List<CommentDto> commentDto =new ArrayList<>();

}
