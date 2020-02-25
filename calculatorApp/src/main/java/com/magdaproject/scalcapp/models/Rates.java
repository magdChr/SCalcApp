package com.magdaproject.scalcapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates {

    public void setAud(Double aud) {
        this.aud = aud;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }

    public Double getUsd() {
        return usd;
    }

    public Double getEur() {
        return eur;
    }

    public Double getJpy() {
        return jpy;
    }

    public Double getGbp() {
        return gbp;
    }

    public Double getChf() {
        return chf;
    }

    public Double getSek() {
        return sek;
    }

    public Double getAud() {
        return aud;
    }


    @SerializedName("EUR")
    @Expose
    private Double eur;
    @SerializedName("JPY")
    @Expose
    private Double jpy;
    @SerializedName("GBP")
    @Expose
    private Double gbp;
    @SerializedName("CHF")
    @Expose
    private Double chf;
    @SerializedName("SEK")
    @Expose
    private Double sek;
    @SerializedName("AUD")
    @Expose
    private Double aud;
    @SerializedName("USD")
    @Expose
    private Double usd;









}

