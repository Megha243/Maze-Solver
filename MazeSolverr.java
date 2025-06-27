package MazeSolver;

import java.util.Scanner;

public class MazeSolverr {

    // Maze dimensions
    static final int N = 4;

    // Utility function to print the solution matrix
    public static void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check if x, y is a valid move
    public static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    // Solves the maze using backtracking
    public static boolean solveMaze(int[][] maze) {
        int[][] solution = new int[N][N];

        if (!solveMazeUtil(maze, 0, 0, solution)) {
            System.out.println("No solution exists");
            return false;
        }

        printSolution(solution);
        return true;
    }

    // Utility function to solve the maze recursively
    public static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            solution[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            solution[x][y] = 1;

            // Move right
            if (solveMazeUtil(maze, x + 1, y, solution))
                return true;

            // Move down
            if (solveMazeUtil(maze, x, y + 1, solution))
                return true;

            // Backtrack
            solution[x][y] = 0;
            return false;
        }

        return false;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of row");
        int a=sc.nextInt();
        System.out.println("Enter the value of column");
        int b=sc.nextInt();
        int [][]maze=new int[a][b];
        for(int i=0;i<a;i++){
            System.out.println("Input Values of Row:"+ ++i);
            for(int j=0;j<b;j++){
                maze[i][j]=sc.nextInt();
            }
        }
       
            // {1, 0, 0, 0},
            // {1, 1, 0, 1},
            // {0, 1, 0, 0},
            // {1, 1, 1, 1}
        

        solveMaze(maze);
    }
}
