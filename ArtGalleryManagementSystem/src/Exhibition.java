import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exhibition {
    public List<ArtPiece> ArtPieceColection = new ArrayList<>();

    public void addToExhibition(ArtPiece artPiece) {
        this.ArtPieceColection.add(artPiece);
    }

    public String displayExhibitionDetails() {
        StringBuilder output = new StringBuilder();
        output.append("Exhibition Details: \n").append("Exhibition masterpices: \n");

        for (ArtPiece artPiece : this.ArtPieceColection) {
            if (artPiece != null) {
                output.append(artPiece.getTitle()).append("\n");
                if (artPiece.Critiques != null) {
                    for (String critique : artPiece.Critiques) {
                        output.append(critique).append("\n");
                    }
                }
                if(artPiece.Critiques.isEmpty()){
                        output.append("No critiques").append("\n");
                    }
                }
            }


        return output.toString();
    }


}

