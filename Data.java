import java.util.*;
import java.io.*;

public class Data {
    String artist, song;
	Data next;

    public Data() {
    }
    public void setArtist(String s) {
        artist = s;
    }
    public String getArtist() {
        return artist;
    }

    public void setSong(String s) {
        song = s;
    }
    public String getSong() {
        return song;
    }
}

class Playlist {
    Data head;

    public Playlist() {
        head = null;
    }

    public void push(Data d) {
        if (head == null) {
            head = d;
            head.next = null;
        } else {
            Data temp = d;
            temp.next = head;
            head = temp;
        }
    }
    public void append(Data d) {
        if (head == null) {
			head = d;
			head.next = null;
		} else {
            Data temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

			temp.next = d;
			d.next = null;
		}
    }
    void removeDuplicates() {
    	Data first = head;
        Data second, temp = null;
        
        while (first != null && first.next != null) {
            second = first;

            while (second.next != null) {
                if (first.artist == second.next.artist) {
                    temp = second.next;
                    second.next = second.next.next;
                }
                else {
                    second = second.next;
                }
            }
            first = first.next;
        }
    }
}
