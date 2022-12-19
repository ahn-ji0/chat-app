package com.example.chatapp.controller;

import com.example.chatapp.domain.entity.ChatMessage;
import com.example.chatapp.domain.RsData;
import com.example.chatapp.domain.dto.WriteRequest;
import com.example.chatapp.domain.dto.WriteResponse;
import com.example.chatapp.domain.dto.GetResponse;
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
    public RsData<?> getMessage(@RequestParam(defaultValue = "-1") long fromId){
        List<ChatMessage> messages = chatMessages;
        long index = fromId < messages.size() ? fromId : -1;

        messages = messages.subList((int) (fromId + 1), messages.size());

        return new RsData<>("S-1",
                "메세지 불러오기 성공",
                new GetResponse(messages,messages.size()));
    }
}
