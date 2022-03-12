package com.innowise.controller;

import com.innowise.MessageService.MessageService;
import com.innowise.domain.Message;

import com.sun.istack.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.innowise.controller.MessageController.MESSAGE_BASE_URL;

@Controller(MESSAGE_BASE_URL)
@RequiredArgsConstructor
public class MessageController {
    public static final String MESSAGE_BASE_URL = "/message";

    public static final String GET_ALL_MESSAGES = "/messages";
    public static final String MESSAGE_CREATE = "/create/{type}/{text}/{tag}";
    public static final String MESSAGE_DELETE = "/delete/{id}";
    public static final String MESSAGE_CREATE_WITH_BODY = "/body";
    public static final String MESSAGE_CREATE_WITH_BODY_PARAM = "/queryparams{?type,text,tag}";
    public static final String MESSAGE_UPDATE = "/update";

    private final MessageService messageService;

    @Get(GET_ALL_MESSAGES)
    public Single<Iterable<Message>> getMessages(){

        return Single.just(messageService.findAll());
    }

    @Post(MESSAGE_CREATE)
    public Message create(@PathVariable String type,
                                                 @PathVariable String text,
                                                 @PathVariable String tag){

        return messageService.saveMessage(new Message(null, type, text, tag));
    }

    @Post(MESSAGE_CREATE_WITH_BODY)
    public Message createWithBody(@Body Message message){
        return messageService.saveMessage(message);
    }

    @Post(MESSAGE_UPDATE)
    public Single<HttpResponse<Message>> updateWithBody(@Body Message message){
        messageService.editMessage(message);

        return Single.just(HttpResponse.noContent());
    }

    @Delete(MESSAGE_DELETE)
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }

    @Post(MESSAGE_CREATE_WITH_BODY_PARAM)
    public Message createWithBody(@QueryValue Optional<String> type,@QueryValue @Nullable String text,@QueryValue @Nullable String tag){
        return messageService.saveMessage(new Message(null, type.get(), text, tag));
    }
}
