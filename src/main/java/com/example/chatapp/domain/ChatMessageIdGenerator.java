package com.example.chatapp.domain;

public class ChatMessageIdGenerator {
    private static long id;

    public static long genNextId(){
        return id++;
    }
}
