package designmode.observer;

import java.util.ArrayList;

public class WhetherData implements Subject{
    private ArrayList observers;
    private float tmp;
    private float humidity;
    private float pressure;

    public WhetherData() {
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Object o: observers) {
            Observer observer = (Observer) o;
            observer.update(tmp,humidity,pressure);
        }
    }

    public void setMeasurement(float tmp, float humidity, float pressure) {
        this.tmp=tmp;
        this.humidity=humidity;
        this.pressure=pressure;
        notifyObservers();
    }
}
