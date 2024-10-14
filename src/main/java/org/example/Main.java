package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Статистика при полностью рандомных решениях игрока.");
        statistic(new Game(0));
        System.out.println("Статистика при изменении первоначального выбора игрока.");
        statistic(new Game(1));
        System.out.println("Статистика при неизменном первоначальном выборе игрока.");
        statistic(new Game(2));
    }

    public static void statistic(Game game){
        HashMap<Integer,Boolean> statistic = new HashMap<>();
        for (int i = 0; i < 10000; i++){
            statistic.put((i+1),game.start());
        }
        int countVin = 0;
        for (Boolean result : statistic.values()){
            if (result) countVin++;
        }
        double procentVin = (1/((double) statistic.size() /countVin))*100;
        double procentDefeat = 100.0 - procentVin;
        System.out.printf("Победы: %.2f %s\nПоражения: %.2f%s\n",procentVin,'%',procentDefeat,'%');
    }

    public static class Game{
        private final int typeGame;

        public Game(int typeGame){
            this.typeGame = typeGame;
        }

        public Boolean start(){
            switch (this.typeGame){
                case 0:
                    return game();
                case 1:
                    return game(true);
                case 2:
                    return game(false);
            }
            return null;
        }

        private Boolean game(){
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

        private static Boolean game(Boolean flag){
            Random rnd = new Random();
            int doorCar = rnd.nextInt(3);
            int choice = rnd.nextInt(3);
            if (choice == doorCar){
                return !flag;
            } else {
                return flag;
            }
        }
    }
}