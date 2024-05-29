package Utils.currency;

import java.text.NumberFormat;
import java.util.Locale;

public class Currency {

    public static NumberFormat getDollarFormat() {
        return NumberFormat.getCurrencyInstance(Locale.US);
    }
}