package de.tosken.proc.data.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @Column(name = "EMAIL")
    private String email;

    private String name;
}
