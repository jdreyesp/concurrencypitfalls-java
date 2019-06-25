package com.ing.examples.publicationandescape;

import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;

import java.util.Date;

public class SafeListener {

    private final int num;
    private EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
                    public void handleEvent(Event e) {
                        doSomething(e);
                    }
                };
        num = 42;
    }

    public static SafeListener newInstance(EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }

    private void doSomething(Event e) {
        if (num != 42) {
            System.out.println("Race condition detected at " +
                    new Date());
        }
    }

}
