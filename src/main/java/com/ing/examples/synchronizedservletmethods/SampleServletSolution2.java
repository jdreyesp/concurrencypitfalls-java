package com.ing.examples.synchronizedservletmethods;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SampleServletSolution2 implements Servlet
{
    private ConcurrentMap<Integer, String> customMetadataMap = new ConcurrentHashMap<>();

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        Integer id = servletRequest.hashCode();

        customMetadataMap.putIfAbsent(id, "myCustomData");

        //do more stuff
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //Initialize stuff
    }

    @Override
    public void destroy() {
        //Store the customMetadataMap somewhere
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }


}
