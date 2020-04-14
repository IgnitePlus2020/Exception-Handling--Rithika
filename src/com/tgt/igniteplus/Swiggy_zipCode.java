//PROBLEM STATEMENT :
//Develop a method that accepts a zip code and validates against non-deliverable zip codes.
//         Example – zip codes 123, 456, 789 are non-deliverable.
//         If the customer resides at a non-deliverable zip code, throw a custom exception.
//         Handle the exception and display an appropriate message to the customer.
//         If the customer resides at a deliverable zip code, display a message “Delivery available in your area! “.
//         Invoke this method from the main function which takes the zip code as input parameter

//OUTPUT 1 :
//        Enter the zipcode : 672
//        Delivery unavailable
//OUTPUT 2 :
//        Enter the zipcode : 560043
//        Delivery available to your area



package com.tgt.igniteplus;

import java.util.ArrayList;
import java.util.Scanner;

public class Swiggy_zipCode {
    static ArrayList<Integer> arList = new ArrayList<>();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the zipcode : ");
        int zipcode = sc.nextInt();
        arList.add(123);
        arList.add(456);
        arList.add(789);
        try {
            checkCode(zipcode);
        } catch (Exception e) {
            System.out.println("Delivery unavailable");
        }
        finally {
            System.out.println("Thank you!!");
        }
    }

    public static void checkCode(int zipcode) throws InvalideCodeException {
        int flag = 0;
        for (int i = 0; i < arList.size(); i++) {
            if (Integer.toString(zipcode).length() == 6 && (zipcode != arList.get(i)))     //checking for condition
                flag = 1;
            else
                throw new InvalideCodeException("Invalid");
        }
        if (flag == 1)
            System.out.println("Delivery available to  your area!");
    }
}

class InvalideCodeException extends Exception {
    InvalideCodeException(String s) {
        super(s);
    }
}