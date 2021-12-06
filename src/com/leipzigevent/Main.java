package com.leipzigevent;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EventCollection eventCollection = new EventCollection();

        List<Event> physicalEvents = eventCollection.getEventList("physicalevent");
        List<Event> virtualEvents = eventCollection.getEventList("virtualevent");

        for (Event event : physicalEvents) {
            System.out.println(event.toString());
        }
        for (Event event : virtualEvents) {
            System.out.println(event.toString());
        }
    }
}
