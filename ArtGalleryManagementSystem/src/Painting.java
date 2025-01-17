import java.util.ArrayList;
import java.util.List;

public class Painting extends ArtPiece implements Critiqueable {

    private String medium;
    List<String> Critiques = new ArrayList<>();

    public void setMedium(String medium) {
        this.medium = medium;
    }
    public String getMedium() {
        return medium;
    }

    @Override
    public void getCritiqueSummary() {
        for (String Critique : Critiques) {
            System.out.println(Critique);
        }
    }

    public void displayDetails() {

        String formattedDescription = formatDescription(this.getDescription());
        StringBuilder output = new StringBuilder();
        output.append(this.getTitle()).append("\n");
        output.append(this.getArtistName()).append("\n");
        output.append(formattedDescription).append("\n");
        System.out.println(output + this.getMedium());
    }

    public void addCritique(String critique) {
        if (critique.isEmpty() || critique.equals(" ")) {
            try {
                throw new EmptyCritiqueException();
            } catch (EmptyCritiqueException e) {
                System.out.println(e.getMessage());
            }
        } else if (critique.length() > 200) {
            System.err.println("Critique truncated to 200 characters.");
            critique = critique.substring(0, 200);
        }
        Critiques.add(critique);
    }
}


