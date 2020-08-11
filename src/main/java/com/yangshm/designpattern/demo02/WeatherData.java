package com.yangshm.designpattern.demo02;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherData implements Subject {

    private List<Observer> observers;

    private float temp;
    private float humidty;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.indexOf(observer) > 0) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temp, humidty, pressure);
        }
    }
}
