package com.example.grpc.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

import com.example.grpc.proto.SampleGrpc;

import io.grpc.health.v1.HealthGrpc;
import io.grpc.health.v1.HealthGrpc.HealthBlockingStub;

@Configuration
public class Config {
    @Bean
    SampleGrpc.SampleBlockingStub sampleBlockingStub(GrpcChannelFactory channelFactory) {
        return SampleGrpc.newBlockingStub(channelFactory.createChannel("localhost:9090"));
    }
    @Bean
    HealthBlockingStub healthBlockingStub(GrpcChannelFactory channelFactory) {
        return HealthGrpc.newBlockingStub(channelFactory.createChannel("localhost:9090"));
    }
}
