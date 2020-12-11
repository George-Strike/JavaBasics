package Utilities;

import oop.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;

public class Utilities {
    public static HashMap<String, Vehicle> createDataSet() {
        return new HashMap<String, Vehicle>();
    }

    public static void addCarToDataSet(Vehicle car, HashMap<String, Vehicle> dataSet) {

        dataSet.put(car.getOwner(), car);
    }

    public static void displayDataFromDataSet(HashMap<String, Vehicle> dataSet) {
        dataSet.entrySet().forEach(value -> System.out.printf("Owner: %s, Brand: %s, Model: %s, Wheels: %d", value.getKey(),
                value.getValue().getBrand(), value.getValue().getModelName(), value.getValue().getWheels()));

    }
}
