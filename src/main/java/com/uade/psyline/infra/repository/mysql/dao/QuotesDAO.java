package com.uade.psyline.infra.repository.mysql.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="quotes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class QuotesDAO {
    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String quote;
}
