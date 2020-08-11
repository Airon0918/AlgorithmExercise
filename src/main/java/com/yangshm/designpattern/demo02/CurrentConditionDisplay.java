package com.yangshm.designpattern.demo02;

public class CurrentConditionDisplay implements Observer, DispalyElement {

    private float temp;
    private float humidty;
    private float pressure;

    @Override
    public void display() {
        System.out.println(temp + "==========" + humidty + "==========" + pressure);
    }

    @Override
    public void update(float temp, float humidty, float pressure) {
        this.temp = temp;
        this.humidty = humidty;
        this.pressure = pressure;
    }
}
