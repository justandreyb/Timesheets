package com.justandreyb.timesheets.server.model;

import com.justandreyb.timesheets.server.model.user.User;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "activity")
public class Activity extends DataObject {

    @ManyToOne(optional = false)
    @JoinColumn(name="userId",referencedColumnName="id")
    private User user;

    @Column(name = "start_point")
    private Instant startPoint;

    @Column(name = "end_point")
    private Instant endPoint;

}
