package com.event.Controller;


import com.event.Entity.Event;
import com.event.Payload.EventDTO;
import com.event.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService es;

    @PostMapping
    public ResponseEntity<?> CreateData(@RequestBody Event e){
        EventDTO eventDTO = es.CreateData(e);
        return new ResponseEntity<>(eventDTO, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> findbyid(@RequestParam long id){
        EventDTO eventDTO = es.FindById(id);
        return new ResponseEntity<>(eventDTO,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<EventDTO> eventDTOS = es.GetAllData();
        return new ResponseEntity<>(eventDTOS,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> Delete(@PathVariable long id ){
        es.delete(id);
        return  ResponseEntity.ok("Recorde is deleted");
    }

}
