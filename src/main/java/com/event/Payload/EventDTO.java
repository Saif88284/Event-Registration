package com.event.Payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private long id;
    private String name;
    private String email;
    private long number;
    private String eventname;
    private Date eventdate;

}
