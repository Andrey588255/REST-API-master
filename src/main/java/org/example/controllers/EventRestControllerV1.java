package org.example.controllers;

import com.google.gson.Gson;
import org.example.model.Event;
import org.example.service.EventService;
import org.example.service.impl.EventServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/v1/events")
public class EventRestControllerV1 extends HttpServlet {
    private final EventService eventService = new EventServiceImpl();
    private final Gson GSON = new Gson();

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        String pathInfo = request.getPathInfo();
        Integer id = 0;
        if (id == 0) {
            List<Event> eventList = eventService.getAll();
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(eventList);
        }
    }
}

