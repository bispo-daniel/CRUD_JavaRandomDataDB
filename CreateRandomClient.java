import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateRandomClient {
    static void createRandomClient(){
        try {
            String sql = "INSERT INTO randomClient (randomName, randomBalance, randomDate, randomBank) values (?, ?, ?, ?)";
            PreparedStatement stt = Connect.connection.prepareStatement(sql);
            
            stt.setString(1, GenerateRandomName.genName());
            stt.setInt(2, GenerateRandomBalance.genBalance());
            stt.setString(3, GenerateRandomDate.genDate());
            stt.setString(4, GenerateRandomBank.genBank());
            stt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}