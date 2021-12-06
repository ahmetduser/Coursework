package com.leipzigevent;

import java.util.List;

public class EventCollection {

    private final IDatabase dbAccess = new DatabaseAccess();

    EventCollection() {
    }

    public List<Event> getEventList(String eventKind) {
        return dbAccess.retrieveEvent(eventKind);
    }
}
