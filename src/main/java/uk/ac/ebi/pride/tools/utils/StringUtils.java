package uk.ac.ebi.pride.tools.utils;

/**
 * This code is licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * String Utils that can be use perform tasks in file content.
 * <p>
 * ==Overview==
 * <p>
 * This class
 * <p>
 * Created by ypriverol (ypriverol@gmail.com) on 18/10/2017.
 */
public class StringUtils {

    /**
     * Some files started with BOM character, we should remove that from the reader.
     * @param keyword String containing the BOM character
     * @return return the new word
     */
    public static String removeBOMString(String keyword){
        if(keyword != null){
            if (keyword.startsWith("\ufeff")){
                keyword = keyword.replaceFirst("\ufeff", "").replaceAll("\uFEFF", "");
            }
        }
        return keyword;
    }

    public static String globalTrim(String keyword){
        return keyword.replaceAll("\n", "").replaceAll("\r", "");
    }

    /**
     * Smart parse of Double values in the way ##.##.##
     * @param number Number in String format
     * @return Return Double
     */
    public static Double smartParseDouble(String number){
        Double doubleNumber = null;
        try{
            doubleNumber =  Double.parseDouble(number);
        }catch (NumberFormatException ex){
            String[] numberComponents = number.split("\\.");
            if(numberComponents.length > 2)
                doubleNumber =  Double.parseDouble(numberComponents[0] + "." + numberComponents[1]);
        }
        return doubleNumber;
    }
}
