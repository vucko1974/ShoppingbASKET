package com.shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ivanvuckovic on 05/10/2016.
 */
public class CheckoutBasket {

    private Double totalPrice = new Double(0.00);

    private List<Product> basketItems = new ArrayList<>(10);

    private List<Offer> offers = new ArrayList<>(10);

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<Product> getBasketItems() {
        return basketItems;
    }

    public void addItemToBasket(Product item){
        basketItems.add(item);
        //totalPrice = calcualteTotal();
    }

    public void removeItemFromBasket(Product item){
        basketItems.remove(item);
        //totalPrice = calcualteTotal();
    }

    public void removeAllItemsFromBasket(){
        basketItems.clear();
        this.totalPrice = 0.00;
    }

    public Double getTotalPrice(){
        return this.totalPrice = calcualteTotal();
    }

    private Double calcualteTotal(){
        Double newTotal = 0.00;

        for(Product item : basketItems ){
            newTotal = newTotal + item.getPrice();
        }

        newTotal = newTotal - applyOffers();

        return newTotal;
    }

    private Double applyOffers(){
        Double offerReduction = 0.0;

        HashMap<String, ArrayList<Product>> sortedProducts = sortBasket();

        Iterator<String> productNames = sortedProducts.keySet().iterator();

        while(productNames.hasNext()) {
            String productName = productNames.next();
            List<Product> products = sortedProducts.get(productName);
            Offer offer = findOffer(productName);
            if(offer != null){
                Double reduction = products.size()/offer.getRequiredQuantityForOffer() * offer.getPriceReduction();
                offerReduction = offerReduction + reduction;
            }
        }

        return offerReduction;
    }

    private HashMap<String, ArrayList<Product>> sortBasket() {
        HashMap<String, ArrayList<Product>> sortedProducts = new HashMap<>();

        for(Product item : basketItems) {
            if (sortedProducts.containsKey(item.getName())) {
                sortedProducts.get(item.getName()).add(item);
            } else {
                ArrayList<Product> sameProducts = new ArrayList<>();
                sameProducts.add(item);
                sortedProducts.put(item.getName(), sameProducts);
            }
        }

        return sortedProducts;
    }

    private Offer findOffer(String productName){
        for(Offer offer : this.offers){
            if(offer.getProductName().equalsIgnoreCase(productName)){
                return offer;
            }
        }

        return null;
    }

}

