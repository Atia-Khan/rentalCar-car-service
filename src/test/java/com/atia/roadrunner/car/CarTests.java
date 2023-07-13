package com.atia.roadrunner.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.atia.roadrunner.car.Model.Car;

public class CarTests {
    private Car car;

    @BeforeEach
    public void setUp(){
        car = new Car();
    }

   @Test
    void testingId(){
    
        long id =  5L;
        car.setId(id);
        assertEquals(id, car.getId());
    }

   
 



 
    @Test
    void testingName(){
        String name ="Mercedes";
        car.setName(name);
        assertEquals(name, car.getName());
    }

    @Test
   void testingShortDescription(){
    String shortDesc = "The Mercedes A-Class is a true luxury vehicle, and nowhere is this more apparent than in its interior.";
    car.setShortDesc(shortDesc);
    assertEquals(shortDesc, car.getShortDesc());
   }

   @Test
   void testingLongDescription(){
    String longDesc = "Mercedes-Benz announced that it has recently sold the most expensive car at the price of $142 million (\u20AC135 million).[19] The car is a very rare 1955 Mercedes-Benz SLR that has been kept in the German automaker's collection and bought by a private owner. Mercedes in an announcement said that the sale will be used to establish the Mercedes-Benz Fund.";
    car.setLongDesc(longDesc);
    assertEquals(longDesc, car.getLongDesc());
   }

   @Test
   void testingImgLink(){
    String imgLink="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8gBI7oxsAudFxR7aQ0J2Q_KeJFd2NvJuzbg&usqp=CAU";
    car.setImgLink(imgLink);
    assertEquals(imgLink, car.getImgLink());
   }

   @Test
   void testingPricePerDay(){
    double pricePerDay  =  125000.0;
    car.setPricePerDay(pricePerDay);
    assertEquals(pricePerDay, car.getPricePerDay());

   }








}
