package com.example.test.servlet.frontcontroller.v2;

import com.example.test.servlet.frontcontroller.MyView;
import com.example.test.servlet.frontcontroller.v1.ControllerV1;
import com.example.test.servlet.frontcontroller.v1.controller.HomeControllerV1;
import com.example.test.servlet.frontcontroller.v1.controller.WorkControllerV1;
import com.example.test.servlet.frontcontroller.v2.controller.HomeControllerV2;
import com.example.test.servlet.frontcontroller.v2.controller.WorkControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private final Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/v2/home", new HomeControllerV2());
        controllerMap.put("/v2/work", new WorkControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service2");

        String requestURI = request.getRequestURI();

        ControllerV2 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(request, response);
        view.render(request, response);
    }
}
