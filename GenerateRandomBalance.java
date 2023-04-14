import java.util.Random;

public class GenerateRandomBalance {
    static int genBalance(){
        Random random = new Random(); 

        int randomToDecide = (int)(Math.random() * 101);
        int randomBalance;

        if(randomToDecide < 52){
            randomBalance = random.nextInt(9999);
        } else if(randomToDecide < 81){
            randomBalance = random.nextInt(999999);
        } else if(randomToDecide < 93){
            randomBalance = random.nextInt(999999999);
        } else {
            randomBalance = random.nextInt(2147483647);
        }

        return randomBalance;
    }
}
