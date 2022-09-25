package com.example.test.servlet.frontcontroller.v4.controller;

import com.example.test.servlet.frontcontroller.ModelView;
import com.example.test.servlet.frontcontroller.v3.ControllerV3;
import com.example.test.servlet.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class WorkControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username = paramMap.get("username");
        String age = paramMap.get("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);

        model.put("username", username);
        model.put("age", age);

        return "work";
    }
}
