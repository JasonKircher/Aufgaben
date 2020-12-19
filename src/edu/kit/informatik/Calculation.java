package edu.kit.informatik;

public class Calculation {
    /**
     * Multipliziert 2 quadratische int[][]
     * @param in1   (int[][]) Quadratische Matrix 1
     * @param in2   (int[][]) Quadratische Matrix 2
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

    /**
     * Kreiert und multipliziert die Adjazenz Matrix so hüufig wie erforderlich
     * @param paths         (String[]) Die einzelnen Pfäde, welche die knoten im graphen verbinden
     * @param pathlength    (String) Die Pfadlänge, die durch Komandozeilenargumente übergeben wird
     * @return              (int[][]) Die Adjazenz Matrix, welche so oft, wie nötig, mit sich selbst multipliziert wurde
     */
    public static int[][] adjacencyMatrixMultiplier(String[] paths, String pathlength) {
        int[][] adjacencyMatrix =    {{0, 0, 0, 0},
                                     {0, 0, 0, 0},
                                     {0, 0, 0, 0},
                                     {0, 0, 0, 0}};


        for(int i = 0; i < paths.length; i++) {
            String[] temp = paths[i].split(" ");
            int tempStart = Integer.parseInt(temp[0]);
            int tempEnd = Integer.parseInt(temp[1]);

            adjacencyMatrix[tempStart][tempEnd] = 1;
        }
        int[][] temp = adjacencyMatrix;
        for (int i = 1; i < Integer.parseInt(pathlength); i++) {
            temp = Calculation.multiplyMatrices(temp, adjacencyMatrix);
        }
        return temp;
    }
}
