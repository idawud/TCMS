package io.turntabl;

import java.sql.SQLException;

public class SharedData extends BGThread{
    public volatile int selection;

    public void produce(int value)throws InterruptedException
    {
        synchronized(this)
        {
            selection = value;
            wait();
            System.out.println("Resumed");
        }
    }

    public void consume()throws InterruptedException
    {
        synchronized(this)
        {
            // System.out.println("producer thread running");
            try {
                operation(selection);
            } catch (SQLException | ClassNotFoundException ignored) { }

            notify();
            System.out.println("Resumed");
        }
    }
}
