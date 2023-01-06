package com.socialCampusApplication.demo.service;

import com.socialCampusApplication.demo.model.Message;
import com.socialCampusApplication.demo.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class MessageService {

    private MessageRepository messageRepository;

    private UserService userService;

    public MessageService(MessageRepository messageRepository, UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    public List<Message> getAllMessages(Optional<Long> userId){
        if (userId.isPresent())
            return messageRepository.findByUserId(userId.get());
        return messageRepository.findAll();
    }

    public Message getOneMessageById(Long messageId) {
        return messageRepository.findById(messageId).orElse(null);
    }

    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }

//    public Message createMessage(CreateMessageRequest messageRequest) {
//        UserDto user = userService.getUserDtoById(messageRequest.getUserId());
//        if (user == null)
//            return null;
//        Message toSave = new Message();
//        toSave.setText(messageRequest.getText());
//        toSave.setUser(user);
//        return messageRepository.save(toSave);
//    }


}
