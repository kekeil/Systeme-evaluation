package com.isge.avis.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name="users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Evaluation> evaluations;
}
