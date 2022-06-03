package com.example;

import io.smallrye.reactive.messaging.MessageConverter;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import java.lang.reflect.Type;

@ApplicationScoped
public class MyGreetingsConverter implements MessageConverter {
    @Override
    public boolean canConvert(Message<?> message, Type target) {
        return message.getPayload().getClass().equals(JsonObject.class)
                && target.equals(GreetingRequest.class);    }

    @Override
    public Message<?> convert(Message<?> message, Type type) {
        return message.withPayload(new GreetingRequest("Bleh"));
    }
}
