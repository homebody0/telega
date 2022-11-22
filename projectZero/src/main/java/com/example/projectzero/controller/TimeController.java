package com.example.projectzero.controller;

import com.example.projectzero.entities.Time;
import com.example.projectzero.service.TimeService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер времени
 */
@RestController
@RequestMapping("/time")
@Log
public class TimeController {
    /**
     * Сервис времени
     */
    private final TimeService timeService;

    /**
     * Конструктор контроллера времени
     * @param timeService - сервис времени
     */
    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    /**
     * Создать удобное время
     *
     * @param time - задача
     * @return - ответ на REST запрос
     */
    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody Time time) {
        timeService.create(time);
        log.info("День " + time.getDay() + " для участника " + time.getAuthor() + " добавлен");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Получить список всех удобных дат
     *
     * @return - ответ на REST запрос
     */
    @GetMapping(value = "/list")
    public ResponseEntity<List<Time>> readAll() {
        final List<Time> times = timeService.readAll();
        log.info("Найдено " + times.size() + " даты");
        return !times.isEmpty()
                ? new ResponseEntity<>(times, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Возвращает удобное время по заданному Id
     * @param id - Id даты
     * @return - объект даты с её Id
     */
    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Time> read(@PathVariable(name = "id") int id) {
        final Time time = timeService.read(id);
        log.info("Запрошена дата: " + time);
        return time != null
                ? new ResponseEntity<>(time, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    /**
//     * Обновляет дату по её Id
//     * @param time - дата
//     * @param id - Id
//     * @return - true - данные обновлены, false - нет
//     */
//    @PostMapping(value = "/update/{id}")
//    public ResponseEntity<Time> update(Time time, @PathVariable(name = "id") int id) {
//        log.info("Обновдение даты с id: " + id + " новые данные: " + time);
//        return timeService.update(time, id)
//                ? new ResponseEntity<>(time, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
    /**
     * Удаляет дату по её Id
     * @param id - Id даты
     * @return - true - данные удалены, false - нет
     */
    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Time> delete(@PathVariable(name = "id") int id) {
        log.info("Дата " + timeService.read(id) + " удалена");
        return timeService.delete(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
