package com.ing.examples.synchronizedservletmethods;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This leads to performance problems, not allowing new connections to come in
 */
public class SampleServlet implements Servlet
{
    private Map<Integer, String> customMetadataMap = new HashMap<>();

    @Override
    public synchronized void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        Integer id = servletRequest.hashCode();

        if(customMetadataMap.get(id) == null) {
            customMetadataMap.put(id, "myCustomData");
        }

        //do more stuff
    }

    @Override
    public synchronized void init(ServletConfig servletConfig) throws ServletException {
        //Initialize stuff
    }

    @Override
    public synchronized void destroy() {
        //Store the customMetadataMap somewhere
    }

    @Override
    public synchronized ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public synchronized String getServletInfo() {
        return null;
    }


}
