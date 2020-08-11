package com.yangshm.future.entity;

import java.util.concurrent.Callable;

public class _RealData implements Callable<String> {
    private String para;

    public _RealData(String para) {
        this.para = para;
    }

    public String call() throws Exception {
        //业务逻辑
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        return sb.toString();
    }
}
