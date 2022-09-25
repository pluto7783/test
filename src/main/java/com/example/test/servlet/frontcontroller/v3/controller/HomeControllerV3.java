package com.example.test.servlet.frontcontroller.v3.controller;

import com.example.test.servlet.frontcontroller.ModelView;
import com.example.test.servlet.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class HomeControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("home");
    }

}
