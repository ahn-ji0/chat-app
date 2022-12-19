package com.example.chatapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WriteRequest {
    private String authorName;
    private String content;
}
