package com.ppg;

import java.util.ArrayList;


/**
 * This class provides utitilities to generate String abbreviations via 2 mechanisms: Recursive and Iterative
 * Assuming you provide internationalization as an input word, it will give all posible outputs like 
 * i18n, in17n, in16n, inter15 etc
 * @author padmapriyagopalan
 *
 */
public class StringAbbreviations {

	/**
	 * Prints all abbrevations of the {@paramref inputWord}. Uses a recursive method
	 * @param inputWord the input word for which abbrevation needs to be generated
	 */
	public static void getPermutationsRecursive(String inputWord){
		ArrayList<String> wordRepresentations = new ArrayList();
		getPermutationsRecursive(inputWord, "", wordRepresentations);		
		for (String x:wordRepresentations){
			System.out.println(x);
		}	
	}
	
	/**
	 * Prints all abbrevations of the {@paramref inputWord}. Uses a  iterative method
	 * @param inputWord the input word for which abbrevation needs to be generated
	 */
	public static void getPermutationsIterative(String inputWord) {  
		ArrayList<String> wordRepresentations = new ArrayList();
		wordRepresentations.add(inputWord);
		String globalprefix= "";
		if (inputWord == null)
			return;
	     
		int wordLength = inputWord.length();
	    for (int i=0; i< inputWord.length(); i++){
	         String prefix = inputWord.substring(0, i);
	         if (prefix == null)
                 prefix = "";
	         //sliding window to generate multiple options for a given prefix
	         for(int j = i+1; j <= wordLength; ++j) {
	             int num = j - i;
	             String numprefix = "";
	             if (num != 0)
	            	 numprefix = numprefix + num;

	             String suffix = inputWord.substring(j, wordLength);  
	             if (suffix == null)
	            	 suffix = "";
	             String results = globalprefix  + prefix + numprefix + suffix;  
	             wordRepresentations.add(results);    	            
	         }            
	     }
	     
	    for (String x:wordRepresentations){
				System.out.println(x);
		}		     	     	 
	}
	 
	
	
	private static void getPermutationsRecursive(String inputWord, String globalprefix, ArrayList<String> wordRepresentations) {     
		if (globalprefix == null)
	         globalprefix= "";

		if (inputWord == null)
			inputWord = "";
			
		int wordLength = inputWord.length();
		if (wordLength == 0 && globalprefix.length() > 0){
			wordRepresentations.add(globalprefix);
			return;
		}
		if (wordLength == 0)
			return;

	     
	    int globalprefixLength = globalprefix.length();
	    int totalWordLength = wordLength + globalprefixLength;
	     
	    for(int j = 1; j <= wordLength; ++j) {
	        int num = totalWordLength - globalprefixLength - (wordLength - j);
	        String numprefix = "";
	        if (num != 0)
	           numprefix = numprefix + num;

	        String suffix = inputWord.substring(j, wordLength);  
	        String results = globalprefix  + numprefix + suffix;
	                  
	        wordRepresentations.add(results);
	             
	     }
	         

	     String newprefix = globalprefix + inputWord.substring(0, 1);
         String newsuffix = inputWord.substring(1, wordLength);         	
         getPermutationsRecursive(newsuffix, newprefix, wordRepresentations);
            	     	 
	 }
	
	     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word =  "cat";
		getPermutationsIterative(word);
		
		System.out.println("");
		
		String word2 =  "testing";
		getPermutationsRecursive(word2);
	}

}
