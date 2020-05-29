/* MazeResolver is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    MazeResolver is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with MazeResolver.  If not, see <https://www.gnu.org/licenses/>.*/

public class Point {

    public int x;
    public int y;
    public int predX;
    public int predY;

    public Point() {
        this.x = 0;
        this.y = 0;
        this.predX = 0;
        this.predY = 0;

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.predX = 0;
        this.predY = 0;

    }

    
}