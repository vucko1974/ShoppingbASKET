package com.shopping;

import com.shopping.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by ivanvuckovic on 05/10/2016.
 */

public class CheckoutBasketTest {

    private static CheckoutBasket basket;

    @BeforeClass
    public static void runOnceBeforeClass() {
        basket = new CheckoutBasket();
    }

    @Before
    public void runBeforeTestMethod() {
        basket.removeAllItemsFromBasket();
    }

    @Test
    public void addItems(){
        Food apple = new Food("apple", new Double(0.60));
        basket.addItemToBasket(apple);
        Food lemon = new Food("lemon", new Double(0.25));
        basket.addItemToBasket(lemon);
        assertEquals(2, basket.getBasketItems().size());
    }

    @Test
    public void removeAllItems(){
        Food apple = new Food("apple", new Double(0.60));
        basket.addItemToBasket(apple);
        Food lemon = new Food("lemon", new Double(0.25));
        basket.addItemToBasket(lemon);
        assertEquals(2, basket.getBasketItems().size());

        basket.removeAllItemsFromBasket();
        assertTrue(basket.getBasketItems().isEmpty());
    }

    @Test
    public void removeSingleItemFromBasket(){
        Food apple = new Food("apple", new Double(0.60));
        basket.addItemToBasket(apple);
        Food lemon = new Food("lemon", new Double(0.25));
        basket.addItemToBasket(lemon);
        assertEquals(2, basket.getBasketItems().size());
        basket.removeItemFromBasket(apple);
        assertEquals(1, basket.getBasketItems().size());
    }

    @Test
    public void calculatePriceWithoutOffers(){
        Food apple = new Food("apple", new Double(0.60));
        basket.addItemToBasket(apple);
        Food lemon = new Food("lemon", new Double(0.25));
        basket.addItemToBasket(lemon);

        assertEquals(new Double(0.85), basket.getTotalPrice());
    }

    @Test
    public void calculatePriceWithOffers(){
        Food apple = new Food("apple", new Double(0.60));
        Food lemon = new Food("lemon", new Double(0.25));

        basket.addItemToBasket(apple);
        basket.addItemToBasket(lemon);
        basket.addItemToBasket(apple);
        basket.addItemToBasket(lemon);
        basket.addItemToBasket(lemon);
        basket.addItemToBasket(apple);
        basket.addItemToBasket(apple);

        Offer twoForOneApple = new Offer(apple.getName(),2, apple.getPrice());
        Offer threeForTwoLemons = new Offer(lemon.getName(),3, lemon.getPrice());

        List<Offer> offers = new ArrayList<>();
        offers.add(twoForOneApple);
        offers.add(threeForTwoLemons);
        basket.setOffers(offers);

        assertEquals(new Double(1.70), basket.getTotalPrice() );


    }

}
