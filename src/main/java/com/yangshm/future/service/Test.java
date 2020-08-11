package com.yangshm.future.service;

import com.yangshm.future.entity.Data;
import com.yangshm.future.entity._RealData;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //demo
        Client client = new Client();
        Data data = client.request("name");
        System.out.println("请求完毕！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.println("数据 = " + data.getResult());

        //jdk
        //构造FutureTask
        FutureTask<String> futureTask = new FutureTask<String>(new _RealData("a"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //执行FutureTask，即发送请求，调用_RealData的call()
        executorService.submit(futureTask);
        System.out.println("请求完毕！");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("数据 = " + futureTask.get());
    }
}
