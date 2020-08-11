package com.yangshm.master_worker.entity;


import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
    //任务队列
    protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
    //Worker进程队列
    protected Map<String, Thread> threadMap = new HashMap<String, Thread>();
    //子任务处理结果集
    protected Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

    public Master(Worker worker, int countWorker) {
        worker.setWorkQueue(workQueue);
        worker.setResultMap(resultMap);
        for (int i = 0; i < countWorker; i++) {
            threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }

    public boolean isComplete() {
        for (Map.Entry<String, Thread> entity : threadMap.entrySet()) {
            if (entity.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    public void submit(Object job) {
        workQueue.add(job);
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void execute() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            entry.getValue().start();
        }
    }
}
