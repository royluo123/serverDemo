package com.example.demo.controller;

import com.example.demo.entity.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/req")
    public Data get(TestReq req) {
        return dealWith(req);
    }

    @PostMapping(value = "/req")
    public Data post(TestReq req) {
        return dealWith(req);
    }


    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name, @RequestParam("country") String country) {
        return "hello,world,name:" + name + ",country:" +country;
    }

    @GetMapping("/fetch")
    public String fetch(HttpServletRequest request) {
        ServletInputStream is = null;
        try {
            is = request.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = is.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }
            System.out.println(sb.toString());
            return "content = " + sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @PostMapping("/hello")
    public Data hello(@RequestParam("name") String name,
                        @RequestParam("age") Integer age) {
        return new Data().setCode(0).setResult("from param, name: " + name + "\nage: " + age);
    }

    @PostMapping("/hello1")
    public Data hello1(@RequestParam Map<String,Object> params) {
        return new Data().setCode(0).setResult("from map, name: " + params.get("name") + ", age: " + params.get("age"));
    }

    @PostMapping("/hello2")
    public String hello2(HttpServletRequest request) {
        ServletInputStream is = null;
        try {
            is = request.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = is.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }
            System.out.println(sb.toString());
            return "from stream, content = " + sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @PostMapping("/hello3")
    public String hello3(@RequestParam("name") String[] names) {
        String result = "from array";
        for(String name:names){
            result += ", name:"+name;
        }
        return result;
    }

    @PostMapping("/hello4")
    public String hello4(@RequestBody Map params) {
        return "from json, name:" + params.get("name") + ", age:" + params.get("age");
    }

    @PostMapping("/hello5")
    public String hello5(User user) {
        return "from ,Object, name:" + user.getName() + ", age:" + user.getAge();
    }

    @PostMapping("/hello6")
    public String hello6(User user, Phone phone) {
        return "from multi-object, name: " + user.getName() + ", age: " + user.getAge() + "number: "+phone.getNumber() + ", mcn: " +phone.getMcn();
    }

    private Data dealWith(TestReq req) {
        return new Data().setCode(0).setResult("test req : id = "+ req.getReqId() + ", name = " + req.getReqName());
    }
}

