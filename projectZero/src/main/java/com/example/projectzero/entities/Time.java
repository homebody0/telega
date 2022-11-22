package com.example.projectzero.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Класс времени
 */
@Entity
@Table(name = "time_table")
@Data
@NoArgsConstructor
public class Time {
    /**
     * Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Удобные дни недели
     */
    private Integer day;
    /**
     * Имя участника мероприятия
     */
    private String author;
}
