package com.ing.examples.synchronizedservletmethods;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SampleServletSolution implements Servlet
{
    private Map<Integer, String> customMetadataMap = new HashMap<>();

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        Integer id = servletRequest.hashCode();

        synchronized (customMetadataMap) {
            if(customMetadataMap.get(id) == null) {
                customMetadataMap.put(id, "myCustomData");
            }
        }

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
