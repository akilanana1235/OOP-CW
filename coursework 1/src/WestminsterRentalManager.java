import java.io.File;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;


public class WestminsterRentalManager implements RentalVehicleManager{

    private Car carExtend = new Car();
    private Motorbike motobikeExtend = new Motorbike();

    //adding vehicle method
    @Override
    public void addVehicle(){

        ConnectionClass connectionclass = new ConnectionClass();
        Connection connection = connectionclass.getConnection();

        Scanner scanner = new Scanner(System.in);

        //Checking if the space if available
        System.out.print("\n" +
                "Select vehicle type" +
               "\n" +
                "1. Car \n" +
                "2. Motorbike \n" +
                "Choose: ");
        while (!scanner.hasNextInt()){
            System.out.println("Invalid Data Type!!!");
            scanner.next();
            System.out.print("Select vehicle type" +
                    "\n" +
                    "1. Car \n" +
                    "2. Motorbike \n"+
                    "Choose: ");
        }
        int optionVehicle = scanner.nextInt();



        if (optionVehicle==1) {
            int totalVehicles=0;
            try {
                Statement statement = connection.createStatement();

                String query = "select count(*) from vehicles";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    totalVehicles=resultSet.getInt(1);
                }
                System.out.println((50-totalVehicles)+ " spaces left in the park.");

                Scanner carOptionScanner = new Scanner(System.in);
                if (totalVehicles<50) {
                    //Input car plate number
                    System.out.print("Please enter the plate number (ABC-1234): ");
                    String carPlateNumber = carOptionScanner.nextLine();

                    //Input car make
                    System.out.print("Please enter the make: ");
                    String carMake = carOptionScanner.nextLine();

                    //Input number of car doors
                    System.out.print("Please Enter the number of doors: ");
                    while (!carOptionScanner.hasNextInt()) {
                        System.out.println("Invalid Data Type !!!");
                        carOptionScanner.nextLine();
                        System.out.print("Please enter the number of doors: ");
                    }
                    int numberOfCarDoors = carOptionScanner.nextInt();
                    carOptionScanner.nextLine();

                    //Input the fuel type
                    System.out.print("Please enter the fuel type (92 or 95): ");
//            while(!(carOptionScanner.equals("95") || carOptionScanner.equals("92"))){
//                System.out.println("Insert the correct fuel type!!!");
//                carOptionScanner.next();
//                System.out.print("Please enter the fuel type: ");
//            }
                    String carFuelType = carOptionScanner.nextLine();

                    carExtend.setVehiclePlateNumber(carPlateNumber);
                    carExtend.setVehicleMake(carMake);
                    carExtend.setNumberOfDoors(numberOfCarDoors);
                    carExtend.setFuelType(carFuelType);

                    String databaseVehiclePlateNumber = carExtend.getVehiclePlateNumber();
                    String databaseCarMake = carExtend.getVehicleMake();
                    int databaseNumberOfDoors = carExtend.getNumberOfDoors();
                    String databaseFuelType = carExtend.getFuelType();

                    String sql = "insert into vehicles" + "(VehicleType, VehiclePlateNumber, VehicleMake, NumberOfDoors, FuelType)" + "values('" + "Car" + "','" + databaseVehiclePlateNumber + "','" + databaseCarMake + "','" + databaseNumberOfDoors + "','" + databaseFuelType + "')";
                    statement.executeUpdate(sql);
                }else {
                    System.out.println("Parking is full!");
                }
            }catch (Exception exc){
                exc.printStackTrace();
            }
        }
        else if (optionVehicle==4){
            System.out.println("4444");
        }

        else if(optionVehicle==2) {

            try {
                Statement statement = connection.createStatement();

                int totalVehicles=0;
                String query = "select count(*) from vehicles";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    totalVehicles=resultSet.getInt(1);
                }
                System.out.println((50-totalVehicles)+ " spaces left in the park.");


                Scanner motorbikeOptionScanner = new Scanner(System.in);
                if(totalVehicles<50) {
                    //Input bike number plate
                    System.out.print("Please enter plate number: ");
                    String motorbikeNumber = motorbikeOptionScanner.nextLine();

                    //Input bike make
                    System.out.print("Please enter make: ");
                    String motorbikeMake = motorbikeOptionScanner.nextLine();

                    //Input the number of helmets
                    System.out.print("Please enter the number of helmets: ");
                    while (!motorbikeOptionScanner.hasNextInt()) {
                        System.out.println("Invalid Data type");
                        motorbikeOptionScanner.next();
                        System.out.print("Please enter the number of helmets: ");
                    }
                    int bikeNumberOfHelmets = motorbikeOptionScanner.nextInt();

                    //Input the helmet size
                    System.out.print("Please enter the helmet size: ");
                    while (!motorbikeOptionScanner.hasNextDouble()) {
                        System.out.println("Invalid Data type");
                        motorbikeOptionScanner.next();
                        System.out.print("Please enter the helmet size: ");
                    }
                    double bikeHelmetSize = motorbikeOptionScanner.nextDouble();

                    motobikeExtend.setVehiclePlateNumber(motorbikeNumber);
                    motobikeExtend.setVehicleMake(motorbikeMake);
                    motobikeExtend.setHelmetSize(bikeHelmetSize);
                    motobikeExtend.setNumberOfHelmets(bikeNumberOfHelmets);

                    String databaseVMotorbikePlateNumber = motobikeExtend.getVehiclePlateNumber();
                    String databaseMotorBikeMake = motobikeExtend.getVehicleMake();
                    int databaseNumberOfHelmets = motobikeExtend.getNumberOfHelmets();
                    double databaseHelmetSize = motobikeExtend.getHelmetSize();

                    String sql = "insert into vehicles" + "(VehicleType, VehiclePlateNumber, VehicleMake, NumberOfHelmets, HelmetSize)" + "values('" + "Motorbike" + "','" + databaseVMotorbikePlateNumber + "','" + databaseMotorBikeMake + "','" + databaseNumberOfHelmets + "','" + databaseHelmetSize + "')";
                    statement.executeUpdate(sql);

                }else{
                    System.out.println("Parking is full!");
                }
            }catch (Exception exc){
                exc.printStackTrace();
            }
        }
        else {
            System.out.println("Invalid vehicle option!!! ");
        }
    }

    @Override
    public void deleteVehicle() {

        ConnectionClass connectionclass = new ConnectionClass();
        Connection connection = connectionclass.getConnection();

        int totalVehicles = 0;

        try {
            Statement statement = connection.createStatement();


            Scanner deleteVehicleScanner = new Scanner(System.in);

            System.out.print("Please enter the plate number of the vehicle that you want to remove: ");
            String deleteplateNumber = deleteVehicleScanner.nextLine();

            String validate = "select * from vehicles where VehiclePlateNumber = '" + deleteplateNumber + "'";

            ResultSet validReasultSet = statement.executeQuery(validate);

            while (!validReasultSet.next()){
                System.out.println("Vehicle does now exist. Try Again!");
                System.out.print("Please enter the plate number of the vehicle that you want to remove: ");
                deleteplateNumber = deleteVehicleScanner.nextLine();
                validate = "select * from vehicles where VehiclePlateNumber = '" + deleteplateNumber + "'";
                validReasultSet= statement.executeQuery(validate);
            }
            ResultSet type = statement.executeQuery("select VehicleType from vehicles where VehiclePlateNumber = '" + deleteplateNumber + "'");
            if(type.next()){
                System.out.println("Deletion completed. You deleted");
            }
            String deleteEntry = "delete from vehicles where VehiclePlateNumber = '" + deleteplateNumber+"'";
            statement.executeUpdate(deleteEntry);
            String query = "select count(*) from vehicles";
            PreparedStatement preparedStatementDelete = connection.prepareStatement(query);
            ResultSet resultSetDelete = preparedStatementDelete.executeQuery();
            while (resultSetDelete.next()) {
                totalVehicles = resultSetDelete.getInt(1);
            }
            System.out.println((1000-totalVehicles) + " spaces are left.");

        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

    @Override
    public void printVehicle() {

        ConnectionClass connectionclass = new ConnectionClass();
        Connection connection = connectionclass.getConnection();

        try {

            Statement statement = connection.createStatement();

            ResultSet resultSetPrintData = statement.executeQuery("select * from vehicles order by VehicleMake asc");
            System.out.println("");
            System.out.format("_%1$-20s_%2$-20s_%3$-20s\n", "_____________________", "_____________________", "___________________");


            System.out.format("|%1$-20s|%2$-20s|%3$-20s|\n", "       VEHICLE TYPE", "    PLATE NUMBER", "        MAKE ");

            System.out.format("_%1$-20s_%2$-20s_%3$-20s\n", "_____________________", "_____________________", "___________________");
            System.out.format("%1$-20s%2$-20s%3$-20s\n", "", "", "");

                while (resultSetPrintData.next()){
                    System.out.format("|%1$-20s|%2$-20s|%3$-20s|\n","       "+resultSetPrintData.getString(1) ,"       "+resultSetPrintData.getString(2) ,"       "+resultSetPrintData.getString(3));
                    System.out.println("");
                }
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

    @Override
    public void editVehicle(){
    }

    @Override
    public void searchVehicle(){
    }

    @Override
    public void filterVehicle(){
    }

    @Override
    public void checkAvailability(){
    }

    @Override
    public void bookVehicle(){
    }

    @Override
    public void save() {
        ConnectionClass connectionclass = new ConnectionClass();
        Connection connection = connectionclass.getConnection();

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from vehicles");

            File file = new File("VehicleLst.txt");
            if (!file.exists()){ //checking for existing files.
                file.createNewFile();
            }

            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("                           Report");
            printWriter.println("               ");

            System.out.println("");
            System.out.format("|%1$-25s|%2$-25s|%3$-25spk[|%4$-35s|%5$-25s|%6$-25s|%7$-25s|%8$-25s|\n","Vehicle Type","Vehicle Plate Number","Vehicle Make","Price Per KM","Number of Doors", "Fuel Type", "Number Of Helmets", "Helmet Size");
            System.out.format("_%1$-25s_%2$-25s_%3$-25s_%4$-25s_%5$-25s_%6$-25s_%7$-25s_%8$-25s\n","_____________________","_____________________","_____________________________","_____________________________","_____________________","_____________________","_____________________","_____________________");
            System.out.format("%1$-25s%2$-25s%3$-25s%4$-25s%5$-25s%6$-25s%7$-25s%8$-25s\n","","","","","","","","");

            while (resultSet.next()){
                System.out.format("|%1$-25s|%2$-25s|%3$-25s|%4$-25s||%5$-25s|%6$-25s|%7$-25s|%8$-25s|\n","       "+resultSet.getString(1) ,"       "+resultSet.getString(2) ,"       "+resultSet.getString(3),"       "+resultSet.getDouble(4),"       "+resultSet.getInt(5),"       "+resultSet.getString(6),"       "+resultSet.getInt(7),"       "+resultSet.getInt(8) );
                printWriter.println("Vehicle Type: "+resultSet.getString(1));// printing in the file
                printWriter.println("Vehicle Plate Number: "+resultSet.getString(2) );
                printWriter.println("Vehicle Make: "+resultSet.getString(3));
                printWriter.println("Price Per KM: "+resultSet.getDouble(4));
                printWriter.println("Number of Doors: "+resultSet.getInt(5));// printing in the file
                printWriter.println("Fuel Type: "+resultSet.getString(6) );
                printWriter.println("Number of Helmets: "+resultSet.getInt(7));
                printWriter.println("Helmet Size: "+resultSet.getInt(8));
                printWriter.println("__________________________________________________");
            }
            printWriter.close();
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
