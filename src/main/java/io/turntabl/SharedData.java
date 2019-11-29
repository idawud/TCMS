package io.turntabl;

import java.sql.SQLException;

public class SharedData extends BGThread implements Runnable{
    public volatile int selection;

    public void produce(int value)throws InterruptedException
    {
        synchronized(this)
        {
            selection = value;
            wait();
            System.out.println("Produce Resumed");
        }
    }

    public void consume() {
        synchronized(this)
        {
            try {
                operation(selection);
            } catch (SQLException | ClassNotFoundException ignored) { }

            notifyAll();
            System.out.println("Consume Resumed");
        }
    }

    @Override
    public void run() {
            while (!Thread.interrupted()){
                consume();
            }
    }
}
