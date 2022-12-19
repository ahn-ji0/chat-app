package com.example.chatapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RsData<T> {
    private String ResultCode;
    private String message;
    private T data;
}
