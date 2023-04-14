public class GenerateRandomDate {
    static String randomDate = "1970-01-01";

    static String genDate(){
        int year = (int)(Math.random() * 2024);
        int month = (int)(Math.random() * 13);
        int day = (int)(Math.random() * 29);

        if (year < 1980 || month == 0 || day == 0) {
            genDate();
        } else {
            randomDate = year + "-" + month + "-" + day;
        }
        
        return randomDate;
    }
}