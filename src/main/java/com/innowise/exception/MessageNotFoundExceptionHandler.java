package com.innowise.exception;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Singleton
@Requires(classes = {MessageNotFoundException.class, ExceptionHandler.class})
public class MessageNotFoundExceptionHandler implements ExceptionHandler<MessageNotFoundException, HttpResponse>{

    @Override
    public HttpResponse handle(HttpRequest request, MessageNotFoundException exception) {
        return HttpResponse.notFound("Message nor found");
    }
}
