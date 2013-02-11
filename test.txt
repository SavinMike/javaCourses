package com.savin.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 10.02.13
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
public class CsvWriter {
    private FileWriter fw;
    private PrintWriter out ;

    public CsvWriter(){
        try {
            fw= new FileWriter("WriteTest.csv");
            out = new PrintWriter(fw);
            out.print("Word;Friquency;Friquency%");
            out.println();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public void write(String text, String delimeter) throws IOException
    {
        int start=0;
        int end;
        while ((end=text.indexOf(delimeter))!=-1){
            System.out.println(text);
            out.print(text.substring(start,end));
            out.print(";");
            text=text.substring(end+delimeter.length());

        }
        out.println();
        out.flush();


    }
    public void close(){
        try {
            out.close();
            fw.close();

        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
