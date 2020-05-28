import java.io.*; 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirst implements Runnable {

    public char[][] matrix;
    private Queue<Point> visited;
    private Stack<Point> path;
    private Stack<Point> auxPath;
    public Stack<Point> result;
    private Point standing;
    private Point aux;
    private Point initial;
    private Point end;
    private long startTime;
    private long endTime;
    public long timeElapsed;
    private char counter = 65;

    public DepthFirst(char[][] matrix,Point initial, Point end) {
        this.matrix = matrix;
        this.visited = new LinkedList<Point>();
        this.path = new Stack<Point>();
        this.initial = initial;
        this.end = end;
        this.startTime = 0;
        this.endTime = 0;
        this.timeElapsed = 0;
    }

    static void threadMessage(String message, String name) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", name, message);
    }


    public void run() {
        try{
            startTime = System.nanoTime();
            this.result = algorithm();
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            threadMessage(timeElapsed + " nanos","DFS");
        } catch (Exception e) {
            threadMessage("Interrupted","DFS");
        }
    }

    public Boolean checkIfVisited(Queue<Point> q, Point check) {
        for(Point p : q) { 
             if(check.x == p.x && check.y == p.y) {
                 return true;
             }
        }
        return false;
    }

    public Boolean checker () {
        Point standing = path.peek(); 

        if(end.x == standing.x && end.y == standing.y) {
            auxPath = (Stack<Point>)path.clone();
            return true;
        }

        //Check up of standing
        this.aux = new Point();
        this.aux.x = standing.x - 1;
        this.aux.y = standing.y;
        if(matrix[standing.x - 1][standing.y] != '#' && !checkIfVisited(visited,aux)){
            path.push(aux);
            visited.add(aux);
            matrix[aux.x][aux.y] = (char)counter;
            counter++;
            checker();
        }

        //Check rigth of standing
        this.aux = new Point();
        this.aux.x = standing.x;
        this.aux.y = standing.y + 1;
        if(matrix[standing.x][standing.y + 1] != '#' && !checkIfVisited(visited,aux)){
            path.push(aux);
            visited.add(aux);
            matrix[aux.x][aux.y] = (char)counter;
            counter++;
            checker();
        }

        //Check down of standing
        this.aux = new Point();
        this.aux.x = standing.x + 1;
        this.aux.y = standing.y;
        if(matrix[standing.x + 1][standing.y] != '#' && !checkIfVisited(visited,aux)){
            path.push(aux);
            visited.add(aux);
            matrix[aux.x][aux.y] = (char)counter;
            counter++;
            checker();
        }

        //Check left of standing
        this.aux = new Point();
        this.aux.x = standing.x;
        this.aux.y = standing.y - 1;
        if(matrix[standing.x][standing.y - 1] != '#' && !checkIfVisited(visited,aux)){
            path.push(aux);
            visited.add(aux);
            matrix[aux.x][aux.y] = (char)counter;
            counter++;
            checker();
        }

        path.pop();
        return false;
    }
    public Stack<Point> algorithm() {
        Boolean res;
    
        path.push(initial);
        visited.add(initial);
        matrix[initial.x][initial.y] = (char)counter;
        counter++;
        res = checker();

        return auxPath;
    }
}