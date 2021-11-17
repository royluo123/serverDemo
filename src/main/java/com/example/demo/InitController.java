package com.example.demo;

import com.example.demo.base.RedisHelper;

public class InitController {
    public interface OnInitListener{
        void onInitComplete();
    }

    public void init(final OnInitListener listener){
        RedisHelper.connectServer();
        listener.onInitComplete();
    }
}
