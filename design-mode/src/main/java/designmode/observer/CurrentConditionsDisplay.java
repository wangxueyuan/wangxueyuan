package designmode.observer;

public class CurrentConditionsDisplay implements Observer {
    private float tmp;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    @Override
    public void update(float tmp, float humidity, float pressure) {
        this.tmp = tmp;
        this.humidity = humidity;
        this.pressure = pressure;
        System.out.println(String.format("temerature is %f,humidity is %f,pressure is %f", tmp, humidity, pressure));
    }

    public CurrentConditionsDisplay(WhetherData data) {
        this.weatherData = data;
        this.weatherData.registerObserver(this);
    }
}
