package oop;

import Utilities.Utilities;
import oop.Interfaces.VehicleInterface;

import java.util.HashMap;

// Vehicle superclass, contains all the Getters and Setters for the subclasses
public class Vehicle {
    private String Owner;
    private String brand;
    private String modelName;
    private int wheels;

    public void horn() {
        System.out.println("Beep Beeeeeeep!");
    }

    //Getters & Setters
    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}

class Cars extends Vehicle implements VehicleInterface {

    public Cars() {

    }

    public void createCar(String name, String brand, String modelName, int wheelCount, HashMap<String, Vehicle> dataSet) {
        System.out.println("Creating Car");
        Cars carToAdd = new Cars();
        carToAdd.setOwner(name);
        carToAdd.setBrand(brand);
        carToAdd.setModelName(modelName);
        carToAdd.setWheels(wheelCount);

        Utilities.addCarToDataSet(carToAdd, dataSet);
        // Call Super (parent) classes horn function
        super.horn();
        horn(); //Polymorphed horn
        privateHorn(); // Separate horn
    }

    // Polymorphed horn method. Cannot have a stronger access modifier than the superclass horn method.
    public void horn() {
        System.out.println("Honkkkkkkkkkkk!\n");
    }

    private void privateHorn() {
        System.out.println("I'm a horn honk that has not been polymorphed... honk honk\n");
    }
}

