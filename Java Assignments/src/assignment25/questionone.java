package assignment25;

public class questionone extends Thread{
    @Override
    public void run(){
        for (int i=0;i<5;i++){
            System.out.println(i);
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        questionone t1 = new questionone();
        questionone t2 = new questionone();
        t1.start();
        t2.start();
    }
}







//public class MyRunnable implements Runnable {
//    public void run() {
//            System.out.println("hello");
//        }
//    public static void main(String[] args) {
//        Thread t1 = new Thread(new MyRunnable(), "Thread 1");
//        Thread t2 = new Thread(new MyRunnable(), "Thread 2");
//        t1.start();
//        t2.start();
//    }
//}
