package com.example.demo.controller;

import com.example.demo.GlobleConfig;
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
        if(!GlobleConfig.sIsInited){
            return new Data().setCode(-999).setResult("Server not ready.");
        }
        return new UserHandler().dealWith(info);
    }

    @PostMapping(value = "/test")
    public Data post(Info info) {
        if(!GlobleConfig.sIsInited){
            return new Data().setCode(-999).setResult("Server not ready.");
        }
        return new UserHandler().dealWith(info);
    }

    @GetMapping(value = "/config")
    public Data get(DemoConfigs configs) {
        if(!GlobleConfig.sIsInited){
            return new Data().setCode(-999).setResult("Server not ready.");
        }
        return new CongfigHandler().handleConfigs(configs);
    }

    @PostMapping(value = "/config")
    public Data post(DemoConfigs configs) {
        if(!GlobleConfig.sIsInited){
            return new Data().setCode(-999).setResult("Server not ready.");
        }
        return new CongfigHandler().handleConfigs(configs);
    }


}
