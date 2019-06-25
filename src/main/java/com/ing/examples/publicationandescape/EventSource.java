package com.ing.examples.publicationandescape;

import org.w3c.dom.events.EventListener;

import java.util.concurrent.*;

public class EventSource extends Thread {
    private final BlockingQueue<EventListener> listeners =
            new LinkedBlockingQueue<>();

    public void run() {
        while (true) {
            try {
                listeners.take().handleEvent(null);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void registerListener(EventListener eventListener) {
        listeners.add(eventListener);
    }
}