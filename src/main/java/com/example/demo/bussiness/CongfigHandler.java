package com.example.demo.bussiness;

import com.example.demo.entity.Data;
import com.example.demo.entity.DemoConfigs;

public class CongfigHandler {
    public Data handleConfigs(DemoConfigs configs) {
        return new Data().setCode(0).setResult("configs: pos = " + configs.getPosId() +", app = " + configs.getAppId());
    }
}
