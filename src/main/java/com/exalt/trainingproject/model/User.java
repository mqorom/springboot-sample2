package com.exalt.trainingproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    private int id;

    @OneToMany(targetEntity = Machine.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Machine> machines;

    public int getId() {
        return id;
    }
}
