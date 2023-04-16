import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ReadStatistics {
    static long lowestBalance;
    static long highestBalance;
    static long averageBalance;

    static void lowestBalance(){
        try {
            String queryLowestBalance = "SELECT MIN(randomBalance) FROM randomClient";
            Statement stt = Connect.connection.createStatement();
            ResultSet res = stt.executeQuery(queryLowestBalance);

            while (res.next()) {
                lowestBalance = res.getLong(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void highestBalance(){
        try {
            String queryHighestBalance = "SELECT MAX(randomBalance) FROM randomClient";
            Statement stt = Connect.connection.createStatement();
            ResultSet res = stt.executeQuery(queryHighestBalance);

            while (res.next()) {
                highestBalance = res.getLong(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void averageBalance(){
        try {
            String queryAverageBalance = "SELECT AVG(randomBalance) FROM randomClient";
            Statement stt = Connect.connection.createStatement();
            ResultSet res = stt.executeQuery(queryAverageBalance);

            while (res.next()) {
                averageBalance = res.getLong(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void read(){
        lowestBalance();
        highestBalance();
        averageBalance();

        String dialog = "Lowest random balance: " + lowestBalance +
        "\nHighest random balance: " + highestBalance +
        "\nAverage random balance: " + averageBalance;

        JOptionPane.showMessageDialog(null, dialog);

        Main.menu();
    }
}
