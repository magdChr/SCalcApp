package com.magdaproject.scalcapp.helpers;

import java.util.ArrayList;
import java.util.Collections;

public class CurrencyHelper {

    public static ArrayList<String> constructCurrenciesList() {
       ArrayList<String> currencies = new ArrayList<>();
        Collections.addAll(currencies, "EUR","JPY","GBP","CHF","SEK","AUD","USD");
        return currencies;
    }
}
