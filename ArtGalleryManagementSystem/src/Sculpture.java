import java.util.List;

public class Sculpture extends ArtPiece implements Critiqueable {
    private String materials;

    @Override
    public void displayDetails() {
        String formattedDescription = formatDescription(this.getDescription());
        StringBuilder output = new StringBuilder();
        output.append(this.getTitle()).append("\n");
        output.append(this.getArtistName()).append("\n");
        output.append(formattedDescription).append("\n");
        System.out.println(output + this.getMaterials());
    }

    @Override
    public void addCritique(String critique) {
        if (critique.isEmpty() || critique.equals(" ")) {
            try {
                throw new EmptyCritiqueException();
            } catch (EmptyCritiqueException e) {
                System.out.println(e.getMessage());
            }
        } else if (critique.length() > 200) {

            critique = "Critique truncated to 200 characters.\n" +
                    critique.substring(0, 200);
            System.out.println(critique);
        }

    }

    public void getCritiqueSummary() {
        return;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getMaterials() {
        return materials;
    }
}
