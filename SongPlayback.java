import java.util.*;
import java.io.*;

public class SongPlayback{
    
    final static String[] filePath = {"\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv"};

    public MyQueue (String[] filePath) throws IOException {
        for (String a : filePath) {
            String row = "";
            Scanner sc = new Scanner(new BufferedReader(new FileReader(a)));
            
        }
    }

    public static void Main(String[] args) {

    }
}