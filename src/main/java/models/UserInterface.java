package models;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private static String separator = "            ";
    private StringBuilder stringBuilder;
    private String option;

    public UserInterface(){
        stringBuilder = new StringBuilder("Operations: \n");
        stringBuilder.append("Read file            ");

        stringBuilder.append("RF <File path>");

        stringBuilder.append("\n");

        stringBuilder.append("Create Spreadsheet   ");
        stringBuilder.append("C");


        stringBuilder.append("\n");

        stringBuilder.append("Edit cell            ");
        stringBuilder.append("E <Coordinate>");

        stringBuilder.append("\n");


        stringBuilder.append("Load SpreedSheet     ");
        stringBuilder.append("L");


        stringBuilder.append("\n");

        stringBuilder.append("Save SpreedSheet     ");
        stringBuilder.append("S");

        stringBuilder.append("\n");


        stringBuilder.append("Add Row              ");
        stringBuilder.append("AR");


        stringBuilder.append("\n");

        stringBuilder.append("Remove Row           ");
        stringBuilder.append("RR");

        stringBuilder.append("\n");


        stringBuilder.append("Add Column           ");
        stringBuilder.append("AC");


        stringBuilder.append("\n");

        stringBuilder.append("Remove Column        ");
        stringBuilder.append("RC");

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
            System.out.println("Adios muy buenassss");
        }
    }





//    Read commands from File (RF)
//2. Create a New Spreadsheet (command C)
//3. Edit a cell (command E)
//4. Load a Spreadsheet from a file (command L)
//5. Save the Spreadsheet to a file (command S)
//    After executing each command, the program shall


}
