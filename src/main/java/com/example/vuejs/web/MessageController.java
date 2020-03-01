package com.example.vuejs.web;

import com.example.vuejs.model.Message;
import com.example.vuejs.service.MessageService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public String index(){
        return "index";
    }

    @GetMapping("/messages/welcome")
    public String welcome(Model model){
        model.addAttribute("message", "Hello, Welcome to Spring Boot!");
        return "welcome";
    }

    @GetMapping("/api/messages")
    @ResponseBody
    public ResponseEntity<List<Message>> getMessages() {
        return ResponseEntity.ok(messageService.getMessages());
    }

    @PostMapping("/api/messages")
    @ResponseBody
    public ResponseEntity<Message> saveMessage(@RequestBody MessageData data){
        Message saved = messageService.save(data.getText());
        if(saved == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/api/messages/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteMessage(@PathVariable Long id){
        messageService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @Data
    public static class DeleteBody {
        private MessageData data;
    }
}
