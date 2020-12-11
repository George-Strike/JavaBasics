package oop.Interfaces;

import oop.Vehicle;

import java.util.HashMap;

public interface VehicleInterface {
    void createCar(String name, String brand, String modelName, int wheelCount, HashMap<String, Vehicle> dataSet);
}
