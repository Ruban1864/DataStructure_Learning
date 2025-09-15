package Arrays.Matrix;
import java.util.*;
//Leetcode : 3248.Snake in Matrix
public class SnakeinMatrix {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0, col = 0;

        // Process each command
        for (String move : commands) {
            switch (move) {
                case "LEFT":  col--; break;
                case "RIGHT": col++; break;
                case "UP":    row--; break;
                case "DOWN":  row++; break;
            }
        }

        // Convert (row, col) to 1D position
        return (row * n) + col;
    }

    // Example usage
    public static void main(String[] args) {
        SnakeinMatrix sol = new SnakeinMatrix();

        int n = 3 ;
        List<String> commands1 = Arrays.asList("RIGHT", "DOWN");
        System.out.println("Final position: " + sol.finalPositionOfSnake(n, commands1));
        // Start (0,0), move → (0,1), ↓ (1,1), ↓ (2,1)
        // Index = 2*3 + 1 = 7

        List<String> commands2 = Arrays.asList("RIGHT", "RIGHT", "DOWN", "LEFT");
        System.out.println("Final position: " + sol.finalPositionOfSnake(n, commands2));
        // Start (0,0), → (0,1), → (0,2), ↓ (1,2), ← (1,1)
        // Index = 1*3 + 1 = 4

        List<String> commands3 = Arrays.asList("UP", "LEFT");
        System.out.println("Final position: " + sol.finalPositionOfSnake(n, commands3));
        // Start (0,0), ↑ (-1,0), ← (-1,-1)
        // Index = (-1)*3 + (-1) = -4
    }
}

