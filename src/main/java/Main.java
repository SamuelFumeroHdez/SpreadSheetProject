import commands.impl.LoadSpreadSheetCommand;
import commands.impl.SaveSpreadSheetCommand;
import models.CommandProcessor;
import models.SpreadSheet;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //CommandProcessor.processCommand("RF src/main/resources/comando.txt");
        //CommandProcessor.processCommand("C 4 5");
        SpreadSheet spreadSheet = SpreadSheet.getSpreadsheet(3,3);

        SaveSpreadSheetCommand saveSpreadSheetCommand = new SaveSpreadSheetCommand(spreadSheet);
        saveSpreadSheetCommand.execute();

        LoadSpreadSheetCommand loadSpreadSheetCommand = new LoadSpreadSheetCommand("src/main/resources/spreadsheet");
        loadSpreadSheetCommand.execute();

    }
}
