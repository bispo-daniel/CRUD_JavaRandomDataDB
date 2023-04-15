public class MultithreadingDemo extends Thread {
    public void run() {
        try {
            // Create 100 clients using this thread...
            for (int x = 0; x < 100; x++) {
                CreateRandomClient.createRandomClient();
                System.out.println("Client number: " + x);
                
                // Displaying the thread that is running
                System.out.println("Thread " + Thread.currentThread().getId() + " is running\n");
            }
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}