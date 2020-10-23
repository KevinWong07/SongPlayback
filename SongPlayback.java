import java.util.*;
import java.io.*;

public class SongPlayback{

    static Playlist playlist = new Playlist();
    
    final static String[] filePath = {"\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", "\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv"};

    public SongPlayback (String[] filePath) throws IOException {
        for (String a : filePath) {
            String row = "";
            Scanner sc = new Scanner(new BufferedReader(new FileReader(a)));

            while ((sc.hasNextLine())) {
                Data artist = new Data();
                row = sc.nextLine();
                String[] arr = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].charAt(0) == ('"')) {
                        arr[i] = arr[i].substring(1, arr[i].length() - 1);
                    }
                }
                artist.setSong(arr[1]);
                artist.setArtist(arr[2]);
                playlist.append(artist);
            }
            sc.close();
        }
    }

    public static void playList(Playlist list) throws IOException{
        Data current = list.head;
		File file = new File("Playlist.csv");
        FileWriter fw = new FileWriter(file); 
        
		while (current != null) {
			fw.write(current.toString()); 
			fw.write(current.toString() + "\n"); 
			current = current.next;
		}
		fw.close();
	}

    public static void Main(String[] args) {
        SongPlayback playlist = new SongPlayback(filePath);

        playlist.sort(playlist.head);
        playlist.removeDuplicates();

    }
}