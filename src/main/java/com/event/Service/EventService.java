package com.event.Service;

import com.event.Entity.Event;
import com.event.Payload.EventDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.net.ssl.SSLSession;
import java.util.List;

public interface EventService {


     EventDTO CreateData(Event e);

     EventDTO  FindById(long id);

     List<EventDTO> GetAllData();

     void delete(long id);


    EventDTO updateData(long id , EventDTO e);
}
