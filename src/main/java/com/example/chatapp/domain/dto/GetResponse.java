package com.example.chatapp.domain.dto;

import com.example.chatapp.domain.entity.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class GetResponse {
    private List<ChatMessage> chatMessageList;
    private long count ;
}
