import java.io.Serializable;

public class Painting extends ArtPiece implements Critiqueable{

    @Override
    public void displayDetails(String title, String artistName, String description) {
        String formattedDescription = formatDescription(description);
        StringBuilder output = new StringBuilder();
        output.append(title).append("\n");
        output.append(artistName).append("\n");
        output.append(formattedDescription).append("\n");
        System.out.println(output);
    }

    @Override
    public String addCritique(String critique) {
        if (critique.isEmpty() || critique.equals(" ")) {
            try {
                throw new EmptyCritiqueException();
            } catch (EmptyCritiqueException e) {
                System.out.println(e.getMessage());
            }
        }

        else if (critique.length() > 200){
         System.out.println("Critique truncated to 200 characters.");
        }
        return critique;

    }

    @Override
    public String getCritiqueSummary() {
        return "";
    }

}
