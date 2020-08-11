package com.yangshm.designpattern.demo02;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
