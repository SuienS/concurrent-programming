package Tutorial09.Exercise9_3;

class Consumer extends Thread {

    private final int MAX_SLEEP_TIME = 2000;  // 2 seconds

    private final Buffer buffer;              // fixed

    private final int numbItems;              // fixed


    public Consumer(Buffer buffer, int CID, int numbItems) {
        super("Consumer_" + CID);

        this.buffer = buffer;
        this.numbItems = numbItems;
    }


    public void run() {
        for (int i = 0; i < numbItems; i++) {
            int value = buffer.take();

            System.out.println(getName() + " consumed: " + value);

            try {
                sleep((int) (Math.random() * MAX_SLEEP_TIME));
            } catch (InterruptedException e) {
            }
        }

        System.out.println(getName() +
                " TOTAL Items Consumed: " +
                numbItems);

    }
}
