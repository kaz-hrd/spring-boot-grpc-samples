package com.example.grpc.client;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.grpc.client.services.SampleDriver;

@SpringBootApplication
public class Application {
	private static Logger log = LoggerFactory.getLogger(Application.class);
	private static final ThreadLocal<String> context = new ThreadLocal<>();
	private static void myTask(SampleDriver driver, Duration duration) throws InterruptedException {
        log.info("Start: {} : {} ", context.get(), Thread.currentThread());
        driver.sleep((int)duration.getSeconds()); 
        log.info("End  : {} ", Thread.currentThread());
    }
	public static void main(String[] args) {
		var appContext = SpringApplication.run(Application.class, args);
		var driver = appContext.getBean(SampleDriver.class);
        driver.checkHealth();
        IntStream.range(0, 1000).forEach(n -> {
            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                List<Future<Integer>> futures = new ArrayList<>();
                IntStream.range(0, 10).forEach(i -> {
                    // この時点でスレッドは走る
                    Future<Integer> future = executor.submit(() -> {
                        context.set("task-" + i);
                        myTask(driver, Duration.ofSeconds(5));
                        log.info("done task #{}", i);
                        return i;
                    });
                    futures.add(future);
                });

                log.info("submitted all tasks");

                // スレッドの完了を待つ
                for (var future : futures) {
                    log.info("result: {}", String.valueOf(future.get()));
                }
            } catch (Exception e) {
                log.error("Error in main", e);
            }
            try {
                TimeUnit.SECONDS.sleep(35);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

    }

}
