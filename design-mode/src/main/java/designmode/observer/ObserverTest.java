package designmode.observer;

public class ObserverTest {
    public static void main(String[] args) {
        WhetherData data = new WhetherData();
        CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(data);

        data.setMeasurement(1.23f,2.42f,3.3432f);

    }
}
