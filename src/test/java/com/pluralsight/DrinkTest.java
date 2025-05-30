package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {
    @Test
    public void drink_should_getPriceWithSize(){
        //Arrange
        Drink emanuelDrink = new Drink("Fanta","Medium");
        double expectedValue = 2.50;

        //Act
        emanuelDrink.getPrice();

        //Assert
        double actualPrice = emanuelDrink.getPrice();
        assertEquals(expectedValue,actualPrice);

    }

}