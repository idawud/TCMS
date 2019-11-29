package io.turntabl;

import java.util.Observable;

public class SharedData extends Observable {
    private int option = 0;

    public void setOption(int option) {
        synchronized (this) {
            this.option = option;
        }
        setChanged();
        notifyObservers();
    }

    public synchronized int getOption() {
        return option;
    }
}
