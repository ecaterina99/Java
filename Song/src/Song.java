/*
Your job is to create a class called Song.
A new Song will take two parameters, title and artist.
You will also have to create an instance method named howMany() (or how_many()).
The method takes an array of people who have listened to the song that day.
The output should be how many new listeners the song gained on that day out of all listeners.
Names should be treated in a case-insensitive manner, i.e. "John" is the same as "john".
If the same person listened to it more than once a day it should only count them once.
 */

import java.util.*;

public class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    private List<String> existingListeners = new ArrayList<>();

    public int howMany(List<String> newListeners) {
        int cnt = 0;
        for (String newListener : newListeners) {
            if (!existingListeners.contains(newListener.toLowerCase())) {
                existingListeners.add(newListener.toLowerCase());
                cnt++;
            }
        }
        return cnt;
    }
}

