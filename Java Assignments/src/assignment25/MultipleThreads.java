public class MultipleThreads extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        MultipleThreads t1 = new MultipleThreads();
        MultipleThreads t2 = new MultipleThreads();
        t1.start();
        t2.start();
    }
}
