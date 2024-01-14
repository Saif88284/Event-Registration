package com.event.Service.impl;

import com.event.Entity.Event;
import com.event.Exception.ResourceNotFoundException;
import com.event.Payload.EventDTO;
import com.event.Repository.EventRepository;
import com.event.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventImpl implements EventService {


    @Autowired
    private EventRepository er;

    @Override
    public EventDTO CreateData(Event e) {
        Event ev = new Event();
        ev.setName(e.getName());
        ev.setEmail(e.getEmail());
        ev.setNumber(e.getNumber());
        ev.setEventname(e.getEventname());
        ev.setEventdate(e.getEventdate());
        Event save = er.save(ev);
        EventDTO ed = new EventDTO();
        ed.setId(save.getId());
        ed.setName(save.getName());
        ed.setEmail(save.getEmail());
        ed.setNumber(save.getNumber());
        ed.setEventname(save.getEventname());
        ed.setEventdate(save.getEventdate());
        return ed;
    }

    @Override
    public EventDTO FindById(long id) {
        Event event = er.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("this is is not exist in database" + id)
        );
        EventDTO ed = new EventDTO();
        ed.setId(event.getId());
        ed.setName(event.getName());
        ed.setEmail(event.getEmail());
        ed.setNumber(event.getNumber());
        ed.setEventname(event.getEventname());
        ed.setEventdate(event.getEventdate());
        return ed;
    }

    @Override
    public List<EventDTO> GetAllData() {
        List<Event> all = er.findAll();
        return all.stream().map(s->new EventDTO(s.getId(),s.getName(),s.getEmail(),s.getNumber(),s.getEventname(),s.getEventdate())).collect(Collectors.toList());
    }

    @Override
    public void delete(long id) {
        er.deleteById(id);
    }

    @Override
    public EventDTO updateData(long id , EventDTO ed) {
        Event e = er.findById(id).get();
        e.setName(ed.getName());
        e.setEmail(ed.getEmail());
        e.setNumber(ed.getNumber());
        e.setEventname(ed.getEventname());
        Event save = er.save(e);
        ed.setId(save.getId());
        ed.setName(save.getName());
        ed.setEmail(save.getEmail());
        ed.setNumber(save.getNumber());
        ed.setEventname(save.getEventname());
        return ed;
    }
}
