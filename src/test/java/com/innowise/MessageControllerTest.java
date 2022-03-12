package com.innowise;

import com.innowise.domain.Message;
import com.innowise.repository.MessageRepository;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class MessageControllerTest {

    @Inject
    MessageRepository messageRepository;

    void create(){
        messageRepository.save(new Message(null, "message", "Serg", "one"));
        messageRepository.save(new Message(null, "message", "Mike", "two"));
    }

    @Test
    void gimme() {
        create();
        Iterable<Message> messages = messageRepository.findAll();
        messages.forEach(System.out::println);
    }

}
