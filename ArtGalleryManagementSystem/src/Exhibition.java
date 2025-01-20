import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Exhibition {
    public List<ArtPiece> ArtPieceCollection = new ArrayList<>();

    public void addToExhibition(ArtPiece artPiece) {
        if (artPiece.getTitle().isEmpty() || artPiece.getTitle().equals(" ")) {
            try {
                throw new EmptyTitleException();
            } catch (EmptyTitleException e) {
                System.out.println(e.getMessage());
            }
        }
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

    public void searchArtPiece(String keyword) {

        List<ArtPiece> filteredArtPieces = ArtPieceCollection.stream()
                .filter(artPiece -> artPiece.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .toList();

        if (!filteredArtPieces.isEmpty()) {
            System.out.println("Keyword: " + keyword);
            for (ArtPiece artPiece : filteredArtPieces) {
                System.out.println("Found: " + artPiece.getTitle());
            }
        } else {
            System.out.println("Not found");
        }
    }

    public void cleanTitles() {
        System.out.println("Cleaned titles: ");
        for (ArtPiece artPiece : this.ArtPieceCollection) {
            String result = artPiece.getTitle().toLowerCase().replaceAll("[!$@#%&^*]", " ");
            result = result.substring(0, 1).toUpperCase() + result.substring(1);

            System.out.println(result);
        }
    }

}



