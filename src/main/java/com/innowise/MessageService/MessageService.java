package com.innowise.MessageService;

import com.innowise.domain.Message;
import com.innowise.exception.MessageNotFoundException;
import com.innowise.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final MessageRepository messageRepository;


    public Iterable<Message> findAll() {

        return messageRepository.findAll();
    }

    public Message saveMessage(Message message) {

        return messageRepository.saveAndFlush(message);
    }

    private Optional<Message> getMessageById(Long id) {

        return messageRepository.findById(id);
    }

    public void editMessage(Message message) {
        Optional<Message> optionalMessage = getMessageById(message.getId());
        optionalMessage.orElseThrow(MessageNotFoundException::new);
        messageRepository.update(message);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
