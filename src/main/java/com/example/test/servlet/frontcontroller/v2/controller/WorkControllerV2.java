package com.example.test.servlet.frontcontroller.v2.controller;

import com.example.test.servlet.frontcontroller.MyView;
import com.example.test.servlet.frontcontroller.v1.ControllerV1;
import com.example.test.servlet.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WorkControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/work.jsp";
        return new MyView(viewPath);
    }
}
