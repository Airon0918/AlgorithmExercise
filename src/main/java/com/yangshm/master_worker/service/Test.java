package com.yangshm.master_worker.service;

import com.yangshm.master_worker.entity.Master;
import com.yangshm.master_worker.entity.PlusWorker;

import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Master master = new Master(new PlusWorker(), 5);
        for (int i = 0; i < 5; i++) {
            master.submit(i);
        }

        int result = 0;

        Map<String, Object> resultMap = master.getResultMap();
        while (resultMap.size() > 0 || !master.isComplete()) {
            Set<String> keys = resultMap.keySet();
            String key = null;
            for (String k : keys) {
                key = k;
                break;
            }
            Integer i = null;
            if (key != null) {
                i = (Integer) resultMap.get(key);
            }
            if (i != null) {
                result += i;
            }
            if (key != null) {
                resultMap.remove(key);
            }
        }

    }
}
