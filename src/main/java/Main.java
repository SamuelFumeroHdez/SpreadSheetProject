import commands.impl.LoadSpreadSheetCommand;
import commands.impl.SaveSpreadSheetCommand;
import models.Calculadora;
import models.CommandProcessor;
import models.SpreadSheet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //CommandProcessor.processCommand("RF src/main/resources/comando.txt");
        /*CommandProcessor.processCommand("C 4 5");
        SpreadSheet spreadSheet = SpreadSheet.getSpreadSheet();
        spreadSheet.agregarColumnas(5);
        System.out.println(spreadSheet);*/

        /*String operacion = "4+5+55";
        Calculadora calculadora = new Calculadora(operacion);
        calculadora.processExpression();
        System.out.println(calculadora.getOperation());*/
        //CommandProcessor.processCommand("S src/main/resources/spreadsheet1.txt");
        //CommandProcessor.processCommand("L src/main/resources/spreadsheet1.txt");
        //SpreadSheet spreadSheet = SpreadSheet.getSpreadsheet(3,3);

        String ejemplo = "SUM(3,A5, SUM(1,2), 5, 8, 9)";
        String functionType = ejemplo.substring(0, ejemplo.indexOf('('));
        String second = ejemplo.substring(ejemplo.indexOf('(')+1, ejemplo.length()-1);
        List<String> array = Arrays.asList(second.split(","));
        System.out.println(functionType);
        System.out.println(second);
        System.out.println(array);



        /*SaveSpreadSheetCommand saveSpreadSheetCommand = new SaveSpreadSheetCommand("src/main/resources/spreadsheet");
        saveSpreadSheetCommand.execute();

        LoadSpreadSheetCommand loadSpreadSheetCommand = new LoadSpreadSheetCommand("src/main/resources/spreadsheet");
        loadSpreadSheetCommand.execute();*/

    }


}
