package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

import org.apache.logging.log4j.core.config.Configurator;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Configurator.initialize(null, "log4j2.xml");
        try {
            String[] arr = {"n12", "a21", "b33", "x09", "k22"};
            Arrays.sort(arr);
            for (String k : arr) {
                logger.info(k);


            }
        } catch (Exception e) {
            // Handle the exception here
            logger.error("An error occurred: {}", e.getMessage());
        }

    }
}