package edu.kit.informatik;

public class Main {
    /**
     * Ausgabe des Programms
     * @param args  Eingabe, an Stelle 0: path, Stelle 1: Startstadt, Stelle 2: Zielstadt, Stelle 3: Pfadlänge
     */
    public static void main(String[] args) {
        //Ausgabe der Matrix an dieser Stelle
        Terminal.printLine(Calculation.adjacencyMatrixMultiplier(Terminal.readFile(args[0]), args[3])
                            [Integer.parseInt(args[1])][Integer.parseInt(args[2])]);
    }
}
