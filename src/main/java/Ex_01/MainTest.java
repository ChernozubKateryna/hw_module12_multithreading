package Ex_01;

public class MainTest {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread tickerThread = new Thread((new Ticker(counter)));
        Thread messageThread = new Thread((new MessageText(counter)));

        tickerThread.start();
        messageThread.start();
    }
}
