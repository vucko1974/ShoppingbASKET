package com.shopping;

/**
 * Created by ivanvuckovic on 05/10/2016.
 */
public class Offer {

    private String productName;

    private Integer requiredQuantityForOffer;

    private Double priceReduction;

    public Offer(String productName, Integer requiredQuantityForOffer, Double priceReduction){
        this.productName = productName;
        this.requiredQuantityForOffer = requiredQuantityForOffer;
        this.priceReduction = priceReduction;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getRequiredQuantityForOffer() {
        return requiredQuantityForOffer;
    }

    public Double getPriceReduction() {
        return priceReduction;
    }

}

