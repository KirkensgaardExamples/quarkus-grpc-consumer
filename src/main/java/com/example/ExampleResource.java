package com.example;

import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExampleResource {

//    @Incoming("line-in")
//    @Outgoing("line-out")
//    public String hello(JsonObject greetingsJson) {
//        GreetingRequest greetingRequest = greetingsJson.mapTo(GreetingRequest.class);
//        System.out.println("Got a request for a greeting");
//        return "Hello " + greetingRequest.getName();
//    }
}