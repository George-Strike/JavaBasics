package oop;

import java.util.HashMap;
import java.util.Scanner;  // Import the Scanner class
import Utilities.Utilities;
import oop.Interfaces.VehicleInterface;

public class OOPConcepts {
    private final VehicleInterface vehicleInterface;

    public OOPConcepts() {
        this.vehicleInterface = new Cars();
    }

    public static void main(String []args) {
        var dataSet = Utilities.createDataSet(); // Create a HashMap to use as the in memory data store
        OOPConcepts concepts = new OOPConcepts(); //initiate the object
        concepts.start(dataSet);
    }

    // This class is just here to show you that creating objects in static methods isn't different to non static methods.
    public void start(HashMap<String, Vehicle> dataSet) {
        OOPConcepts concepts = new OOPConcepts();
        concepts.GenerateVehicle(dataSet); // Initiate Generating Vehicle
    }

    private void GenerateVehicle(HashMap<String, Vehicle> dataSet) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Would you like to create a new car?");

        boolean generateNewCar = true;
        while (generateNewCar) {
            String createNewCarResponse = myObj.nextLine();
            if (createNewCarResponse.toLowerCase().equals("yes")) {
                System.out.println("Enter Name, Car Brand, Car Model, Number Of Wheels");
                //Read Vehicle Input
                String ownerName = myObj.nextLine();
                String vehicleBrand = myObj.nextLine();
                String vehicleModel = myObj.nextLine();
                int numberOfWheels = myObj.nextInt();

                vehicleInterface.createCar(ownerName, vehicleBrand, vehicleModel, numberOfWheels, dataSet);
                System.out.println("Would you like to create another car?");
                String createAnotherCar = myObj.nextLine();
                if (createAnotherCar.toLowerCase().equals("no")) {
                    break;
                }
            }
            else {
                generateNewCar = false;
            }
        }
        // Display the data stored in the in memory DB;
        Utilities.displayDataFromDataSet(dataSet);

    }
}
