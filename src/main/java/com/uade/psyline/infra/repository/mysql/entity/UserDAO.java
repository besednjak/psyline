package com.uade.psyline.infra.repository.mysql.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
}
