package com.example;

import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Multi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/subscribe")
public class SubscribeResource {

    @GrpcClient(value = "hello")
    io.quarkus.example.MutinyGreeterGrpc.MutinyGreeterStub greeterStub;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @Path("/{name}")
    public Multi<String> emitOnSubscribe(@PathParam("name") String name){
        return greeterStub.source(io.quarkus.example.Empty.newBuilder().build())
                .filter(helloRequest -> helloRequest.getName().equals(name))
                .onItem().transform(helloRequest -> "Hello " + helloRequest.getName());
    }
}
