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


//public class BullsAndCows {
//    public BullsAndCows(int n) {
//        //set the secret number
//        private int existingNumber  = new int [4];
//        private int givenNumber = new int [4];
//
//          public BullsAndCows(int givenNumber[]) {
//            for ( int secretNumber : givenNumber){
//                this.secretNumber = secretNumber;
//            }
//        }
//
//    }

//    public String compareWith(int existingNumber[], int givenNumber[]) {
//        int cntBulls=0;
//        int cntCows= 0;
//        for( int i = 0; i < existingNumber.length; i ++){
//            for( int j = 0; j < givenNumber.length; j ++){
//                if (existingNumber[i] == givenNumber[i]){
//                    cntBulls++;
//                }
//                else{
//                    cntCows++;
//                }
//            }
//        }
//        System.out.println("Bulls: "+ cntBulls);
//        System.out.println("Cows: "+ cntCows);
//        return cntBulls;
//        return  cntCows;
//
//    }




//    public class BullsAndCows {
//        int n;
//        int count = 0;
//        boolean win = false;
//        int[] n1;
//
//        public BullsAndCows(int n) {
//            System.out.println(n);
//            if (n < 1000 || n > 9999) {
//                throw new IllegalArgumentException();
//            }
//            this.n = n;
//            this.n1 = new int[] {this.n / 1000, this.n % 1000 / 100, this.n % 100 / 10, this.n % 10};
//            for (int i = 0; i < 4; i++) {
//                for (int j = 0; j < 4; j++) {
//                    if (n1[i] == n1[j] && i != j) {
//                        throw new IllegalArgumentException();
//                    }
//                }
//            }
//        }

//        public String compareWith(int n) {
//            if (win) {
//                return "You already won!";
//            }
//            if (count >= 8) {
//                return  "Sorry, you're out of turns!";
//            }
//            if (n == this.n) {
//                this.win = true;
//                return "You win!";
//            }
//            if (n < 1000 || n > 9999) {
//                throw new IllegalArgumentException();
//            }
//
//            int bulls = 0;
//            int cows = 0;
//            int[] n2 = new int[] {n / 1000, n % 1000 / 100, n % 100 / 10, n % 10};
//            for (int i = 0; i < 4; i++) {
//                for (int j = 0; j < 4; j++) {
//                    if (n2[i] == n2[j] && i != j) {
//                        throw new IllegalArgumentException();
//                    }
//                }
//            }
//            for (int i = 0; i < 4; i++) {
//                for (int j = 0; j < 4; j++) {
//                    if (this.n1[i] == n2[j]) {
//                        if (i == j) {
//                            bulls++;
//                        } else {
//                            cows++;
//                        }
//                    }
//                }
//            }
//            this.count++;
//            if (bulls == 1 && cows == 1) {
//                return "1 bull and 1 cow";
//            }
//            if (bulls == 1) {
//                return "1 bull and " + cows + " cows";
//            }
//            if (cows == 1) {
//                return bulls + " bulls and 1 cow";
//            }
//            return bulls + " bulls and " + cows + " cows";
//        }
//    }