import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadTxtFile {
    public String[] readLines(String filename) throws IOException
    {
        FileReader fileReader = new FileReader(filename);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        books ob = new books();
        while ((line = bufferedReader.readLine()) != null)
        {
           String[] arr = line.split(",");

            book d = new book(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7]);
            ob.adDBbook(d);
        }

        bufferedReader.close();

        return lines.toArray(new String[lines.size()]);
    }
}
