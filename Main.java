import java.util.Locale;
import java.util.Random;
import java.text.NumberFormat;

public class Main {

    static void generateRandomName(){
        Random random = new Random(); 
        String newString = "";
        
        for(int x = 0; x < 10; x++){
            int numero = random.nextInt(91);

            if(numero >= 65){
                char charFromRandomNumber = (char)(numero);
                newString += charFromRandomNumber + "";
            } else {
                x--;
            }
        }
        
        System.out.println("New random client name: " + newString);
    }


    static void generateRandomBalance(){
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

        System.out.println("New random balance: " + NumberFormat.getCurrencyInstance(Locale.US).format(randomBalance) + " [" + randomToDecide + "]");
    }

    static void generateRandomBank(){
        int randomToDecide = (int)(Math.random() * 101);
        String bank;

        if(randomToDecide < 25){
            bank = "Credit Suisse";
        } else if(randomToDecide < 51){
            bank = "SoftBank";
        } else if(randomToDecide < 76){
            bank = "Banco do Brasil";
        } else {
            bank = "Lehman Brothers";
        }

        System.out.println("New random bank: " + bank);
    }


    public static void main(String[] args) {

        for(int x = 0; x < 1000; x++){
            generateRandomName();
            generateRandomBalance();
            generateRandomBank();
            System.out.println("\n");
        }

    }
}