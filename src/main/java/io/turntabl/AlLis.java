package io.turntabl;

import java.util.Observable;
import java.util.Observer;

public class AlLis implements Observer {
    public void observe(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        int someVariable = ((SharedData) o).getOption();
        System.out.println("All is flux!  Some variable is now " + someVariable);
    }
}
