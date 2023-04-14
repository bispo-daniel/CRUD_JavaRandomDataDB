public class GenerateRandomBank {
    static String genBank(){
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

        return bank;
    }
}