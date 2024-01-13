package org.example;

import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerfectNumber {
    private static final Logger logger = LoggerFactory.getLogger(PerfectNumber.class);
    public static void main(String[] args) {
        Configurator.initialize(null, "log4j2.xml");
        try{
            if (args.length != 1) {
                throw new IllegalArgumentException("Invalid input. Provide one Integer.");
            }

            int number = Integer.parseInt(args[0]);
            boolean result = findPerfectNumberOrNot(number);
            logger.info("Output : {}",result);

        }catch (IllegalArgumentException e) {
            logger.error("Error: {}", e.getMessage());
        }
    }

    private static boolean findPerfectNumberOrNot(int number){

        int sum =1;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                sum += i;

                if (i != Math.sqrt(number)) {
                    sum += number / i;
                }
            }
        }
        return sum == number;
    }
}
