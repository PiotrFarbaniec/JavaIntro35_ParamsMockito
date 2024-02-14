package task5;

public class CurrencyCalculator implements Exchangeable {
    public double buyCurrency(Currencies currency, int exchangeAmount) {
        double quantityPurchased = 0.00;
        double sellPrice = getCurrencyValuesFromDatabase(currency)[0];
        double buyPrice = getCurrencyValuesFromDatabase(currency)[1];

        if (exchangeAmount > 0 && exchangeAmount <= 1000) {
            quantityPurchased = exchangeAmount / buyPrice;
        }
        else if (exchangeAmount > 1000 && exchangeAmount <= 2500) {
            buyPrice = (buyPrice - (buyPrice - sellPrice) * 0.10);
            quantityPurchased = exchangeAmount / buyPrice;
        }
        else if (exchangeAmount > 2500 && exchangeAmount <= 5000) {
            buyPrice = (buyPrice - (buyPrice - sellPrice) * 0.25);
            quantityPurchased = exchangeAmount / buyPrice;
        }
        else if (exchangeAmount > 5000) {
            buyPrice = (buyPrice - (buyPrice - sellPrice) * 0.50);
            quantityPurchased = exchangeAmount / buyPrice;
        }
        return quantityPurchased;
    }


    @Override
    public double[] getCurrencyValuesFromDatabase(Currencies currency) {
        return new double[] {4.30, 4.35};
    }
}