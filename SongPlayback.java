import java.util.*;
import java.io.*;

public class SongPlayback{

    static Playlist list = new Playlist();
    
    // list all .csv file locations
    final static String[] filePath = {"C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-06-26--2020-07-03.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-07-03--2020-07-10.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-07-10--2020-07-17.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-07-17--2020-07-24.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-07-24--2020-07-31.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-07-31--2020-08-07.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-08-07--2020-08-14.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-08-14--2020-08-21.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-08-21--2020-08-28.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-08-28--2020-09-04.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-09-04--2020-09-11.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-09-11--2020-09-18.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-09-18--2020-09-25.csv", 
                                        "C:\\Users\\Admin\\Documents\\GitHub\\SongPlayback\\CSV\\regional-global-weekly-2020-09-25--2020-10-02.csv"};

    // takes all information from above .csv files and inputs them into an array
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
                list.append(artist);
            }
            sc.close();
        }
    }

    // creates playlist from the array
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

    public static void main(String[] args) throws IOException {
        SongPlayback playlist = new SongPlayback(filePath);
        
        list.removeDuplicates(); // calls removeDuplicates operation from Data.java 
        playList(list);
    }
}