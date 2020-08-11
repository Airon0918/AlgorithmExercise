package com.yangshm.future.service;

import com.yangshm.future.entity.Data;
import com.yangshm.future.entity.FutureData;
import com.yangshm.future.entity.RealData;

public class Client {
    public Data request(final String queryStr) {
        final FutureData futureData = new FutureData();
        new Thread() {
            public void run() {
                RealData realData = new RealData(queryStr);
                futureData.setRealData(realData);
            }
        }.start();
        return futureData;
    }
}
