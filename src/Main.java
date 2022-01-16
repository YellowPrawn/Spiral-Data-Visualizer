// creates an instance of TheSpiraGui -- which is the JFRame that holds the other panels
public class Main {
    public static void main(String[] args) {

        String[] provinces = {"Canada", "British Columbia", "Alberta", "Saskatchewan", "Manitoba", "Ontario", "Quebec", "Newfoundland and Labrador", "New Brunswick", "Nova Scotia", "Prince Edward Island", "Yukon", "Northwest Territories", "Nunavut"};

        for(String province : provinces) {
            TheSpiralGui spiralGui = new TheSpiralGui(province);
        }
    }
}
