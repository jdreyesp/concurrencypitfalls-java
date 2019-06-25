package com.ing.examples.publicationandescape;

import org.junit.Test;

public class SafeListenerTest {

    @Test
    public void shouldEscapeThisAndPrintMessage() {
        EventSource es = new EventSource();
        es.start();
        while(true) {
            SafeListener.newInstance(es);
        }
    }
}
