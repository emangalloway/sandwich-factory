package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SandwichTest {
    @Test
    public void addTopping_should_grtPriceWithSize(){
        //Arrange
        Sandwich sandwich = new Sandwich(4,true,"White");
        double expectedPrice = 5.50;


        //Act
        sandwich.getPrice();


        //Assert
        Double actualPrice = sandwich.getPrice();
        assertEquals(expectedPrice,actualPrice);

    }
    @Test
    public void toString_should_haveAddedRegularToppingsInToString(){
        //Arrange
        Sandwich emanSandwich = new Sandwich(4,true,"White");
        emanSandwich.addToppings(new RegularTopping("Lettuce"));

        //Act
        emanSandwich.toString();

        //Assert
        assertTrue(emanSandwich.toString().contains("Lettuce"));

    }
  
}