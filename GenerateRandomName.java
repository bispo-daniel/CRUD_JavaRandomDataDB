import java.util.Random;

public class GenerateRandomName {
    static String genName(){
        Random randomNumber = new Random(); 
        String randomName = "";
        
        for(int x = 0; x < 10; x++){
            int numero = randomNumber.nextInt(91);

            if(numero >= 65){
                char charFromRandomNumber = (char)(numero);
                randomName += charFromRandomNumber + "";
            } else {
                x--;
            }
        }
        
        return randomName;
    }
}