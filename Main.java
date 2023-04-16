import javax.swing.*;

public class Main {
    // static void executeWithThreading(){
    //     int n = 2; // Number of threads
    //     for (int i = 0; i < n; i++) {
    //         MultithreadingDemo object = new MultithreadingDemo();
    //         object.start();
    //     }
    // }

    static void insertIntoDB(){
        String timesString = JOptionPane.showInputDialog(null, "How many random clients?");
        int times = Integer.parseInt(timesString);

        for (int i = 1; i <= times; i++) {
            CreateRandomClient.createRandomClient();

            if(i == times){
                String dialog = "%d client's successfully created!";
                JOptionPane.showMessageDialog(null, String.format(dialog, i));
            }
        }

        menu();
    }

    static void menu(){
        String optionString = JOptionPane.showInputDialog(null, "Welcome!\n\n What do you want to do?\n 1- Insert random clients\n 2- Get clients' accounts statistics\n 0- Exit");
        int option = Integer.parseInt(optionString);

        switch (option) {
            case 0:
                System.exit(0);
                break;
            case 1:
                insertIntoDB();
                break;
            case 2:
                ReadStatistics.read();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Type a valid option...");
                menu();
                break;
        }

    }
    public static void main(String[] args) {

        Connect.getConnection();
        menu();

        // executeWithThreading();

    }
}