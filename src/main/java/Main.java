import models.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //CommandProcessor.processCommand("RF src/main/resources/comando.txt");
//        Controller.processCommand("C 4 5");
//        SpreadSheet spreadSheet = SpreadSheet.getSpreadSheet();

//        Controller.processCommand("E A1 9-3+2*2-6/6+8");

//        System.out.println(spreadSheet);

//        Calculadora calculadora = new Calculadora("9-3+2*2-6/6+8");
//        calculadora.processExpression();
//        calculadora.sortOperatos();
//        System.out.println("Resultado -> " + calculadora.execute());

        UserInterface userInterface = new UserInterface();

        userInterface.printMenu();

//        Parser parser = new Parser("src/main/resources/spreadSheet.csv");
//        SpreadSheet spreadSheet1 = parser.loadSpreadSheetS2V();
//        System.out.println(spreadSheet1);



    }


}
