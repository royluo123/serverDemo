package com.example.demo;

import com.example.demo.base.RedisHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        InitController initController = new InitController();
        initController.init(new InitController.OnInitListener() {
            @Override
            public void onInitComplete() {
                GlobleConfig.sIsInited = true;
            }
        });

        SpringApplication.run(DemoApplication.class, args);
    }

}
