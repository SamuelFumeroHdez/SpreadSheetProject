import commands.impl.LoadSpreadSheetCommand;
import commands.impl.SaveSpreadSheetCommand;
import models.Calculadora;
import models.CommandProcessor;
import models.SpreadSheet;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //CommandProcessor.processCommand("RF src/main/resources/comando.txt");
        /*CommandProcessor.processCommand("C 4 5");
        SpreadSheet spreadSheet = SpreadSheet.getSpreadSheet();
        spreadSheet.agregarColumnas(5);
        System.out.println(spreadSheet);*/

        String operacion = "4+5+55";
        Calculadora calculadora = new Calculadora(operacion);
        calculadora.processExpression();
        System.out.println(calculadora.getOperation());
        //CommandProcessor.processCommand("S src/main/resources/spreadsheet1.txt");
        //CommandProcessor.processCommand("L src/main/resources/spreadsheet1.txt");
        //SpreadSheet spreadSheet = SpreadSheet.getSpreadsheet(3,3);





        /*SaveSpreadSheetCommand saveSpreadSheetCommand = new SaveSpreadSheetCommand("src/main/resources/spreadsheet");
        saveSpreadSheetCommand.execute();

        LoadSpreadSheetCommand loadSpreadSheetCommand = new LoadSpreadSheetCommand("src/main/resources/spreadsheet");
        loadSpreadSheetCommand.execute();*/

    }
}
