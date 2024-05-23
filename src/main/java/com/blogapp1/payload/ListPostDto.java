package com.blogapp1.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ListPostDto {
    private List<PostDto> postDto;
    private int totalpages;
    private int totalElements;
    private boolean lastPage;
    private boolean firstPage;
    private int pageNumber;
}
