package com.example.test.servlet.frontcontroller.v3.controller;

import com.example.test.servlet.frontcontroller.ModelView;
import com.example.test.servlet.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class WorkControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        String age = paramMap.get("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);

        ModelView model = new ModelView("work");

        model.getModel().put("username", username);
        model.getModel().put("age", age);

        return model;
    }
}
