package Ex_01;

public class MessageText implements Runnable{
    private final Counter counter;

    public MessageText(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            while (true) {
                try {
                    counter.wait();
                    if (counter.getCount() % 5 == 0) {
                        counter.wait(1000);
                        System.out.println("5 seconds passed");
                    }
                    counter.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
