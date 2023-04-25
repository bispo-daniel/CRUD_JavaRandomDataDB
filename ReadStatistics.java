import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.text.NumberFormat;

import javax.swing.JOptionPane;

public class ReadStatistics {
    static ArrayList<Long> orderedBalances = new ArrayList<Long>();

    static NumberFormat fmt = NumberFormat.getCurrencyInstance();

    static long averageBalance() throws SQLException {
        long averageBalance = 0;

        String queryAverageBalance = "SELECT AVG(randomBalance) FROM randomClient";
        Statement stt = Connect.connection.createStatement();
        ResultSet res = stt.executeQuery(queryAverageBalance);

        while (res.next()) {
            averageBalance = res.getLong(1);
        }

        return averageBalance;
    }


    static long medianBalance() throws SQLException {
        long medianBalance = 0;

        String query = "SELECT randomBalance FROM randomClient ORDER BY randomBalance";
        Statement stt = Connect.connection.createStatement();
        ResultSet res = stt.executeQuery(query);

        while (res.next()) {
            long balance = res.getLong(1);
            orderedBalances.add(balance);
        }

        if(orderedBalances.size() % 2 == 1){
            int medianPosition = orderedBalances.size() / 2;
            medianBalance = orderedBalances.get(medianPosition);
        } else {
            int medianPosition01 = (orderedBalances.size() / 2) - 1;
            long medianBalance01 = orderedBalances.get(medianPosition01);

            int medianPosition02 = orderedBalances.size() / 2;
            long medianBalance02 = orderedBalances.get(medianPosition02);

            medianBalance = (medianBalance01 + medianBalance02) / 2;
        }

        return medianBalance;

    }

    static long lowestBalance() throws SQLException {
        long lowestBalance = 0;

        String queryLowestBalance = "SELECT MIN(randomBalance) from randomClient";
        Statement stt = Connect.connection.createStatement();
        ResultSet res = stt.executeQuery(queryLowestBalance);

        while (res.next()) {
            long balance = res.getLong(1);
            
            lowestBalance += balance;
        }

        return lowestBalance;
    }

    static long highestBalance() throws SQLException {
        long highestBalance = 0;

        String queryHighestBalance = "SELECT randomBalance FROM randomClient ORDER BY randomBalance DESC LIMIT 1";
        Statement stt = Connect.connection.createStatement();
        ResultSet res = stt.executeQuery(queryHighestBalance);

        while (res.next()) {
            long balance = res.getLong(1);

            highestBalance = balance;
        }

        return highestBalance;
    }

    static long totalSum() {
        long totalSum = 0;

        for (Long balance : orderedBalances) {
            totalSum += balance;
        }

        return totalSum;
    }

    static void read() throws SQLException {
        String avg = "Average balance: " + fmt.format(averageBalance()) + "\n";
        String median = "Median balance: " + fmt.format(medianBalance()) + "\n";
        String mode = "Mode balance: TO BE DEVELOPED!" + "\n";
        String min = "Lowest balance: " + fmt.format(lowestBalance()) + "\n";
        String  max = "Highest balance: " + fmt.format(highestBalance()) + "\n";
        String count = "Count n: " + orderedBalances.size() + "\n";
        String sum = "Sum: " + fmt.format(totalSum()) + "\n";

        String dialog = avg + median + mode + min + max + count + sum;

        JOptionPane.showMessageDialog(null, dialog);

        orderedBalances.clear();
        Main.menu();
    }
}