package com.example.grpc.server.services;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.grpc.proto.SampleGrpc;
import com.example.grpc.proto.SampleReply;
import com.example.grpc.proto.SampleRequest;
import com.google.type.DateTime;

import io.grpc.stub.StreamObserver;

@Service
public class SampleService extends SampleGrpc.SampleImplBase {

    private static Logger log = LoggerFactory.getLogger(SampleService.class);


    @Override
    public void executeProcess(SampleRequest req, StreamObserver<SampleReply> responseObserver) {
        log.info("Hello " + req.getName());
        if (req.getName().startsWith("error")) {
            throw new IllegalArgumentException("Bad name: " + req.getName());
        }
        if (req.getName().startsWith("internal")) {
            throw new RuntimeException();
        }
        SampleReply reply = SampleReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void sleep(com.example.grpc.proto.SleepRequest req,
            io.grpc.stub.StreamObserver<com.example.grpc.proto.SleepReply> responseObserver) {

        long seconds = req.getSeconds();
        var start = LocalDateTime.now();
   

        log.info("Sleep for " + seconds + " seconds");
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        com.example.grpc.proto.SleepReply reply = com.example.grpc.proto.SleepReply.newBuilder()
                .setStart(this.convertDateTime(start))
                .setEnd(this.convertDateTime(LocalDateTime.now()))
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
        log.info("End Sleep");
    }

    private com.google.type.DateTime convertDateTime(LocalDateTime ldt) {
        return com.google.type.DateTime.newBuilder()
                .setYear(ldt.getYear())
                .setMonth(ldt.getMonthValue())
                .setDay(ldt.getDayOfMonth())
                .setHours(ldt.getHour())
                .setMinutes(ldt.getMinute())
                .setSeconds(ldt.getSecond())
                .build();
    }
}
