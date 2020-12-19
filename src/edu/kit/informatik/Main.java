package edu.kit.informatik;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try{
            String path = args[0];
            String startingCity = args[1];
            String destinationCity = args[2];
            String pathlength = args[3];
        } catch (Exception e) {

        }
        String pathlength = "3";
        String[] file = {"1 0", "1 2", "2 0", "0 2", "2 3", "3 2", "0 3"};
        String startingCity = "1";
        String destinationCity = "0";

        int[][] adjazenzMatrix =    {{0, 0, 0, 0},
                                     {0, 0, 0, 0},
                                     {0, 0, 0, 0},
                                     {0, 0, 0, 0}};

        // Bestimmung der adjazenzMatrix
        for(int i = 0; i < file.length; i++) {
            String[] temp = file[i].split(" ");
            int tempStart = Integer.parseInt(temp[0]);
            int tempEnd = Integer.parseInt(temp[1]);

            adjazenzMatrix[tempStart][tempEnd] = 1;
        }
        Terminal.printLine(Arrays.deepToString(adjazenzMatrix));

        // Bestimmung der passenden länge der Pfäde
        int[][] temp = adjazenzMatrix;
        for (int i = 1; i < Integer.parseInt(pathlength); i++) {
            temp = multiplyMatrices(temp, adjazenzMatrix);
        }
        Terminal.printLine(Arrays.deepToString(temp));

        //Ausgabe der Matrix an dieser Stelle
        Terminal.printLine(temp[Integer.parseInt(startingCity)][Integer.parseInt(destinationCity)]);
    }

    /**
     * Multipliziert 2 quadratische int[][]
     * @param in1
     * @param in2
     * @return      (int[][]) das produkt der Multiplikation
     */
    public static int[][] multiplyMatrices(int[][] in1, int[][] in2) {
        int length = in1.length; //quadratisch, daher nur eine länge benötigt
        int[][] output = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                output[i][j] = 0;
                for (int k = 0; k < length; k++) {
                    output[i][j] += in1[i][k] * in2[k][j];
                }
            }
        }
        return output;
    }
}
