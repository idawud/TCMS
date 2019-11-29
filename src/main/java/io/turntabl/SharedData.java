package io.turntabl;

import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedData extends BGThread implements Runnable{
    public volatile int selection;
    public volatile boolean hasUpdate = false;
    private final Lock displayQueueLock = new ReentrantLock();
    private final Lock readQueueLock = new ReentrantLock();

    public void produce(int value) {

        final Lock displayLock = this.displayQueueLock;
        displayLock.lock();
        try
        {
            selection = value;
            // hasUpdate = true;
            //wait();
            System.out.println("Produce Resumed");
        } finally {
            displayLock.unlock();
        }
    }

    public void consume() {
        final Lock readQueueLock = this.readQueueLock;
        readQueueLock.lock();
        try
        {
            operation(selection);
            hasUpdate = false;
            System.out.println("Consume Resumed");
            //notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readQueueLock.unlock();
        }
    }

    @Override
    public void run() {
            while (!Thread.interrupted()){
                consume();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
