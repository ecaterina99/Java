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

        Painting adele = new Painting();
        adele.setTitle("Adele");
        adele.setArtistName("Gustav Klimt");
        adele.setMedium("Medium: oil & gold foil");
        adele.setDescription("Perhaps Klimt’s most famous work from this period, however, is the 1907 \"Portrait of Adele Bloch-Bauer I. ");
        adele.displayDetails();

        Painting sunflowers = new Painting();
        sunflowers.setTitle("Sunflowers");
        sunflowers.setArtistName("Van Gogh");
        sunflowers.setMedium("Medium: oil & gold foil");
        sunflowers.setDescription("Vincent van Gogh painted this luminous image of sunflowers from memory, in the depths of winter in 1889.");
        sunflowers.displayDetails();
        sunflowers.addCritique("Good Painting");
        sunflowers.getCritiqueSummary();



        Sculpture david = new Sculpture();
        david.setTitle("David");
        david.setArtistName("Michelangelo");
        david.setMaterials("Material: Marble");
        david.setDescription("david       is a masterpiece of Italian Renaissance sculpture in marble created from 1501 to 1504 by Michelangelo. With a height of 5.17 metres , the David was the first colossal marble statue made in the High Renaissance, and since classical antiquity, a precedent for the 16th century and beyond. ");
        david.displayDetails();
        david.addCritique("The work was assigned to Michelangelo by the workers of the Florence cathedral on 16 August 1501, for a remuneration of 400 ducats.");
        david.getCritiqueSummary();

        Artist gustav = new Artist();
        gustav.setName("Gustav Klimt");
        gustav.setBio("Born in 1862, Austrian painter Gustav Klimt became known for the highly decorative style and erotic nature of his works, which were seen as a rebellion against the traditional academic art of his time. His most famous paintings are The Kiss and Portrait of Adele Bloch-Bauer.");
        gustav.getArtPiece(theKiss);
        gustav.getArtPiece(adele);
        System.out.println(gustav.getPortfolio());

        Artist vanGogh = new Artist();
        vanGogh.setName("Van Gogh");
        vanGogh.setBio("Vincent Van Gogh was born on March 30, 1853, in Groot Zundert, North Brabant, Netherlands. ");
        vanGogh.getArtPiece(sunflowers);
        System.out.println(vanGogh.getPortfolio());


        Exhibition exhibition = new Exhibition();
        exhibition.addToExhibition(theKiss);
        exhibition.addToExhibition(david);
        exhibition.addToExhibition(adele);
        exhibition.addToExhibition(sunflowers);

        System.out.println(exhibition.displayExhibitionDetails());





    }
}
