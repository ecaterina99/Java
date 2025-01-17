public class ArtGalleryManagementSystem {
    public static void main(String[] args) {
        Painting theKiss = new Painting();
        theKiss.setTitle("The Kiss");
        theKiss.setArtistName("Gustav Klimt");
        theKiss.setDescription(" gustav Klimt's  painting     'The Kiss' portrays a couple's intimate embrace, wrapped in golden patterns and symbolic motifs, embodying love and passion. dimensions: 1,8 m x 1,8 m.  ");
        theKiss.setMedium("Medium: oil & gold foil");
        theKiss.displayDetails();
        theKiss.addCritique("The golden style and subject matter, The Kiss is celebrated for other details distinctive to the artist!");
        theKiss.addCritique("Observing The Kiss, we perceive the ancient echoes of a glorious past, the one of Byzantine mosaics with their golden backgrounds, which the artist had seen in Venice and Ravenna. But that is not all, this opulent appearance is declined by absorbing contemporary vibes, such as the decorative component typical of the Art Nouveau style and the exotic bi-dimensionality, typical of Japanese art and so appreciated by the Impressionists.");
        theKiss.getCritiqueSummary();

        Sculpture david = new Sculpture();
        david.setTitle("David");
        david.setArtistName("Michelangelo");
        david.setMaterials("Material: Marble");
        david.setDescription("david       is a masterpiece of Italian Renaissance sculpture in marble created from 1501 to 1504 by Michelangelo. With a height of 5.17 metres , the David was the first colossal marble statue made in the High Renaissance, and since classical antiquity, a precedent for the 16th century and beyond. ");
        david.displayDetails();
        david.addCritique(" ");

    }
}
