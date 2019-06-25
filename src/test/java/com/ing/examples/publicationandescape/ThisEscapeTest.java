package com.ing.examples.publicationandescape;

import org.junit.Test;

public class ThisEscapeTest {

    @Test
    public void shouldEscapeThisAndPrintMessage() {
        EventSource es = new EventSource();
        es.start();
        while(true) {
            new ThisEscape(es);
        }
    }
}
