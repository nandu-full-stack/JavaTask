package org.example;

import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMax {
    private static final Logger logger = LoggerFactory.getLogger(MinMax.class);
    public static void main(String[] args) {
        Configurator.initialize(null, "log4j2.xml");
        try {
                if (args.length % 2 != 0) {
                    throw new IllegalArgumentException("Both lists must have the same number of elements.");
                }

                int n = args.length / 2;
                List<Integer> a = new ArrayList<>();
                List<Integer> b = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    a.add(Integer.parseInt(args[i]));
                    b.add(Integer.parseInt(args[i + n]));
                }

                int result = getMax(a,b);
            logger.info("Output : {}", result);

        } catch (IllegalArgumentException e) {
            logger.error("Error: {}", e.getMessage());
        }
    }
    private static int getMax(List<Integer> a,List<Integer> b){
        for(int i = 0; i<a.size(); i++) {
            if (a.get(i) < b.get(i)) {
                int temp = b.get(i);
                b.set(i, a.get(i));
                a.set(i, temp);
            }
        }
            int maxInA = Collections.max(a);
            int maxInB = Collections.max(b);

            return maxInA*maxInB;
    }
}
