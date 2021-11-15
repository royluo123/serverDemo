package com.example.demo.controller;

import com.example.demo.bussiness.CongfigHandler;
import com.example.demo.bussiness.UserHandler;
import com.example.demo.entity.Data;
import com.example.demo.entity.DemoConfigs;
import com.example.demo.entity.Info;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @GetMapping(value = "/test")
    public Data get(Info info) {
        return new UserHandler().dealWith(info);
    }

    @PostMapping(value = "/test")
    public Data post(Info info) {
        return new UserHandler().dealWith(info);
    }

    @GetMapping(value = "/config")
    public Data get(DemoConfigs configs) {
        return new CongfigHandler().handleConfigs(configs);
    }

    @PostMapping(value = "/config")
    public Data post(DemoConfigs configs) {
        return new CongfigHandler().handleConfigs(configs);
    }


}
