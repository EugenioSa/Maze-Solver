# Maze-Solver

## How to use
### 1)	Put a maze inside the file maze.txt
  * a.	The maze must be square
  * b.	It must have an initial point marked with an “o”
  * c.	It must have an end point marked with an “x”
  * d.	It must have walls marked with “#”
  * e.	The paths must be marked with space
  * f.	It must have a viable path between “o” and “x”
  * g.	The maze must have a complete border of walls

### 2)	Run Jar
  * a.	Open cmd in the folder the jar is placed an run command: java -jar MazeResolver.jar


### 3)	Enter the size of maze
  * a.	Enter the length of the maze in one axis (remember length in “x” and “y” must be equal)
  * b.	For the last case, the number will be: 10
### 4)	Enter the coordinates for the initial point in the maze (where “o” is placed)
  * a.	The count of rows and columns start in 0
  * b.	For the last case, the x coordinate for initial point will be 1
  * c.	For the last case, the y coordinate for initial point will be 1
### 5)	Enter the coordinates for the end point in the maze (where “x” is placed)
  * a.	The count of rows and columns start in 0
  * b.	For the last case, the x coordinate for end point will be 8
  * c.	For the last case, the y coordinate for end point will be 8
### 6)	Solution will be printed
  * a.	Initial maze
  * b.	Times of each algorithm
  * c.	Maze solved by BFS
  * d.	Optimal path of BFS
  * e.	Maze solved by DFS
  * f.	Optimal path of DFS
