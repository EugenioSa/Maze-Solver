import java.io.*; 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirst implements Runnable {

    public char[][] matrix;
    private Queue<Point> visited;
    private Queue<Point> path;
    private Queue<Point> frontier;
    public Queue<Point> result;
    private Point current;
    public Point standing;
    private Point aux;
    private Point initial;
    private Point end;
    private long startTime;
    private long endTime;
    public long timeElapsed;

    public BreadthFirst(char[][] matrix,Point initial, Point end) {
        this.matrix = matrix;
        this.visited = new LinkedList<Point>();
        this.frontier = new LinkedList<Point>();
        this.path = new LinkedList<Point>();
        this.aux = new Point();
        this.initial = initial;
        this.standing = initial;
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
            threadMessage(timeElapsed + " nanos","BFS");
        } catch (Exception e) {
            threadMessage("Interrupted","BFS");
        }
    }

    public void reverse(Queue<Point> q) {
        Stack<Point> s = new Stack();  //create a stack

        //while the queue is not empty
        while(!q.isEmpty())
        {  //add the elements of the queue onto a stack
            s.push(q.poll());
        } 

        //while the stack is not empty
        while(!s.isEmpty())
        { //add the elements in the stack back to the queue
            q.add(s.pop());
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

    public Boolean checkIfOnFrontier(Queue<Point> q, Point check) {
        for(Point p : q) { 
             if(check.x == p.x && check.y == p.y) {
                 return true;
             }
        }
        return false;
    }

    public Point findPoint (Queue<Point> q, int checkx, int checky) {
        Point aux = new Point();
        for(Point p : q) { 
             if(checkx == p.x && checky == p.y) {
                 return p;
             }
        }
        return aux;
    }

    public Boolean backTrackPath (Point end) {
        Point p;
        if(end.x == initial.x && end.y == initial.y) {
            path.add(initial);
            return true;
        }
        path.add(end);
        p = findPoint(visited,end.predX,end.predY);
        backTrackPath(p);
        return false;
    }

    public Queue<Point> algorithm() {
        frontier.add(this.initial);
        this.aux.x = 0;
        this.aux.y = 0;
        char counter = 65;
        while(!frontier.isEmpty()) {
            current = frontier.element(); //Peek first element
            standing = frontier.element();

            //Check left of standing
            this.aux.x = standing.x;
            this.aux.y = standing.y - 1;
            if(matrix[standing.x][standing.y - 1] != '#' && !checkIfVisited(visited,aux) && !checkIfOnFrontier(frontier,aux)){
                aux.predX = standing.x;
                aux.predY = standing.y;
                frontier.add(aux);
            }

            //Check rigth of standing
            this.aux = new Point();
            this.aux.x = standing.x;
            this.aux.y = standing.y + 1;
            if(matrix[standing.x][standing.y + 1] != '#' && !checkIfVisited(visited,aux) && !checkIfOnFrontier(frontier,aux)){
                aux.predX = standing.x;
                aux.predY = standing.y;
                frontier.add(aux);
            }

            //Check up of standing
            this.aux = new Point();
            this.aux.x = standing.x - 1;
            this.aux.y = standing.y;
            if(matrix[standing.x - 1][standing.y] != '#' && !checkIfVisited(visited,aux) && !checkIfOnFrontier(frontier,aux)){
                aux.predX = standing.x;
                aux.predY = standing.y;
                frontier.add(aux);
            }

            //Check down of standing
            this.aux = new Point();
            this.aux.x = standing.x + 1;
            this.aux.y = standing.y;
            if(matrix[standing.x + 1][standing.y] != '#' && !checkIfVisited(visited,aux) && !checkIfOnFrontier(frontier,aux)){
                aux.predX = standing.x;
                aux.predY = standing.y;
                frontier.add(aux);
            }

            //Place current in visited
            matrix[current.x][current.y] = (char)counter;
            visited.add(this.current);
            counter++;

            if(current.x == end.x && current.y == end.y) {
                backTrackPath(current);
                reverse(path);
                break;
            }
            //Dequeue frontier
            frontier.poll();
            this.aux = new Point();
        }
        return path;
    }
}