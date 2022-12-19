package com.example.chatapp.controller;

import com.example.chatapp.domain.entity.ChatMessage;
import com.example.chatapp.domain.RsData;
import com.example.chatapp.domain.dto.WriteRequest;
import com.example.chatapp.domain.dto.WriteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    List<ChatMessage> chatMessages = new ArrayList<>();
    @PostMapping ("/writeMessage")
    @ResponseBody
    public RsData<?> writeMessage(@RequestBody WriteRequest writeRequest){
        ChatMessage msg = new ChatMessage(LocalDateTime.now(), writeRequest.getAuthorName(), writeRequest.getContent());
        chatMessages.add(msg);
        return new RsData<>("S-1",
                "메세지 입력 성공",
                new WriteResponse(msg.getId(), msg.getAuthorName(),msg.getContent()));
    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<List<ChatMessage>> getMessage(){
        return new RsData<>("S-1",
                "메세지 불러오기 성공",
                this.chatMessages);
    }
}
