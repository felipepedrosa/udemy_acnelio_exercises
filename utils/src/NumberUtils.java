package utils.src;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Utility class to be used with numbers.
 */
public final class NumberUtils {

    /**
     * Formats an amount to currency using {@link Locale} and {@link NumberFormat}.
     *
     * @param locale Locale that represents the selected region.
     * @param amount Amount to be formatted.
     * @return {@code String} containing formatted value.
     */
    public static <T extends Number> String formatAmountToCurrency(Locale locale, T amount) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

        return numberFormat.format(amount);
    }

    public static void main(String[] args) {
        String currency = formatAmountToCurrency(new Locale("pt", "BR"), 1999.98);

        System.out.println(currency); // R$ 1.999,98
    }
}
