import java.util.ArrayList;
import java.util.List;

public abstract class ArtPiece {
    private String title;
    private String artistName;
    private String description;
    List<String> Critiques = new ArrayList<>();

    public ArtPiece() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void displayDetails();

    public void getCritiqueSummary() {
        for (String Critique : this.Critiques) {
            System.out.println(Critique);
        }
    }

    public String formatDescription(String description) {
        description = description.replaceAll("\\s+", " ")
                .replaceAll("painting", "masterpiece")
                .trim();

        char[] charArray = description.toCharArray();
        if (charArray.length > 0) {
            charArray[0] = Character.toUpperCase(charArray[0]);
        }

        for (int i = 1; i < charArray.length - 1; i++) {
            if (charArray[i] == '.') {
                charArray[i + 2] = Character.toUpperCase(charArray[i + 2]);
            }
        }
        description = new String(charArray);
        return description;
    }
}
