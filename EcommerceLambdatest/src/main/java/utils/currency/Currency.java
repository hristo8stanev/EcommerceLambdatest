package utils.currency;

import java.text.NumberFormat;
import java.util.Locale;

public class Currency {

    public static NumberFormat getDollarFormat() {
        return NumberFormat.getCurrencyInstance(Locale.US);
    }

    public static NumberFormat getEuroFormat(){
        return NumberFormat.getCurrencyInstance(Locale.FRENCH);
    }

    public static NumberFormat getPoundFormat(){
        return NumberFormat.getCurrencyInstance(Locale.UK);
    }

}