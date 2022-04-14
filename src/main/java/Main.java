import commands.impl.SaveSpreadSheetCommand;
import models.CommandProcessor;
import models.SpreadSheet;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //CommandProcessor.processCommand("RF src/main/resources/comando.txt");
        CommandProcessor.processCommand("C 4 5");
        SpreadSheet spreadSheet = new SpreadSheet(3,3);
        SaveSpreadSheetCommand saveSpreadSheetCommand = new SaveSpreadSheetCommand(spreadSheet);
        saveSpreadSheetCommand.execute();


    }
}
