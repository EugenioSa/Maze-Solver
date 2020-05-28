import java.io.*;

public class MazeReader {
    
    public String file;
    public int x;
    public int y;
    
    public MazeReader(String file) {
        this.file = file;
        this.x = 0;
        this.y = 0;
    }

    public char[][] fileReader(int size) throws Exception {
        char[][] matrix = new char[size][size];  
        BufferedReader reader;
        char[] charArray;
        int i = 0;
        int j = 0;
        
		try {
			reader = new BufferedReader(new FileReader(this.file));
			String line = reader.readLine();
			while (line != null) {

                // read next line
                charArray = line.toCharArray();
                for(char c : charArray) {
                    matrix[i][j] = c;
                    j++;
                }
                i++;
                j = 0;
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        return matrix;
    }
}