public class CurrencyConverterSwitch
{
    public static void main(String[] args) {
        float priceUSD = 10.5f;
        float convertedPrice;
        String currency = "EUR";

        switch (currency) {
            case "RON":
                System.out.println("The price is in RON");
                convertedPrice = priceUSD * 4.7f;
                break;
            case "EUR":
                System.out.println("The price is in EUR");
                convertedPrice = priceUSD * 0.95f;
                break;
            case "RUB":
                System.out.println("The price is in RUB");
                convertedPrice = priceUSD * 100.54f;
                break;
            default:
                System.out.println("The price is in USD");
                convertedPrice = priceUSD;
        }

        System.out.printf("The converted price is: %.2f%n", convertedPrice);
    }
}
