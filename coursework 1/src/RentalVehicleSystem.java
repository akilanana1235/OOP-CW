import java.awt.*;
import java.util.Scanner;




public class RentalVehicleSystem {

    public static void main(String[] args) {

        WestminsterRentalManager rent = new WestminsterRentalManager();
        Scanner mainMenuScanner = new Scanner(System.in);

        int menuOption=0;
        while (menuOption!=6){
            System.out.println(" \n" +
                    "      ______________________________________________ \n" +
                    "      Welcome to the Westminster Rental Vehicle Manager \n" +
                    "      ---------------------------------------------- \n" +
                    "\n" +
                    "1. Add Vehicle \n" +
                    "2. Delete Vehicle \n" +
                    "3. Print Vehicle List \n" +
                    "4. Open the Console \n" +
                    "5. Save vehicle list\n"+
                    "6. Exit the programme \n" +
                    "\n");

                System.out.print("Choose an option: ");
                while (!mainMenuScanner.hasNextInt()){
                    String wrongdatatype = mainMenuScanner.next();
                    System.out.println( wrongdatatype + " is an invalid data type!!");
                    System.out.print("Choose an option: ");
                }

                menuOption = mainMenuScanner.nextInt();
                switch (menuOption){
                    case 1:
                        rent.addVehicle();
                        break;
                    case 2:
                        rent.deleteVehicle();
                        break;
                    case 3:
                        rent.printVehicle();
                        break;
                    case 4:
                        ;
                        //open the console
                        break;
                    case 5:
                        rent.save();
                        break;
                    case 6:
                        System.out.println("------->> Programme End <<--------");
                        System.exit(0);
                    default:
                        System.out.println("Please the choose the correct option!!");
                }
        }
    }


}
