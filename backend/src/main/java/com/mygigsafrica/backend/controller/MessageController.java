package com.mygigsafrica.backend.controller;

import com.mygigsafrica.backend.entity.Message;
import com.mygigsafrica.backend.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        Message savedMessage = messageService.sendMessage(message);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        Optional<Message> msg = messageService.getMessageById(id);
        return msg.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/chat")
    public ResponseEntity<List<Message>> getMessagesBetweenUsers(
            @RequestParam Long senderId,
            @RequestParam Long receiverId) {
        return ResponseEntity.ok(
                messageService.getMessagesBetweenUsers(senderId, receiverId));
    }

    @GetMapping("/inbox/{receiverId}")
    public ResponseEntity<List<Message>> getInboxForUser(@PathVariable Long receiverId) {
        return ResponseEntity.ok(messageService.getMessagesForReceiver(receiverId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}

