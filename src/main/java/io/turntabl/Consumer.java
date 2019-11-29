package io.turntabl;

import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

public class Consumer extends BGThread implements Runnable, Observer {
    private final SharedData sharedData;
    private Observable observable;

    public Consumer(Observable observable, SharedData sharedData) {
        this.observable = observable;
        this.sharedData = sharedData;
        observe(observable);
    }


    @Override
    public void run() {
        update(observable, sharedData);
            while (!Thread.interrupted()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public void observe(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        int option = ((SharedData) o).getOption();
        System.out.println(option);
        /*
        try {
            operation(someVariable);
        } catch (SQLException | ClassNotFoundException ignored) { }*/
    }
}
