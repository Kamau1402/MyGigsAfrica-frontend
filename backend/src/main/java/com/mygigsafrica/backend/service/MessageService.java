package com.mygigsafrica.backend.service;

import com.mygigsafrica.backend.entity.Message;
import java.util.List;
import java.util.Optional;

public interface MessageService {
    Message sendMessage(Message message);
    Optional<Message> getMessageById(Long id);
    List<Message> getMessagesBetweenUsers(Long senderId, Long receiverId);
    List<Message> getMessagesForReceiver(Long receiverId);
    void deleteMessage(Long id);
}
