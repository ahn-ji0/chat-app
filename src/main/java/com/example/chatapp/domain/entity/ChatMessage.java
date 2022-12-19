package com.example.chatapp.domain.entity;

import com.example.chatapp.domain.ChatMessageIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ChatMessage {
    private long id;

    private LocalDateTime createdAt;
    private String authorName;
    private String content;

    public ChatMessage(LocalDateTime createdAt, String authorName, String content) {
        this.id = ChatMessageIdGenerator.genNextId();
        this.createdAt = createdAt;
        this.authorName = authorName;
        this.content = content;
    }
}
