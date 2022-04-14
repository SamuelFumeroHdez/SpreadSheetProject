package commands.impl;

import commands.Command;
import models.CommandProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileCommandReader implements Command {

    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public FileCommandReader(String pathFile){
        try{
            this.fileReader = new FileReader(pathFile);
            this.bufferedReader = new BufferedReader(fileReader);

        }catch (IOException exception){
            System.err.println("I/O Error: " + exception);
        }
    }

    @Override
    public void readArguments() {

    }

    @Override
    public void execute(){
        try{
            String command = bufferedReader.readLine();
            CommandProcessor.processCommand(command);
        }catch (IOException exception){
            System.err.println("I/O Error: " + exception);
        }
        //return null;
    }
}
