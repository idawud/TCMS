package io.turntabl;

import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

public class Consumer extends BGThread implements Runnable, Observer {
    private Observable observable;

    public Consumer(Observable observable) {
        this.observable = observable;
        observe(observable);
    }


    @Override
    public void run() {
            while (!Thread.interrupted()){
                update(observable, new SharedData());
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
        int someVariable = ((SharedData) o).getOption();
        try {
            operation(someVariable);
        } catch (SQLException | ClassNotFoundException ignored) { }
    }
}
