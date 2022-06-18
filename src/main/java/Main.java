import commands.impl.LoadSpreadSheetCommand;
import commands.impl.SaveSpreadSheetCommand;
import models.Calculadora;
import models.CommandProcessor;
import models.Parser;
import models.SpreadSheet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //CommandProcessor.processCommand("RF src/main/resources/comando.txt");
        CommandProcessor.processCommand("C 4 5");
        SpreadSheet spreadSheet = SpreadSheet.getSpreadSheet();

        Calculadora calculadora = new Calculadora("31+5*4-3+4*9");
        calculadora.processExpression();
        calculadora.sortOperatos();
        calculadora.execute();


//        Parser parser = new Parser("src/main/resources/spreadSheet.csv");
//        SpreadSheet spreadSheet1 = parser.loadSpreadSheetS2V();
//        System.out.println(spreadSheet1);



    }


}
