import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String name;
    private String bio;
    public List<ArtPiece> ArtPiece = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public void getArtPiece(ArtPiece artPiece) {
        this.ArtPiece.add(artPiece);
    }

    public String getPortfolio() {
        StringBuilder output = new StringBuilder();
        output.append("The artist name: ").append(this.getName()).append("\n");
        output.append("The artist bio: ").append(this.getBio()).append("\n");
        output.append("The artist's portfolio: ");
        for (ArtPiece artPiece  : this.ArtPiece) {
            if (artPiece != null) {
                output.append(artPiece.getTitle()).append(", ");
            }
        }
        if (!output.toString().isEmpty()) {
            output.replace(output.length() - 2, output.length(), ".");
        }
        return output.toString();
    }

}
