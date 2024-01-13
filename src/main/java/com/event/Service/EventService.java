package com.event.Service;

import com.event.Entity.Event;
import com.event.Payload.EventDTO;

import java.util.List;

public interface EventService {


     EventDTO CreateData(Event e);

     EventDTO  FindById(long id);

     List<EventDTO> GetAllData();

     void delete(long id);
}
