package models;

import utils.AlphabetToNumber;

import java.io.*;
import java.util.ArrayList;

public class Parser {

    String path;

    public Parser(String path) {
        this.path = path;
    }

    public void saveSpreadSheetS2V(){
        SpreadSheet spreadSheet = SpreadSheet.getSpreadSheet();
        Coordinate lastCoordinate = spreadSheet.getLastCell().getCoordinate();
        int lastColumnNum = AlphabetToNumber.charToNumber(lastCoordinate.getColumn());
        int lastRow = lastCoordinate.getRow();

        try {
            FileWriter file = new FileWriter(path);
            PrintWriter pw = new PrintWriter(file);

            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 1 ; i<=lastRow ; i++){
                for(int j = 1 ; j<=lastColumnNum ; j++){
                    stringBuilder.append(AlphabetToNumber.numberToChar(j) + "" + i + ";");
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1); //Quitar el ultimo punto y coma
            pw.println(stringBuilder);

            stringBuilder.setLength(0);
            for(Cell c : SpreadSheet.getSpreadSheet().getCellList()){
                stringBuilder.append(c.getValue() + ";");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1); //Quitar el ultimo punto y coma
            pw.println(stringBuilder);

            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SpreadSheet loadSpreadSheetS2V(){
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String firstLine = br.readLine();
            String[] coordinates;
            coordinates = firstLine.split(";");

            String[] values = br.readLine().split(";");

            String lastCoordinate = coordinates[coordinates.length-1];

            Cell lastCell = new Cell(new Coordinate(lastCoordinate.charAt(0), Character.getNumericValue(lastCoordinate.charAt(1)))); //??

            int columns = AlphabetToNumber.charToNumber(lastCell.getCoordinate().getColumn());
            int rows = lastCell.getCoordinate().getRow();

            SpreadSheet spreadSheet = SpreadSheet.getSpreadsheet(rows, columns);

            int counter = 0;
            for(int i=1 ; i<=columns ; i++){
                for(int j=1 ; j<=rows ; j++){
                    SpreadSheet.getCellByCoordinate(new Coordinate(AlphabetToNumber.numberToChar(i), j)).setValue(Integer.parseInt(values[counter]));
                    counter++;
                }
            }

            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return SpreadSheet.getSpreadSheet();

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
