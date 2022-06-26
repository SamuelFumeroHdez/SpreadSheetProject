package models;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private StringBuilder stringBuilder;
    private String option;

    public UserInterface(){
        stringBuilder = new StringBuilder("Operations: \n");

        stringBuilder.append("Read file            ");
        stringBuilder.append("RF <File path>");
        stringBuilder.append("\n");

        stringBuilder.append("Create Spreadsheet   ");
        stringBuilder.append("C <rows> <columns>");
        stringBuilder.append("\n");

        stringBuilder.append("Print Spreadsheet    ");
        stringBuilder.append("P");
        stringBuilder.append("\n");

        stringBuilder.append("Edit cell            ");
        stringBuilder.append("E <Coordinate> <New value>");
        stringBuilder.append("\n");

        stringBuilder.append("Add Rows             ");
        stringBuilder.append("AR <Rows number>");
        stringBuilder.append("\n");

        stringBuilder.append("Remove Row           ");
        stringBuilder.append("RR");
        stringBuilder.append("\n");

        stringBuilder.append("Add Columns          ");
        stringBuilder.append("AC <Columns number>");
        stringBuilder.append("\n");

        stringBuilder.append("Remove Column        ");
        stringBuilder.append("RC");
        stringBuilder.append("\n");

        stringBuilder.append("Load Spreadsheet      ");
        stringBuilder.append("L <Path>");
        stringBuilder.append("\n");

        stringBuilder.append("Save Spreadsheet      ");
        stringBuilder.append("S <Path>");
        stringBuilder.append("\n");

        stringBuilder.append("> Insert option: ");

    }

    public void printMenu() throws IOException, ClassNotFoundException {
        System.out.println(stringBuilder);
        Scanner sc = new Scanner(System.in);
        option = sc.nextLine();
        Controller.processCommand(option);
        if(!option.equalsIgnoreCase("Q")){
            printMenu();
        }else{
            System.out.println("Coming out...");
        }
    }



}
