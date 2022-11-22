package com.example.projectzero.service;

import com.example.projectzero.entities.Time;

import java.util.List;

/**
 * Сервис времени
 */
public interface TimeService {
    /**
     * Создание новго удобного времени
     * @param time - удобное время
     */
    void create(Time time);

    /**
     * Возвращает список всех удобных дат
     * @return список дат
     */
    List<Time> readAll();

    /**
     * Возвращает удобное время по заданному Id
     * @param id - Id даты
     * @return - объект даты с её Id
     */
    Time read(int id);

//    /**
//     * Обновляет дату по её Id
//     * @param time - дата
//     * @param id - Id
//     * @return - true - данные обновлены, false - нет
//     */
//    boolean update(Time time, int id);

    /**
     * Удаляет дату по её Id
     * @param id - Id даты
     * @return - true - данные удалены, false - нет
     */
    boolean delete(int id);
}
