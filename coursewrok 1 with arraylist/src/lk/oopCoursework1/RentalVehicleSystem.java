package lk.oopCoursework1;

import java.util.Scanner;

public class RentalVehicleSystem {

    public static void main(String[] args){
        WestminsterRentalManager rentsystem = new WestminsterRentalManager();
        Scanner mainMenuScanner = new Scanner(System.in);

        int menuOption=0;
        while (menuOption!=6){
            System.out.println(" \n" +
                    "      ______________________________________________ \n" +
                    "      Welcome to the Westminster Rental Vehicle Manager \n" +
                    "      ---------------------------------------------- \n" +
                    "\n" +
                    "1. Add vehicle \n" +
                    "2. Delete vehicle \n" +
                    "3. Print Vehicle list \n" +
                    "4. Save the vehicle list \n" +
                    "5. Open the gui \n"+
                    "6. Exit the programme \n" +
                    "\n");

            System.out.print("Choose an option: ");
            while (!mainMenuScanner.hasNextInt()){
                String wrongdatatype = mainMenuScanner.next();
                System.out.println("'"+wrongdatatype+"'"+" is an invalid data type!!");
                System.out.print("Choose an option: ");
            }

            menuOption = mainMenuScanner.nextInt();
            switch (menuOption){
                case 1:
                    rentsystem.addVehicle();
                    break;
                case 2:
                    rentsystem.deleteVehicle();
                    break;
                case 3:
                    rentsystem.printVehicleList();
                    break;
                case 4:
                    rentsystem.saveVehicleList();
                    break;
                case 5:
                    rentsystem.saveInDatabase();
                    javafx.application.Application.launch(lk.oopCoursework1.Gui.class);
                    System.out.println("------->> Programme End <<--------");
                    System.exit(0);
                    break;
                case 6:
                    System.out.println("------->> Programme End <<--------");
                    rentsystem.saveInDatabase();
                    System.exit(0);
                default:
                    System.out.println("Please the choose the correct option!!");
            }
        }

    }
}
