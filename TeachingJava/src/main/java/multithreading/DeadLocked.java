package multithreading;

// Taken from https://www.geeksforgeeks.org/deadlock-in-java-multithreading/?ref=rp
// https://www.tutorialspoint.com/java/java_thread_deadlock.htm
public class DeadLocked {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    public static void main(String args[]) {
        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();
        T1.start();
        T2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (Lock1) {
                System.out.println("Thread 1: Holding lock 1...");

                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (Lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (Lock1) {
                System.out.println("Thread 2: Holding lock 2...");

                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 1...");

                synchronized (Lock2) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}

/*
The above program will hang forever because neither of the threads are in position to proceed and are waiting for each
other to release the lock, so you can come out of the program by pressing CTRL+C.

IMPORTANT NOTES
-If threads are waiting for each other to finish, then the condition is known as Deadlock.
-Deadlock condition is a complex condition which occurs only in case of multiple threads.
-Deadlock condition can break our code at run time and can destroy business logic.
-We should avoid this condition as much as we can.
*/
