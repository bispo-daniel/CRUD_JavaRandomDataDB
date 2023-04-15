public class Main {
    static void executeWithThreading(){

        int n = 2; // Number of threads
        for (int i = 0; i < n; i++) {
            MultithreadingDemo object = new MultithreadingDemo();
            object.start();
        }

    }
    public static void main(String[] args) {

        Connect.getConnection();

        // for(int x = 0; x < 2000; x++){
        //     CreateRandomClient.createRandomClient();
        //     System.out.println(x);
        // }

        executeWithThreading();

    }
}