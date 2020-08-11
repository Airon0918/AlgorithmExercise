package com.yangshm.master_worker.entity;

public class PlusWorker extends Worker {
    public Object handle(Object input) {
        Integer i = (Integer) input;
        return i * i * i;
    }
}
