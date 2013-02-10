package com.savin.analysis_of_word;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 09.02.13
 * Time: 13:54
 * To change this template use File | Settings | File Templates.
 */
public class FrequencyOfWord implements AnalysisOfWord{
    private TreeMap<String,Integer> tableOfSet =new TreeMap<>();

    public void add(String word){
        if(tableOfSet.containsKey(word)){
            tableOfSet.put(word, tableOfSet.get(word) + 1);
        }
        else
            tableOfSet.put(word,1);
    }
    public int countOfWords (){
        int count=0;
        for (Integer countOfWord: tableOfSet.values()){
            count+=countOfWord;
        }
        return count;
    }
    public double frequencyOnPerCent(String word){
        return (double)((int)((tableOfSet.get(word)/(double)this.countOfWords()*100)*100))/100.;
    }

    private class ComparatorToFreq implements Comparator<String>{
        public int compare(String s1,String s2){
            if(tableOfSet.get(s2)-tableOfSet.get(s1)!=0)
                return tableOfSet.get(s2)-tableOfSet.get(s1);
            else return s1.compareTo(s2);
        }
    }
    public TreeMap<String,Integer> sort(){
        TreeMap<String,Integer> sortTable=new TreeMap<>(new ComparatorToFreq());
        sortTable.putAll(tableOfSet);
        return sortTable;
    }

}
