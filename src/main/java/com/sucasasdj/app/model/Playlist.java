package com.sucasasdj.app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;

    private String type;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
