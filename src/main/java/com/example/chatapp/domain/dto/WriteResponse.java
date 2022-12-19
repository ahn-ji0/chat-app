package com.example.chatapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WriteResponse {
    private long id;
    private String authorName;
    private String content;
}
