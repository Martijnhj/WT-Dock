package nl.workingtalent.dock;

import java.util.Scanner;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import nl.workingtalent.dock.model.*;

/*
    To change still:


        Could check if boat is valid boat type from a list. But too lazy.


        dock is entered in each void. Maybe make it public. Same for reader.

        remove double used lines.




 */

public class ApplicationBoat {

    public static void main(String[] args) {
        Dock dock = new Dock(4);
        ApplicationBoat.userInterface(dock);

    }

    public static void userInterface(Dock dock) {
        Scanner reader = new Scanner(System.in);

        while (true) {
            System.out.println("Options:" +
                    "\nCreate" +
                    "\nDelete (lots range from 1 to " + dock.getDockSize() + ")" +
                    "\nStatus" +
                    "\nChange" +
                    "\nLeave empty to exit program");
            System.out.print("Select an option: ");
            String option = reader.nextLine();

            if (option.isEmpty()) {
                break;
            }
            if (option.toLowerCase().equals("create")) {
                ApplicationBoat.createInterface(dock);
            } else if (option.toLowerCase().equals("delete")) {
                ApplicationBoat.deleteInterface(dock);
            } else if (option.toLowerCase().equals("status")) {
                System.out.println(dock);
            } else if (option.toLowerCase().equals("change")) {

                ApplicationBoat.changeInterface(dock);
            }
        }
    }

    public static void goBack(String reader, Dock dock) {
        if ("".equalsIgnoreCase(reader) || "Back".equalsIgnoreCase(reader)) {
            System.out.println("Quit entry and returned to main menu.\n");
            ApplicationBoat.userInterface(dock);
        }
    }

    public static void createInterface(Dock dock) {
        long indexOfSpace = dock.spaceChecker();
        System.out.println("\nType 'Back' or leave a line empty to return to the main menu");
        if (indexOfSpace >= 0) {
            Scanner reader = new Scanner(System.in);
            System.out.print("Provide the length of the boat: ");
            if (reader.hasNextInt()) {
                String length = reader.nextLine();
                ApplicationBoat.goBack(length, dock);
                System.out.print("Provide the type: ");
                String type = reader.nextLine();
                ApplicationBoat.goBack(type, dock);
                System.out.print("Provide the color: ");
                String color = reader.nextLine();
                ApplicationBoat.goBack(color, dock);


                dock.addBoat(new Boat(type, Double.parseDouble(length), color), indexOfSpace);
            } else {
                System.out.println("Enter valid entries");
                return;
            }

        } else {
            System.out.println("Dock is full, try again later\n");
        }
    }


    public static void deleteInterface(Dock dock) {
        System.out.println("\nType 'Back' or leave a line empty to return to the main menu");
        Scanner reader = new Scanner(System.in);
        System.out.print("Provide the position of your boat: ");
        if (reader.hasNextInt()) {
            String position = reader.nextLine();
            ApplicationBoat.goBack(position, dock);
            //Long position = Long.parseLong(position);
            System.out.print("Provide the boat type: ");
            String type = reader.nextLine();
            ApplicationBoat.goBack(type, dock);
            System.out.println("");
            dock.removeBoat(Long.parseLong(position), type);
        } else {
            System.out.println("Enter valid entries");
            return;
        }



    }

    public static void changeInterface(Dock dock) {
        System.out.println(dock);
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter what number you want to change: ");
        if (reader.hasNextInt()) {
            String id = reader.nextLine();
            ApplicationBoat.goBack(id, dock);

            System.out.print("Provide the boat type: ");
            String type = reader.nextLine();
            ApplicationBoat.goBack(type, dock);

            System.out.println(dock.printBoatChoice(Long.parseLong(id), type));
            if (!dock.rightBoat(Long.parseLong(id), type)) {
                ApplicationBoat.userInterface(dock);
            }
            System.out.print("Type your desired changes: ");

            System.out.print("Provide the length of the boat: "); //this is doubled, so make into a method.
            if (reader.hasNextInt()) {
                String length = reader.nextLine();
                ApplicationBoat.goBack(length, dock);
                System.out.print("Provide the type: ");
                String type2 = reader.nextLine();
                ApplicationBoat.goBack(type, dock);
                System.out.print("Provide the color: ");
                String color = reader.nextLine();
                ApplicationBoat.goBack(color, dock);


                dock.addBoat(new Boat(type2, Double.parseDouble(length), color), Long.parseLong(id) -1);
            } else {
                System.out.println("Enter valid entries");
                return;
            }

        } else {
            System.out.println("Enter valid entries");
            return;
            //ApplicationBoat.changeInterface(dock);
        }




    }

    /*public boolean checkInteger(String entry) {

        int numeralEntry;
        try {
            numeralEntry = Integer.parseInt(entry);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }*/


}


