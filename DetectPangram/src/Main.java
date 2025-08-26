//Given a string, detect whether or not it is a pangram. Return True if it is, False if not.
// Ignore numbers and punctuation.
public class Main {
    public static void main(String[] args) {
        String sentence = "The brown fox jumps over the lzy dog.";
        sentence = sentence.toLowerCase();
        Boolean isPanagram;
        int counter = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            if (sentence.indexOf(c) == -1) {
                counter++;
            }
        }
        if(counter>0){
            isPanagram = false;
        }
        else{
            isPanagram = true;
        }
        System.out.println("The sentence is panagram: " + isPanagram);
    }
}