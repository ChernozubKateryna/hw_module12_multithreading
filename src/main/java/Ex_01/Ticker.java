package Ex_01;

public class Ticker implements Runnable{
    private final Counter counter;

    public Ticker(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(counter.getCount());
                    counter.incrementCount();
                    counter.notifyAll();
                    counter.wait(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}