package com.example.tp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ToDo {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date;
    private boolean isDone;
}
