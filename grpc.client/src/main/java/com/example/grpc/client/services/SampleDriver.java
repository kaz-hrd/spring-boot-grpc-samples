package com.example.grpc.client.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.grpc.proto.SampleGrpc;
import com.example.grpc.proto.SampleRequest;

import io.grpc.health.v1.HealthGrpc;

@Component
public class SampleDriver {
    private static Logger log = LoggerFactory.getLogger(SampleDriver.class);
    private SampleGrpc.SampleBlockingStub stub;
    private HealthGrpc.HealthBlockingStub healthStub;
    public SampleDriver(SampleGrpc.SampleBlockingStub stub, HealthGrpc.HealthBlockingStub healthStub){
        this.stub = stub;
        this.healthStub = healthStub;
    }
    public void execute(){
        SampleRequest request = SampleRequest.newBuilder()
            .setName("Test")
            .build();
        var response = stub.executeProcess(request);
        log.info("Response: " + response.getMessage());
    }
    public void sleep(int seconds){
        var request = com.example.grpc.proto.SleepRequest.newBuilder()
            .setSeconds(seconds)
            .build();
        var response = stub.sleep(request);
        log.info("Sleep from {} to {}", formatDateTime(response.getStart()), formatDateTime(response.getEnd()));
    }
    public void checkHealth(){
        var request = io.grpc.health.v1.HealthCheckRequest.newBuilder()
            .build();
        var response = healthStub.check(request);
        log.info("Health Status: " + response.getStatus().name());
    }
    private String formatDateTime(com.google.type.DateTime dt){
        return String.format("%04d-%02d-%02d %02d:%02d:%02d", dt.getYear(), dt.getMonth(), dt.getDay(),
            dt.getHours(), dt.getMinutes(), dt.getSeconds());
    }
}
