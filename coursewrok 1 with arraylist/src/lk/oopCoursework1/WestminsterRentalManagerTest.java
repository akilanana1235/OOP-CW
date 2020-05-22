package lk.oopCoursework1;

import org.junit.Test;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static org.junit.Assert.*;

public class WestminsterRentalManagerTest implements RentalVehicleManager {

    private Car extendCar = new Car();
    private Motorbike extendmotorbike = new Motorbike();

    private ArrayList<Vehicle> listOfVehicles;
    private Vehicle vehicle;

    public WestminsterRentalManagerTest() {
        listOfVehicles = new ArrayList<Vehicle>();
    }

    @Test
    public void addVehicle() {
        if(listOfVehicles.size()<maxParking){
            listOfVehicles.add(vehicle);
        }
        else {
            System.out.println("Sorry the Parking is full!!");
        }
    }

    @Test
    public void addVehicle1() {
        if(listOfVehicles.size()<maxParking) {
            Scanner scannerOptionInput = new Scanner(System.in);
            System.out.print("\n" +
                    "Select vehicle type" +
                    "\n" +
                    "1. Car \n" +
                    "2. Motorbike \n" +
                    "3. Main Menu\n" +
                    "Choose: ");
            int optionVehicle = 1;
            while (!(optionVehicle==(int)optionVehicle)) {
                System.out.println("Invalid Data Type!!");
//                scannerOptionInput.next();
                System.out.print("Select vehicle type" +
                        "\n" +
                        "1. Car \n" +
                        "2. Motorbike \n" +
                        "3. Main Menu\n" +
                        "Choose: ");
            }
            optionVehicle = 2;

            while (optionVehicle != 3) {
                if (optionVehicle == 1) {

                    Scanner scannerCarInput = new Scanner(System.in);
                    System.out.print("Enter Plate number (WP ABC-1234): ");
                    String carPlateNumberInput = "WP ABC-1234"; //plate number input.

                    System.out.print("Enter Make: ");
                    String carMakeInput = "Toyota"; //make input.

                    int carNumberOfAirbags = 2;
                    System.out.print("Enter the number of Airbags: ");
                    while (!(carNumberOfAirbags==(int)carNumberOfAirbags)) {
                        System.out.println("Invalid Data Type!!");
                        scannerCarInput.next();
                        System.out.print("Enter the number of Airbags: "); //number of air bags input.
                    }
                    carNumberOfAirbags  = 2;


                    int carFuelTypeInput =92;
                    System.out.print("Enter the fuel fuel type (92, 95): "); //getting the fuel type.
                    while (!(carFuelTypeInput==(int)carFuelTypeInput)) {
                        System.out.println("Invalid Data Type!!");
//                        scannerCarInput.next();
                        System.out.print("Enter the fuel fuel type (92, 95): ");
                    }
                    carFuelTypeInput = 92;
                    while (!(carFuelTypeInput == 92 || carFuelTypeInput == 95)) {
                        System.out.println("Enter the correct fuel type!! \n" +
                                "Enter the fuel fuel type (92, 95):");
                        while (!(carFuelTypeInput==(int)carFuelTypeInput)) {
                            System.out.println("Invalid Data Type!!");
//                            scannerCarInput.next();
                            System.out.print("Enter the fuel fuel type (92, 95): ");
                        }
                        carFuelTypeInput = 92;
                    }

                    int carNumberOfSeats = 4;
                    System.out.print("Enter the number of seats: "); //getting the number of seats.
                    while (!(carNumberOfSeats==(int)carNumberOfSeats)) {
                        System.out.println("Invalid Data Type!!");
//                        scannerCarInput.next();
                        System.out.print("Enter the number of seats: ");
                    }

                    carNumberOfSeats = 4;

                    int carNumberOfPassengers = 4;
                    double carPricePerKm = 50;
                    String carType = "Car";
                    extendCar.setNumberOfPassengers(carNumberOfPassengers); //inserting the data to the arraylist.
                    extendCar.setPricePerKm(carPricePerKm);
                    extendCar.setVehicleType(carType);
                    Car car = new Car(carPlateNumberInput, carMakeInput, carNumberOfPassengers, carPricePerKm, carType, carNumberOfAirbags, carFuelTypeInput, carNumberOfSeats);
                    addVehicle(car);
                    System.out.println(car);
                } else if (optionVehicle == 2) {

                    Scanner scannerBikeInput = new Scanner(System.in);//getting the plate number.
                    System.out.print("Enter Plate number (WP ABC-1234): ");
                    String bikePlateNumberInput = "WP CCA-1414";

                    System.out.print("Enter Make: ");//getting the make.
                    String carMakeInput = "Yamaha";

                    int bikeNumberOfGears = 5;
                    System.out.print("Enter the number of gears: ");//getting the number of gears.
                    while (!(bikeNumberOfGears==(int)bikeNumberOfGears)) {
                        System.out.println("Invalid Data Type!!");
//                        scannerBikeInput.next();
                        System.out.print("Enter the number of gears: ");
                    }
                    bikeNumberOfGears = 5;

                    int bikeWheelDiameterInput = 16;
                    System.out.print("Enter the wheel diameter (15, 16, 17): ");//getting the wheel diameter.
                    while (!(bikeNumberOfGears==(int)bikeNumberOfGears)) {
                        System.out.println("Invalid Data Type!!");
//                        scannerBikeInput.next();
                        System.out.print("Enter the wheel diameter (15, 16, 17): ");
                    }
                    bikeWheelDiameterInput = 16;

                    int bikeNumberOfHelmets = 2;

                    System.out.print("Enter the number of helmets: ");//getting the number of helmets.
                    while (!(bikeNumberOfHelmets==(int)bikeNumberOfHelmets)) {
                        System.out.println("Invalid Data Type!!");
//                        scannerBikeInput.next();
                        System.out.print("Enter the number of helmets: ");
                    }
                    bikeNumberOfHelmets = 2;

                    int bikeNumberOfPassengers = 2;
                    double bikePricePerKm = 30;
                    String bikeType = "Motorbike";
                    extendmotorbike.setNumberOfPassengers(bikeNumberOfPassengers); //inserting the data to the arraylist.
                    extendmotorbike.setPricePerKm(bikePricePerKm);
                    extendmotorbike.setVehicleType(bikeType);
                    Motorbike motorbike = new Motorbike(bikePlateNumberInput, carMakeInput, bikeNumberOfPassengers, bikePricePerKm, bikeType, bikeNumberOfGears, bikeWheelDiameterInput, bikeNumberOfHelmets);
                    addVehicle(motorbike);
                    System.out.println(motorbike);
                } else {
                    System.out.println("Invalid option!! Re-enter.. ");
                    break;
                }
                break;
            }
        }else{
            System.out.println("Sorry, the parking is full!!");
        }
    }

    private void addVehicle(Vehicle vehicle) {
    }

    @Test
    public void deleteVehicle() {
        System.out.format("_%1$-20s_%2$-20s_%3$-20s\n","_____________________","_____________________","___________________");
        System.out.format("|%1$-20s|%2$-20s|%3$-20s|\n","       TYPE","    PLATE NUMBER","        MAKE ");
        System.out.format("_%1$-20s_%2$-20s_%3$-20s\n","_____________________","_____________________","___________________");
        System.out.format("%1$-20s%2$-20s%3$-20s\n","","","");
        for(int i=0; i<listOfVehicles.size(); i++){
            System.out.format("|%1$-20s|%2$-20s|%3$-20s|\n",listOfVehicles.get(i).getVehicleType(),"    "+listOfVehicles.get(i).getPlateNumber(),"  "+listOfVehicles.get(i).getMake());
        }
        System.out.format("_%1$-20s_%2$-20s_%3$-20s\n","_____________________","_____________________","___________________");
//        Scanner deleteVehicleInput = new Scanner(System.in);
        System.out.print("\n" +
                "Select vehicle type you want to delete" +
                "\n" +
                "1. Car \n" +
                "2. Motorbike \n" +
                "3. Main Menu\n" +
                "Choose: ");
        int deleteVehicleInput = 1;
        while (!(deleteVehicleInput==(int)deleteVehicleInput)){
            System.out.println("Invalid Data Type!!");
//            deleteVehicleInput.next();
            System.out.print("Select vehicle type you want to delete" +
                    "\n" +
                    "1. Car \n" +
                    "2. Motorbike \n"+
                    "3. Main Menu\n" +
                    "Choose: ");
        }
        int optionDeleteVehicle = 1;
        while (optionDeleteVehicle!=3) {
            if (optionDeleteVehicle == 1) {
                String vehicleType = "Car";
//                Scanner scannerDeleteVehicle = new Scanner(System.in);
                System.out.print("Enter the plate number of the vehicle that you want to remove (WP ABC-1234): ");
                String deletePlateNumberInput = "WP CAA-2015"; //getting the plate number to delete the vehicle.
                if (listOfVehicles.removeIf(removeVehicle -> removeVehicle.getPlateNumber().equals(deletePlateNumberInput))) { //deleting the vehicle.
                    System.out.println("Plate Number " + deletePlateNumberInput + ", " + vehicleType + " has been removed.");
                    System.out.println(50-listOfVehicles.size() + " spaces are available for parking");
                } else {
                    System.out.println("Plate number does not exists!!");//if the plate number is not available, it will pop this message.
                }
            } else if (optionDeleteVehicle == 2) {
                String vehicleType = "Motorbike";
                Scanner scannerDeleteVehicle = new Scanner(System.in);
                System.out.print("Enter the plate number of th vehicle that you want to remove (WP ABC-1234): ");
                String deletePlateNumberInput = "WP CCV*-2015"; //getting the plate number to delete the vehicle.
                if (listOfVehicles.removeIf(removeVehicle -> removeVehicle.getPlateNumber().equals(deletePlateNumberInput))) { //deleting the vehicle.
                    System.out.println("Plate Number " + deletePlateNumberInput + ", " + vehicleType + " has been removed.");
                    System.out.println(50-listOfVehicles.size() + " spaces are available for parking");
                } else {
                    System.out.println("Plate number does not exists!!"); //if the plate number is not available, it will pop this message.
                }
            } else {
                System.out.println("Invalid option!! Re-enter.. ");
            }
            break;
        }

    }

    @Test
    public void printVehicleList() {
        Collections.sort(listOfVehicles, new Comparator<Vehicle>() { //sorting the vehicle list according to the vehicle make.
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return String.valueOf(o1.getMake()).compareTo(o2.getMake());
            }
            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        System.out.format("_%1$-20s_%2$-20s_%3$-20s\n","_____________________","_____________________","___________________");
        System.out.format("|%1$-20s|%2$-20s|%3$-20s|\n","       TYPE","    PLATE NUMBER","        MAKE ");
        System.out.format("_%1$-20s_%2$-20s_%3$-20s\n","_____________________","_____________________","___________________");
        System.out.format("%1$-20s%2$-20s%3$-20s\n","","","");
        for(int i=0; i<listOfVehicles.size(); i++){
            System.out.format("|%1$-20s|%2$-20s|%3$-20s|\n",listOfVehicles.get(i).getVehicleType(),"    "+listOfVehicles.get(i).getPlateNumber(),"  "+listOfVehicles.get(i).getMake());
        }
        System.out.format("_%1$-20s_%2$-20s_%3$-20s\n","_____________________","_____________________","___________________");
    }

    @Test
    public void saveVehicleList() {
        File file = new File("VehicleList.txt");
        try{
            FileWriter fileWriter = new FileWriter(file);
            Writer output = new BufferedWriter(fileWriter);
            int size = listOfVehicles.size();

            for(int i=0; i<size; i++ ){
                output.write(listOfVehicles.get(i).toString()+ "\n");
            }output.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Cannot create the file.");
        }
        System.out.println("Successfully save to the file VehicleList.txt");
    }

    @Test
    public void saveInDatabase() {
    }
}