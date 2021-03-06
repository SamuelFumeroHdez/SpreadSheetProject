package models;

import commands.Command;
import commands.impl.*;

import java.io.IOException;

/**
 * Represents the processor of the command writed
 * by the user.
 */
public class Controller {

    private static final String READ_COMMAND_FROM_FILE = "RF";
    private static final String CREATE_NEW_SPREADSHEET = "C";
    private static final String PRINT_SPREADSHEET = "P";
    private static final String EDIT_CELL = "E";
    private static final String LOAD_SPREADSHEET_FROM_FILE = "L";
    private static final String SAVE_SPREADSHEET_TO_FILE = "S";
    private static final String ADD_ROWS = "AR";
    private static final String ADD_COLUMNS = "AC";
    private static final String GENERAR_HELP = "H";
    private static final String QUIT = "Q";

    /**
     * Get the command and choose the correct operation
     * for be executed
     * @param
     */
    public static void processCommand(String command) throws IOException, ClassNotFoundException {
        String[] arguments = command.split(" ");
        String commandHead = arguments[0];

        if(commandHead.equalsIgnoreCase(READ_COMMAND_FROM_FILE)) {
            readCommandFromFile(command);
        }else if (commandHead.equalsIgnoreCase(CREATE_NEW_SPREADSHEET)){
            creatNewSpreadSheet(command);
        }else if(commandHead.equalsIgnoreCase(PRINT_SPREADSHEET)) {
            printSpreadSheet();
        }else if(commandHead.equalsIgnoreCase(EDIT_CELL)){
            editCell(command);
        }else if(commandHead.equalsIgnoreCase(LOAD_SPREADSHEET_FROM_FILE)){
            loadSpreadSheetFromFile(command);
        }else if(commandHead.equalsIgnoreCase(SAVE_SPREADSHEET_TO_FILE)){
            saveSpreadSheetToFile(command);
        }else if(commandHead.equalsIgnoreCase(ADD_ROWS)){
            addRows(command);
        }else if(commandHead.equalsIgnoreCase(ADD_COLUMNS)){
            addColumns(command);
        }else if(commandHead.equalsIgnoreCase(QUIT)){

        }else{
            displayHelp(GENERAR_HELP);
        }
    }

    /**
     * Method for read a command from a file
     * @param command
     */
    private static void readCommandFromFile(String command){
        String[] arguments = command.split(" ");
        if(arguments.length != 2){
            displayHelp(READ_COMMAND_FROM_FILE);
        }else{
            String filePath = arguments[1];
            FileCommandReader fileCommandReader = new FileCommandReader(filePath);
            fileCommandReader.execute();
        }
    }


    private static void creatNewSpreadSheet(String command){
        String[] arguments = command.split(" ");
        if(arguments.length != 3){
            displayHelp(CREATE_NEW_SPREADSHEET);
        }else{
            int rows = Integer.parseInt(arguments[1]);
            int columns = Integer.parseInt(arguments[2]);

            CreateNewSpreadSheetCommand createNewSpreadSheetCommand = new CreateNewSpreadSheetCommand(rows, columns);
            createNewSpreadSheetCommand.execute();
        }
    }

    private static void printSpreadSheet() throws IOException, ClassNotFoundException {
        PrintSpreadSheetCommand printSpreadSheetCommand = new PrintSpreadSheetCommand();
        printSpreadSheetCommand.execute();
    }

    private static void editCell(String command){
        System.out.println("Comando: " + command);
        String[] arguments = command.split(" ");

        if(arguments.length != 3){
            displayHelp(EDIT_CELL);
        }else{

            int row = Integer.parseInt(String.valueOf(arguments[1].charAt(1)));
            char column = arguments[1].charAt(0);
            System.out.println("fila " + row);
            System.out.println("columna " + column);

            Coordinate coordinate = new Coordinate(column, row);

            String value = arguments[2];

            EditCellCommand editCellCommand = new EditCellCommand(coordinate, value);
            editCellCommand.execute();
        }
    }

    private static void loadSpreadSheetFromFile(String command) throws IOException, ClassNotFoundException {
        String[] arguments = command.split(" ");
        String filePath = arguments[1];

        LoadSpreadSheetCommand loadSpreadSheetCommand = new LoadSpreadSheetCommand(filePath);
        loadSpreadSheetCommand.execute();

    }

    private static void saveSpreadSheetToFile(String command) throws IOException {
        String[] arguments = command.split(" ");
        String filePath = arguments[1];

        SaveSpreadSheetCommand saveSpreadSheetCommand = new SaveSpreadSheetCommand(filePath);
        saveSpreadSheetCommand.execute();
    }

    private static void addRows(String command) throws IOException, ClassNotFoundException {
        String[] arguments = command.split(" ");

        if(arguments.length != 2){
            displayHelp(ADD_ROWS);
        }else{

            int rowsNumber = Integer.parseInt(arguments[1]);

            Command addRowsCommand = new AddRowsCommand(rowsNumber);
            addRowsCommand.execute();
        }
    }

    private static void addColumns(String command) throws IOException, ClassNotFoundException {
        String[] arguments = command.split(" ");

        if(arguments.length != 2){
            displayHelp(ADD_COLUMNS);
        }else{

            int columnsNumber = Integer.parseInt(arguments[1]);

            Command addColumnsCommand = new AddColumnsCommand(columnsNumber);
            addColumnsCommand.execute();
        }
    }



    /**
     * Method for display the user help when user send a wrong input
     * @param helpType
     */
    private static void displayHelp(String helpType){
        if(helpType.equalsIgnoreCase(READ_COMMAND_FROM_FILE)) {
            System.out.println("Usage: RF <file path name>");
        }else if(helpType.equalsIgnoreCase(CREATE_NEW_SPREADSHEET)) {
            System.out.println("Usage: C <number of rows> <number of columns>");
        }else if(helpType.equalsIgnoreCase(EDIT_CELL)){
            System.out.println("Usage: E <cell coordinate> <new cell content>");
        }else if(helpType.equalsIgnoreCase(LOAD_SPREADSHEET_FROM_FILE)){
            System.out.println("Usage: L <file path name>");
        }else if(helpType.equalsIgnoreCase(SAVE_SPREADSHEET_TO_FILE)){
            System.out.println("Usage: S <file path name>");
        }else{
            System.out.println("Usage: RF | C | E | L | S <Arguments>");
        }
    }
}
