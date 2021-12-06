package com.leipzigevent;

import java.sql.Connection;
import java.util.List;

public interface IDatabase {
    List<Event> retrieveEvent(String eventKind);

    Connection connectDatabase();
}
