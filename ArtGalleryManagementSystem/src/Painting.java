public class Painting extends ArtPiece implements Critiqueable {

    private String medium;

    public void setMedium(String medium) {
        this.medium = medium;
    }
    public String getMedium() {
        return medium;
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


