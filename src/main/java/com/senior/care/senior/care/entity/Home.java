package com.senior.care.senior.care.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name ="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToMany(mappedBy = "home")
    private List<User> workers;
}
