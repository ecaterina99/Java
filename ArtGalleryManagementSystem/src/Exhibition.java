import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exhibition {
    public List<ArtPiece> ArtPieceCollection = new ArrayList<>();

    public void addToExhibition(ArtPiece artPiece) {
        this.ArtPieceCollection.add(artPiece);
    }

    public String displayExhibitionDetails() {
        StringBuilder output = new StringBuilder();
        output.append("Exhibition Details: \n").append("Exhibition masterpices: \n");

        for (ArtPiece artPiece : this.ArtPieceCollection) {
            if (artPiece != null) {
                output.append(artPiece.getTitle()).append(":\n");
                if (artPiece.Critiques != null) {
                    for (String critique : artPiece.Critiques) {
                        output.append(critique).append("\n");
                    }
                }
                if (artPiece.Critiques.isEmpty()) {
                    output.append("No critiques").append("\n");
                }
            }
        }
        return output.toString();
    }

    void sortArtPiecesByTitle() {
        Collections.sort(ArtPieceCollection);
        System.out.println("Sorted ArtPiece Collection: ");
        for (ArtPiece artPiece : this.ArtPieceCollection) {
                System.out.println(artPiece.getTitle());
            }

    }

}

