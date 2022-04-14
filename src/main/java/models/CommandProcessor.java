package models;

import commands.impl.CreateNewSpreadSheetCommand;
import commands.impl.EditCellCommand;
import commands.impl.FileCommandReader;

/**
 * Represents the processor of the command writed
 * by the user.
 */
public class CommandProcessor {

    private static final String READ_COMMAND_FROM_FILE = "RF";
    private static final String CREATE_NEW_SPREADSHEET = "C";
    private static final String EDIT_CELL = "E";
    private static final String LOAD_SPREADSHEET_FROM_FILE = "L";
    private static final String SAVE_SPREADSHEET_TO_FILE = "S";
    private static final String GENERAR_HELP = "S";

    /**
     * Get the command and choose the correct operation
     * for be executed
     * @param
     */
    public static void processCommand(String command){
        System.out.println(command);
        String[] arguments = command.split(" ");
        String commandHead = arguments[0];

        if(commandHead.equalsIgnoreCase(READ_COMMAND_FROM_FILE)) {
            readCommandFromFile(command);
        }else if (commandHead.equalsIgnoreCase(CREATE_NEW_SPREADSHEET)){
            creatNewSpreadSheet(command);
        }else if(commandHead.equalsIgnoreCase(EDIT_CELL)){
            editCell(command);
        }else if(commandHead.equalsIgnoreCase(LOAD_SPREADSHEET_FROM_FILE)){
            System.out.println("Loading spreadsheet from file...");
        }else if(commandHead.equalsIgnoreCase(SAVE_SPREADSHEET_TO_FILE)){
            System.out.println("Saving spreadsheet to file...");
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

    private static void editCell(String command){
        String[] arguments = command.split(" ");
        if(arguments.length != 4){
            displayHelp(EDIT_CELL);
        }else{

            int row = Integer.parseInt(arguments[1]);
            char column = arguments[2].charAt(0);

            Coordinate coordinate = new Coordinate(row, column);

            String value = arguments[3];

            EditCellCommand editCellCommand = new EditCellCommand(coordinate, value);
            editCellCommand.execute();
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
