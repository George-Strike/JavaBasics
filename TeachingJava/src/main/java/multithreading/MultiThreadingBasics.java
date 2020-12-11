package multithreading;

//Use Thread to inherit methods like Yield()
public class MultiThreadingBasics extends Thread {
    public void run()
    {
        try
        {
            // Displaying the thread that is running
            System.out.printf("Thread %d is now running\n", Thread.currentThread().getId());

        }
        catch (Exception e)
        {
            // Throwing the exception
            System.out.printf("Exception is caught: %s", e);
        }
    }
}

class SpawnMultiThreads
{
    public static void main(String[] args)
    {
        int threadsToSpawn = 5; // Number of threads to spawn
        // Loop through threadsToSpawn to spawn them
        for (int i=0; i<threadsToSpawn; i++)
        {
            MultiThreadingBasics threadObject = new MultiThreadingBasics();
            threadObject.start();
        }
    }
}

// RUNNABLE EXAMPLE
// Runnable allows for inheritance so is best to use within child classes
class RunnableMultiThreading implements Runnable
{
    public void run()
    {
        try
        {
            // Displaying the thread that is running
            System.out.printf("Thread %d is now running\n", Thread.currentThread().getId());

        }
        catch (Exception e)
        {
            // Throwing the exception
            System.out.printf("Exception is caught: %s", e);
        }
    }
}

// Main Class
class SpawnRunnableMultiThreads
{
    public static void main(String[] args)
    {
        int threadsToSpawn = 5; // Number of threads to spawn
        // Loop through threadsToSpawn to spawn them
        for (int i=0; i<threadsToSpawn; i++)
        {
            Thread thread = new Thread(new RunnableMultiThreading());
            thread.start();
        }
    }
}
