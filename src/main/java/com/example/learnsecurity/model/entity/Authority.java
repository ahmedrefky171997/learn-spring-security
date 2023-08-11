package com.example.learnsecurity.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authorities")
@NoArgsConstructor
@Setter
@Getter
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authorityName;

    @JsonIgnore
    @ManyToMany(mappedBy = "authorities")
    private Set<User> users = new HashSet<>();
}
