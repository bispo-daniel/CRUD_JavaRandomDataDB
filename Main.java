public class Main {
    public static void main(String[] args) {

        Connect.getConnection();

        for(int x = 0; x < 10; x++){
            CreateRandomClient.createRandomClient();
        }

    }
}