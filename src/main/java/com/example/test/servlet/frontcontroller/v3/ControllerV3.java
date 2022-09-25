package com.example.test.servlet.frontcontroller.v3;

import com.example.test.servlet.frontcontroller.ModelView;
import com.example.test.servlet.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
