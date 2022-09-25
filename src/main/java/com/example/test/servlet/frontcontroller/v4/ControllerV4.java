package com.example.test.servlet.frontcontroller.v4;

import com.example.test.servlet.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV4 {

    String process(Map<String, String> paramMap, Map<String, Object> model);
}
