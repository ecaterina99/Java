public class CurrencyConverter {
    public static void main(String[] args) {
        float priceUSD = 10.5f;
        float convertedPrice;
        String currency = "EUR";
        if (currency == "RON") {
            System.out.println("The price is in RON");
            convertedPrice = priceUSD * 4.7f;
        } else if (currency == "EUR") {
            System.out.println("The price is in EUR");
            convertedPrice = priceUSD * 0.95f;
        } else if (currency == "RUB") {
            System.out.println("The price is in RUB");
            convertedPrice = priceUSD * 100.54f;
        } else {
            System.out.println("The price is in USD");
            convertedPrice = priceUSD;
        }
        System.out.println("The converted price is: " + convertedPrice);
    }
}
