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
            System.out.println("Produce Resumed");
        }
    }

    public void consume()throws InterruptedException
    {
        synchronized(this)
        {
            try {
                operation(selection);
            } catch (SQLException | ClassNotFoundException ignored) { }

            notify();
            System.out.println("Consume Resumed");
        }
    }
}
