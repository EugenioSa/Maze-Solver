import java.io.*; 
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;

public class MazeResolver {
    
    public static void main(String args[]) throws Exception  {
        int sizeMatrix = 0;
        int coordinate_x,coordinate_y;
        MazeReader r = new MazeReader("maze.txt");
        Scanner input = new Scanner( System.in );
        Point beg;
        Point end;
        BreadthFirst bfs;
        DepthFirst dfs;
        Queue<Point> resultb;
        Stack<Point> resultd;

        System.out.print( "\nEnter size of x axis on maze (x and y must be equal): " );
        sizeMatrix = input.nextInt();
        System.out.print(sizeMatrix);
        char[][] matrixb = new char[sizeMatrix][sizeMatrix];  
        char[][] matrixd = new char[sizeMatrix][sizeMatrix];
        //Read matrix
        matrixb = r.fileReader(sizeMatrix);
        matrixd = r.fileReader(sizeMatrix);
        //Create point to start maze (o)
        System.out.print( "\nEnter x coordinate for beginning of maze: " );
        coordinate_x = input.nextInt();
        System.out.print( "\nEnter y coordinate for beginning of maze: " );
        coordinate_y = input.nextInt();
        beg = new Point(coordinate_x,coordinate_y);
        //Create point to end maze (x)
        System.out.print( "\nEnter x coordinate for ending of maze: " );
        coordinate_x = input.nextInt();
        System.out.print( "\nEnter y coordinate for ending of maze: " );
        coordinate_y = input.nextInt();
        end = new Point(coordinate_x,coordinate_y);

        
        //Empty maze
        for(int i = 0;i< 10;i++) {
            for(int j = 0; j < 10; j++){
                System.out.print(matrixb[i][j]);
            }
            System.out.println("\n");
        }
        System.out.print('\n');

        //Execution
        bfs = new BreadthFirst(matrixb,beg,end);
        dfs = new DepthFirst(matrixd,beg,end);
        Thread t1 = new Thread(bfs);
        Thread t2 = new Thread(dfs);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        resultb = bfs.result;
        resultd = dfs.result;
        
        System.out.println("\n");
        //Resolved Maze BFS
        for(int i = 0;i< 10;i++) {
            for(int j = 0; j < 10; j++){
                System.out.print(bfs.matrix[i][j]);
            }
            System.out.println("\n");
        }
        
        System.out.print("Optimal Path BFS:");
        for(Point p : resultb) { 
            System.out.print("(" + p.x + ", " + p.y + ") "); 
        }
        System.out.println("\n");
        //Resolved Maze DFS
        for(int i = 0;i< 10;i++) {
            for(int j = 0; j < 10; j++){
                System.out.print(dfs.matrix[i][j]);
            }
            System.out.println("\n");
        }

        System.out.print("Optimal Path DFS:");
        for(Point p : resultd) { 
            System.out.print("(" + p.x + ", " + p.y + ") "); 
        }
    }
}