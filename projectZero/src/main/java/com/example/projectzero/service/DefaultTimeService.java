package com.example.projectzero.service;

import com.example.projectzero.entities.Time;
import com.example.projectzero.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис времеи по умолчанию
 */
@Service
public class DefaultTimeService implements TimeService{
    /**
     * Репозиторий базы данных дат
     */
    private static TimeRepository timeRepository = null;

    /**
     * Созадёт новое удобное время
     *
     * @param time - удобное время
     */
    @Override
    public void create(Time time) {
        timeRepository.save(time);
    }

    /**
     * Конструктор сервиса времени
     *
     * @param timeRepository репозиторий базы данных дат
     */
    @Autowired
    public DefaultTimeService(TimeRepository timeRepository) {
        DefaultTimeService.timeRepository = timeRepository;
    }

    /**
     * Возвращает список всех удобных дат
     *
     * @return список дат
     */
    @Override
    public List<Time> readAll() {
        return timeRepository.findAll();
    }

    /**
     * Возвращает удобное время по заданному Id
     *
     * @param id - Id даты
     * @return - объект даты с её Id
     */
    @Override
    public Time read(int id) {
        return timeRepository.getReferenceById(id);
    }

//    /**
//     * Обновляет дату по её Id
//     *
//     * @param time - дата
//     * @param id - Id
//     * @return - true - данные обновлены, false - нет
//     */
//    @Override
//    public boolean update(Time time, int id) {
//        if (timeRepository.existsById(id)) {
//            time.setId(id);
//            timeRepository.save(time);
//            return true;
//        }
//        return false;
//    }

    /**
     * Удаляет дату по её Id
     * @param id - Id даты
     * @return - true - данные удалены, false - нет
     */
    @Override
    public boolean delete(int id) {
        if (timeRepository.existsById(id)) {
            timeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
