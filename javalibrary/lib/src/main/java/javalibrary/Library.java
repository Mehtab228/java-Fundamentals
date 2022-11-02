/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javalibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Library {
    public boolean someLibraryMethod() {
        return true;
    }

    public static ArrayList<Integer> roll(int n){
        int numberOfRolls = 0;
        ArrayList<Integer> resultRoll = new ArrayList<>();
        while(numberOfRolls !=n) {
            int newRoll = (int)(Math.floor(Math.random()*6+1));
            resultRoll.add(newRoll);
            numberOfRolls++;
        }
        return resultRoll;
    }

    public static Boolean containsDuplicates(int[] inputArray) {
        HashMap<Integer, Integer> duplicateMap = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (duplicateMap.putIfAbsent(inputArray[i], 1) !=null) {
                return true;
            }
        }
        return false;
    }

    public static double averageCalculator(int[] inputArray) {
        double average = 0.0;
        for (int i = 0; i < inputArray.length; i++) {
             average += inputArray[i];
        }
        return average/inputArray.length;
    }

    public static int[] lowestAverageArray(int[][] inputArray) {
        int index = 0;
        double avg = averageCalculator(inputArray[index]);
        for (int i = 1; i < inputArray.length; i++){
            double testingAvg = averageCalculator(inputArray[i]);
            if(testingAvg < avg){
                avg = testingAvg;
                index = i;
            }
        }
        return inputArray[index];
    }

    public static String minMaxNotIncluded(int[][] inputArray) {
        String missingTemps = "";
        int highTemp = inputArray[0][0];
        int lowTemp = inputArray[0][0];
        HashSet<Integer> tempSets = new HashSet<>();
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                tempSets.add(inputArray[i][j]);
                if (inputArray[i][j] > highTemp) {
                    highTemp = inputArray[i][j];
                }
                if (inputArray[i][j] < lowTemp) {
                    lowTemp = inputArray[i][j];
                }
            }
        }
        System.out.println("High of " + highTemp);
        System.out.println("Low of " + lowTemp);
        for (int i = lowTemp; i < highTemp; i++) {
            if (!tempSets.contains(i)) {
                missingTemps +=  "Never saw temperature: " + i + " ";
            }
        }
        return missingTemps;
    }

    public static String tally(List<String> listOfVotes) {
        String winner = "";
        int highestVote = 0;
        HashMap<String, Integer> mapVotes = new HashMap<>();
        for (String votes : listOfVotes) {
            if (mapVotes.containsKey(votes)) {
                // If key is present grabs the value for the key and stores it in currentCount and adds one to it
                int currentCount = mapVotes.get(votes);
                mapVotes.replace(votes, currentCount + 1);
            } else {
                // If key is not present it adds it to the map with a counter of 1
                mapVotes.put(votes, 1);
            }
            if (mapVotes.get(votes) > highestVote) {
                highestVote = mapVotes.get(votes);
                winner = votes;
            }
        }
        return winner;
    }
}
