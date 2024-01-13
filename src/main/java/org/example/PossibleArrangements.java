package org.example;

import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleArrangements {
    private static final Logger logger = LoggerFactory.getLogger(PossibleArrangements.class);
    public static void main(String[] args) {
        Configurator.initialize(null, "log4j2.xml");
        try{
            if (args.length != 1 ) {
                throw new IllegalArgumentException("Invalid input. Provide one string .");
            }
            String inputString = args[0];
            if(inputString.length()!=3){
                throw new IllegalArgumentException("Invalid input. Provide one string with length 3.");
            }
            if(inputString.charAt(0)==inputString.charAt(1) || inputString.charAt(1)==inputString.charAt(2) || inputString.charAt(0)==inputString.charAt(2)){
                throw new IllegalArgumentException("Invalid input. Every element in string should be different.");
            }

            List<String> result = possibleArrangements(inputString);
            logger.info("Output : {}",result);
        }catch (IllegalArgumentException e) {
            logger.error("Error: {}", e.getMessage());
        }
    }
    private static List<String> possibleArrangements(String inputString){
        char[] characters = inputString.toCharArray();

        List<String>result = new ArrayList<>();

        Arrays.sort(characters);

        for (char firstChar : characters) {
            for (char secondChar : characters) {
                for (char thirdChar : characters) {
                    result.add("" + firstChar + secondChar + thirdChar);
                }
            }
        }
        return result;
    }
}
