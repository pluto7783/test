package com.example.test.servlet.frontcontroller.v5;

import com.example.test.servlet.frontcontroller.ModelView;
import com.example.test.servlet.frontcontroller.MyView;
import com.example.test.servlet.frontcontroller.v3.ControllerV3;
import com.example.test.servlet.frontcontroller.v3.controller.HomeControllerV3;
import com.example.test.servlet.frontcontroller.v3.controller.WorkControllerV3;
import com.example.test.servlet.frontcontroller.v4.controller.HomeControllerV4;
import com.example.test.servlet.frontcontroller.v4.controller.WorkControllerV4;
import com.example.test.servlet.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import com.example.test.servlet.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/v5/v3/home", new HomeControllerV3());
        handlerMappingMap.put("/v5/v3/work", new WorkControllerV3());

        handlerMappingMap.put("/v5/v4/home", new HomeControllerV4());
        handlerMappingMap.put("/v5/v4/work", new WorkControllerV4());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object handler = gethandler(request);

        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);

        ModelView mv = adapter.handle(request, response, handler);

        String viewName = mv.getViewName();

        MyView view = viewResolver(viewName);
        view.render(mv.getModel(), request, response);

    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (int i = 0; i < handlerAdapters.size(); i++) {
            if (handlerAdapters.get(i).supports(handler)) {
                return handlerAdapters.get(i);
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler=" + handler);
    }

    private Object gethandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
