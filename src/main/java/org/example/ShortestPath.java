package org.example;

import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShortestPath {
    private static final Logger logger = LoggerFactory.getLogger(ShortestPath.class);

    public static void main(String[] args) {
        Configurator.initialize(null, "log4j2.xml");
        try{
            if (args.length != 3) {
                throw new IllegalArgumentException("Invalid input. Provide two integers and a string.");
            }

            int startX = Integer.parseInt(args[0]);
            int startY = Integer.parseInt(args[1]);
            String inputString = args[2];

           for(char direction : inputString.toCharArray()){
               if(direction == 'N' || direction == 'S' || direction == 'W' || direction =='E'){
                   continue;
               }
               else {
                   throw new IllegalArgumentException("Input String should contain N or E or W or S");
               }
           }

            double result = shortestPathFromStart(startX,startY,inputString);
            logger.info("Output : {}", result);


        }catch (IllegalArgumentException e) {
            logger.error("Error: {}", e.getMessage());
        }
    }

    private static double shortestPathFromStart(int startX,int startY,String inputString){
        int finalX = startX;
        int finalY = startY;
        for (char direction : inputString.toCharArray()) {
            if(direction == 'N'){
                finalY=finalY-1;
            }
            else if(direction == 'E'){
                finalX=finalX+1;
            }else if(direction == 'W'){
                finalX=finalX-1;
            }else {
                finalY=finalY+1;
            }
        }
        double deltaX = finalX-startX;
        double deltaY = finalY-startY;

        return Math.sqrt(deltaX*deltaX + deltaY*deltaY);


    }


}
