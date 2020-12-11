package async_programming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AsyncExample {
    public static void main(String []args) throws ExecutionException, InterruptedException {
        AsyncExample example = new AsyncExample();
        example.basicAsyncAwaitTest();

        System.out.println("Calculating Asynchronously");
        CompletableFuture<Void> completableFuture
                = CompletableFuture.supplyAsync(() -> example.sleepThenCalculate(10))
                .thenAccept(result -> System.out.printf("Result = %d", result));
        System.out.println("Program is still running while sleepThenCalculate is being called");
        Thread.sleep(7000); //In a real app, the program will always be running so this is just to simulate that
        System.out.println("\nCalculation Finished");

    }

    public void basicAsyncAwaitTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future = completableFuture
                .thenApplyAsync(s -> s + " World\n");

        System.out.println(future.get()); //get = await.
    }

    private int sleepThenCalculate(int num) {
        var total = 0;
        try {
            Thread.sleep(4000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        total =  num * 100;
        return total;
    }

}
