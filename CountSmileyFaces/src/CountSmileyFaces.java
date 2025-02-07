/*
Given an array (arr) as an argument complete the function countSmileys
that should return the total number of smiling faces.
Rules for a smiling face:
Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
Every smiling face must have a smiling mouth that should be marked with either ) or D
No additional characters are allowed except for those mentioned.
 */

import java.util.ArrayList;
import java.util.List;

public class CountSmileyFaces {
    public static void main(String[] args) {
        List<String> smileyFaces = new ArrayList<>();
        smileyFaces.add(":)");
        smileyFaces.add(":)");
        smileyFaces.add("x-]");
        smileyFaces.add(":ox");
        smileyFaces.add(";-(");
        smileyFaces.add(";-)");
        smileyFaces.add(";~(");
        smileyFaces.add(":~D");
        smileyFaces.add("D:");

        int cnt = 0;
        for (String face : smileyFaces) {
            if (face.matches("[:;]{1}[-~]?[)D]{1}")) {
                System.out.println(face);
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}