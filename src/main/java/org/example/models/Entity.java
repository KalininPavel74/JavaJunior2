package org.example.models;


import org.example.Column;

import java.util.UUID;

@org.example.Entity
public class Entity {

    @Column(name = "id", primaryKey = true)
    private UUID id;

}
