package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Boolean> statistic = new HashMap<>();
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        for (int i = 0; i < 10000; i++){
            statistic.put((i+1),game());
        }
        for (Boolean result : statistic.values()){
            descriptiveStatistics.addValue((double)result);
        }
    }

    public static Boolean game(){
        Random rnd = new Random();
        int doorCar = rnd.nextInt(3);
        int choice = rnd.nextInt(3);
        if (choice == doorCar){
            int decision = rnd.nextInt(2);
            return decision == 0;
        }else {
            int decision = rnd.nextInt(2);
            return decision == 1;
        }
    }

}