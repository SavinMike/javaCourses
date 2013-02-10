package com.savin.main;

import com.savin.analysis_of_word.FrequencyOfWord;
import com.savin.writer.CsvWriter;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 09.02.13
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main (String args[]) throws IOException{

        if(args.length>0){
            try(Scanner cout = new Scanner(new BufferedInputStream(new FileInputStream(args[0])))){
                String s;
                FrequencyOfWord frequencyOfWord=new FrequencyOfWord();

                cout.useDelimiter("[^\\w\\d]");

                while (cout.hasNext()){
                    if(!(s=cout.next()).equals(""))
                        frequencyOfWord.add(s);
                }
                CsvWriter cin =new CsvWriter();
                String textLine;
                for(String ss:frequencyOfWord.sort().keySet()) {
                    textLine=ss+";"+frequencyOfWord.sort().get(ss)+";"+frequencyOfWord.frequencyOnPerCent(ss)+";";
                    cin.write(textLine,";");
                }
                cin.close();

            }



            catch ( IOException e){
                System.out.println(e);
            }
        }
    }
}
