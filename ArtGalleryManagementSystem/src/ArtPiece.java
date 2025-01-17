import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.List;

public abstract class ArtPiece {
    private String title;
    private String artistName;
    private String description;
    public abstract void displayDetails();

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

    public ArtPiece() {
    }

    public String formatDescription(String description) {
        String formattedDescription = description;
        formattedDescription.replaceAll("\\s+", " ")
                .replaceAll("painting", "masterpiece")
                .trim();

        char[] charArray = formattedDescription.toCharArray();
        if (charArray.length > 0) {
            charArray[0] = Character.toUpperCase(charArray[0]);
        }

        for (int i = 1; i < charArray.length - 1; i++) {
            if (charArray[i] == '.') {
                charArray[i + 2] = Character.toUpperCase(charArray[i + 2]);
            }
        }
        formattedDescription = new String(charArray);
        return formattedDescription;
    }
}
