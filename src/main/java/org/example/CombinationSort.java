package org.example;

import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CombinationSort {
    private static final Logger logger = LoggerFactory.getLogger(CombinationSort.class);

    public static void main(String[] args) {
        Configurator.initialize(null, "log4j2.xml");
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Please provide a list of unique strings as arguments.");
            }

            List<String> inputList = new ArrayList<>();
            Collections.addAll(inputList, args);

            List<String> resultL1 = sortListL1(inputList);
            List<String> resultL2 = sortListL2(resultL1);

            logger.info("L1 : {}", resultL1);
            logger.info("L2 : {}", resultL2);
        } catch (IllegalArgumentException e) {
            logger.error("Error: {}", e.getMessage());
        }
    }

    private static List<String> sortListL1(List<String> inputList) {
        List<String> resultL1 = new ArrayList<>(inputList);
        Collections.sort(resultL1, Comparator.comparing(s -> s.charAt(0)));
        return resultL1;
    }

    private static List<String> sortListL2(List<String> inputList) {
        List<String> resultL2 = new ArrayList<>(inputList);
        Collections.sort(resultL2, (A1, A2) -> {
            char c1 = A1.charAt(0);
            char c2 = A2.charAt(0);

            if (c1 == c2) {
                String num1 = A1.substring(1);
                String num2 = A2.substring(1);

                return Integer.parseInt(num2) - Integer.parseInt(num1);
            } else {
                return 0;
            }
        });
        return resultL2;
    }
}

