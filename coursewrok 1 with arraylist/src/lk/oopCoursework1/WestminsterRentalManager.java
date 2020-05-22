package lk.oopCoursework1;

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class WestminsterRentalManager implements RentalVehicleManager{

    private Car extendCar = new Car();
    private Motorbike extendmotorbike = new Motorbike();

    private  ArrayList<Vehicle> listOfVehicles;

    public WestminsterRentalManager(){
     listOfVehicles = new ArrayList<Vehicle>(); //creating the arraylist for cars and motobikes.

     ConnectionClass connectionClass = new ConnectionClass(); //getting the database connection
     Connection connection =connectionClass.getConnection();

     try{
         //getting the data of cars from the database and putting them in to the array list.
         PreparedStatement selectCar =connection.prepareStatement("select * from vehicles where(VehicleType='Car');");
         ResultSet resultSetCar = selectCar.executeQuery();
         while (resultSetCar.next()){
             Car objectCar = new Car(
                     resultSetCar.getString("VehiclePlateNumber"),
                     resultSetCar.getString("VehicleMake"),
                     resultSetCar.getInt("NumberOfPassengers"),
                     resultSetCar.getDouble("PricePerKM"),
                     resultSetCar.getString("VehicleType"),
                     resultSetCar.getInt("NumberOfAirbags"),
                     resultSetCar.getInt("FuelType"),
                     resultSetCar.getInt("NumberOfSeats")
             );
             listOfVehicles.add(objectCar);

             //deleting the cars from the database.
             Statement statement  =connection.createStatement();
             String sql = "delete from vehicles where VehicleType='Car'";
             statement.executeUpdate(sql);
         }
         //getting the data of motorbikes from the database and putting them in to the array list.
         PreparedStatement selectBike = connection.prepareStatement("select * from vehicles where (VehicleType='Motorbike');");
         ResultSet resultSetBike = selectBike.executeQuery();
         while (resultSetBike.next()){
             Motorbike objectBike = new Motorbike(
                     resultSetBike.getString("VehiclePlateNumber"),
                     resultSetBike.getString("VehicleMake"),
                     resultSetBike.getInt("NumberOfPassengers"),
                     resultSetBike.getDouble("PricePerKM"),
                     resultSetBike.getString("VehicleType"),
                     resultSetBike.getInt("NumberOfGears"),
                     resultSetBike.getInt("WheelDiameter"),
                     resultSetBike.getInt("NumberOfHelmets")
             );
             listOfVehicles.add(objectBike);

             //deleting the cars from the database.
             Statement statement  =connection.createStatement();
             String sql = "delete from vehicles where VehicleType='Motorbike'";
             statement.executeUpdate(sql);
         }
     }catch (Exception exc){
         exc.printStackTrace();
     }
    }

    public void addVehicle(Vehicle vehicle){
        if(listOfVehicles.size()<maxParking){
            listOfVehicles.add(vehicle);
        }
        else {
            System.out.println("Sorry the Parking is full!!");
        }
    }

    //method to add vehicles from the console to the array.
    @Override
    public void addVehicle() {
        //This will check whether the parking is full or not.
        if(listOfVehicles.size()<maxParking) {
            Scanner scannerOptionInput = new Scanner(System.in);
            System.out.print("\n" +
                    "Select vehicle type" +
                    "\n" +
                    "1. Car \n" +
                    "2. Motorbike \n" +
                    "3. Main Menu\n" +
                    "Choose: ");
            while (!scannerOptionInput.hasNextInt()) {
                System.out.println("Invalid Data Type!!");
                scannerOptionInput.next();
                System.out.print("Select vehicle type" +
                        "\n" +
                        "1. Car \n" +
                        "2. Motorbike \n" +
                        "3. Main Menu\n" +
                        "Choose: ");
            }
            int optionVehicle = scannerOptionInput.nextInt();

            while (optionVehicle != 3) {
                if (optionVehicle == 1) {

                    Scanner scannerCarInput = new Scanner(System.in);
                    System.out.print("Enter Plate number (WP ABC-1234): ");
                    String carPlateNumberInput = scannerCarInput.nextLine().toUpperCase(); //plate number input.

                    System.out.print("Enter Make: ");
                    String carMakeInput = scannerCarInput.nextLine(); //make input.
                    System.out.print("Enter the number of Airbags: ");

                    while (!scannerCarInput.hasNextInt()) {
                        System.out.println("Invalid Data Type!!");
                        scannerCarInput.next();
                        System.out.print("Enter the number of Airbags: "); //number of air bags input.
                    }
                    int carNumberOfAirbags = scannerCarInput.nextInt();

                    System.out.print("Enter the fuel fuel type (92, 95): "); //getting the fuel type.
                    while (!scannerCarInput.hasNextInt()) {
                        System.out.println("Invalid Data Type!!");
                        scannerCarInput.next();
                        System.out.print("Enter the fuel fuel type (92, 95): ");
                    }
                    int carFuelTypeInput = scannerCarInput.nextInt();
                    while (!(carFuelTypeInput == 92 || carFuelTypeInput == 95)) {
                        System.out.println("Enter the correct fuel type!! \n" +
                                "Enter the fuel fuel type (92, 95):");
                        while (!scannerCarInput.hasNextInt()) {
                            System.out.println("Invalid Data Type!!");
                            scannerCarInput.next();
                            System.out.print("Enter the fuel fuel type (92, 95): ");
                        }
                        carFuelTypeInput = scannerCarInput.nextInt();
                    }

                    System.out.print("Enter the number of seats: "); //getting the number of seats.
                    while (!scannerCarInput.hasNextInt()) {
                        System.out.println("Invalid Data Type!!");
                        scannerCarInput.next();
                        System.out.print("Enter the number of seats: ");
                    }

                    int carNumberOfSeats = scannerCarInput.nextInt();
                    int carNumberOfPassengers = 4;
                    double carPricePerKm = 50;
                    String carType = "Car";
                    extendCar.setNumberOfPassengers(carNumberOfPassengers); //inserting the data to the arraylist.
                    extendCar.setPricePerKm(carPricePerKm);
                    extendCar.setVehicleType(carType);
                    Car car = new Car(carPlateNumberInput, carMakeInput, carNumberOfPassengers, carPricePerKm, carType, carNumberOfAirbags, carFuelTypeInput, carNumberOfSeats);
                    addVehicle(car);
                } else if (optionVehicle == 2) {

                    Scanner scannerBikeInput = new Scanner(System.in);//getting the plate number.
                    System.out.print("Enter Plate number (WP ABC-1234): ");
                    String bikePlateNumberInput = scannerBikeInput.nextLine().toUpperCase();

                    System.out.print("Enter Make: ");//getting the make.
                    String carMakeInput = scannerBikeInput.nextLine();

                    System.out.print("Enter the number of gears: ");//getting the number of gears.
                    while (!scannerBikeInput.hasNextInt()) {
                        System.out.println("Invalid Data Type!!");
                        scannerBikeInput.next();
                        System.out.print("Enter the number of gears: ");
                    }
                    int bikeNumberOfGears = scannerBikeInput.nextInt();

                    System.out.print("Enter the wheel diameter (15, 16, 17): ");//getting the wheel diameter.
                    while (!scannerBikeInput.hasNextInt()) {
                        System.out.println("Invalid Data Type!!");
                        scannerBikeInput.next();
                        System.out.print("Enter the wheel diameter (15, 16, 17): ");
                    }
                    int bikeWheelDiameterInput = scannerBikeInput.nextInt();

                    System.out.print("Enter the number of helmets: ");//getting the number of helmets.
                    while (!scannerBikeInput.hasNextInt()) {
                        System.out.println("Invalid Data Type!!");
                        scannerBikeInput.next();
                        System.out.print("Enter the number of helmets: ");
                    }
                    int bikeNumberOfHelmets = scannerBikeInput.nextInt();

                    int bikeNumberOfPassengers = 2;
                    double bikePricePerKm = 30;
                    String bikeType = "Motorbike";
                    extendmotorbike.setNumberOfPassengers(bikeNumberOfPassengers); //inserting the data to the arraylist.
                    extendmotorbike.setPricePerKm(bikePricePerKm);
                    extendmotorbike.setVehicleType(bikeType);
                    Motorbike motorbike = new Motorbike(bikePlateNumberInput, carMakeInput, bikeNumberOfPassengers, bikePricePerKm, bikeType, bikeNumberOfGears, bikeWheelDiameterInput, bikeNumberOfHelmets);
                    addVehicle(motorbike);
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

    //method to delete vehicles from the console to the array.
    @Override
    public void deleteVehicle() {
        //print the list of vehicles in the arraylist to make it easy to delete.
        System.out.format("_%1$-20s_%2$-20s_%3$-20s\n","_____________________","_____________________","___________________");
        System.out.format("|%1$-20s|%2$-20s|%3$-20s|\n","       TYPE","    PLATE NUMBER","        MAKE ");
        System.out.format("_%1$-20s_%2$-20s_%3$-20s\n","_____________________","_____________________","___________________");
        System.out.format("%1$-20s%2$-20s%3$-20s\n","","","");
        for(int i=0; i<listOfVehicles.size(); i++){
            System.out.format("|%1$-20s|%2$-20s|%3$-20s|\n",listOfVehicles.get(i).getVehicleType(),"    "+listOfVehicles.get(i).getPlateNumber(),"  "+listOfVehicles.get(i).getMake());
        }
        System.out.format("_%1$-20s_%2$-20s_%3$-20s\n","_____________________","_____________________","___________________");
        Scanner deleteVehicleInput = new Scanner(System.in);
        System.out.print("\n" +
                "Select vehicle type you want to delete" +
                "\n" +
                "1. Car \n" +
                "2. Motorbike \n" +
                "3. Main Menu\n" +
                "Choose: ");
        while (!deleteVehicleInput.hasNextInt()){
            System.out.println("Invalid Data Type!!");
            deleteVehicleInput.next();
            System.out.print("Select vehicle type you want to delete" +
                    "\n" +
                    "1. Car \n" +
                    "2. Motorbike \n"+
                    "3. Main Menu\n" +
                    "Choose: ");
        }
        int optionDeleteVehicle = deleteVehicleInput.nextInt();
        while (optionDeleteVehicle!=3) {
            if (optionDeleteVehicle == 1) {
                String vehicleType = "Car";
                Scanner scannerDeleteVehicle = new Scanner(System.in);
                System.out.print("Enter the plate number of the vehicle that you want to remove (WP ABC-1234): ");
                String deletePlateNumberInput = scannerDeleteVehicle.nextLine().toUpperCase(); //getting the plate number to delete the vehicle.
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
                String deletePlateNumberInput = scannerDeleteVehicle.nextLine().toUpperCase(); //getting the plate number to delete the vehicle.
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

    //printing the vehicle list.
    @Override
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

    //This method will save the arraylist to a text file.
    @Override
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

    //This method will put all the data in the arraylist to the sql data base for later use.
    @Override
    public void saveInDatabase() {
        ConnectionClass connectionClass = new ConnectionClass(); //getting the connection.
        Connection connection = connectionClass.getConnection();
        try {

            for (Vehicle vehicle:listOfVehicles){
                if(vehicle.getClass().equals(Car.class)){
                    PreparedStatement insertCar =connection.prepareStatement("insert into vehicles (VehicleType, VehiclePlateNumber, PricePerKM, FuelType, NumberOfPassengers," +
                            "NumberOfAirbags, NumberOfSeats, VehicleMake)" + "values ('Car',?,?,?,?,?,?,?)");
                    insertCar.setString(1,vehicle.getPlateNumber());
                    insertCar.setDouble(2,vehicle.getPricePerKm());
                    insertCar.setInt(3,((Car)vehicle).getFuelType());
                    insertCar.setInt(4,vehicle.getNumberOfPassengers());
                    insertCar.setInt(5,((Car)vehicle).getNumberOfAirbags());
                    insertCar.setInt(6,((Car)vehicle).getNumberOfSeats());
                    insertCar.setString(7,vehicle.getMake());
                    insertCar.execute();
                }
                else if(vehicle.getClass().equals(Motorbike.class)){
                    PreparedStatement insertMotorbike =connection.prepareStatement("insert into vehicles (VehicleType, VehiclePlateNumber, PricePerKM, NumberOfHelmets, NumberOfPassengers," +
                            "WheelDiameter, NumberOfGears, VehicleMake)" + "values ('Motorbike',?,?,?,?,?,?,?)");
                    insertMotorbike.setString(1,vehicle.getPlateNumber());
                    insertMotorbike.setDouble(2,vehicle.getPricePerKm());
                    insertMotorbike.setInt(3,((Motorbike)vehicle).getNumberOfHelmets());
                    insertMotorbike.setInt(4,vehicle.getNumberOfPassengers());
                    insertMotorbike.setInt(5,((Motorbike)vehicle).getWheelDiameter());
                    insertMotorbike.setInt(6,((Motorbike)vehicle).getNumberOfGears());
                    insertMotorbike.setString(7,vehicle.getMake());
                    insertMotorbike.execute();
                }
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }

    }
}
