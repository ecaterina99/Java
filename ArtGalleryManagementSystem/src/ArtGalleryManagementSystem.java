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
        System.out.println("\n");


        Painting adele = new Painting();
        adele.setTitle("Adele@");
        adele.setArtistName("Gustav Klimt");
        adele.setMedium("Medium: oil & gold foil");
        adele.setDescription("Perhaps Klimt’s most famous work from this period, however, is the 1907 \"Portrait of Adele Bloch-Bauer I. ");
        adele.displayDetails();
        System.out.println("\n");


        Painting starryNight = new Painting();
        starryNight.setTitle("Starry*Night");
        starryNight.setArtistName("Van Gogh");
        starryNight.setMedium("Medium: oil & gold foil");
        starryNight.setDescription("Starry Night Over the Rhône (1888) is the sister work of Starry Night (1889).");
        starryNight.displayDetails();
        starryNight.addCritique("Good Painting");
        starryNight.getCritiqueSummary();
        System.out.println("\n");


        Painting cafeTerraceAtNight = new Painting();
        cafeTerraceAtNight.setTitle("Cafe Terrace At Night");
        cafeTerraceAtNight.setArtistName("Van Gogh");
        cafeTerraceAtNight.setMedium("Medium: oil & gold foil");
        cafeTerraceAtNight.setDescription("Despite being painted more than 130 years ago, this café still exists in France and has since been renamed the Café Van Gogh. ");
        cafeTerraceAtNight.displayDetails();
        cafeTerraceAtNight.addCritique("This artwork marks the first time Van Gogh's famous post-impressionist star-filled sky is seen in one of his pieces, and it’s believed the work was painted on the ground, in person, rather than from memory. ");
        cafeTerraceAtNight.getCritiqueSummary();
        System.out.println("\n");


        Sculpture david = new Sculpture();
        david.setTitle(" ");
        david.setArtistName("Michelangelo");
        david.setMaterials("Material: Marble");
        david.setDescription("david       is a masterpiece of Italian Renaissance sculpture in marble created from 1501 to 1504 by Michelangelo. With a height of 5.17 metres , the David was the first colossal marble statue made in the High Renaissance, and since classical antiquity, a precedent for the 16th century and beyond. ");
        david.displayDetails();
        david.addCritique("The work was assigned to Michelangelo by the workers of the Florence cathedral on 16 August 1501, for a remuneration of 400 ducats.");
        david.getCritiqueSummary();
        System.out.println("\n");


        Sculpture pieta = new Sculpture();
        pieta.setTitle("PietA");
        pieta.setArtistName("Michelangelo");
        pieta.setMaterials("Material: Marble");
        pieta.setDescription("One of Michelangelo’s first major works was his Pieta, which he finished carving from a solid block of Carrara marble in 1500 when he was 23 years old.");
        pieta.displayDetails();
        pieta.addCritique("A work of art is a little like a suitcase, stuffed with issues, ideas and fragments of personal and cultural history. Each viewer who is willing to take the time might unpack it in a different way. ");
        pieta.getCritiqueSummary();
        System.out.println("\n");


        Artist gustav = new Artist();
        gustav.setName("Gustav Klimt");
        gustav.setBio("Born in 1862, Austrian painter Gustav Klimt became known for the highly decorative style and erotic nature of his works, which were seen as a rebellion against the traditional academic art of his time. His most famous paintings are The Kiss and Portrait of Adele Bloch-Bauer.");
        gustav.getArtPiece(theKiss);
        gustav.getArtPiece(adele);
        System.out.println(gustav.getPortfolio());
        System.out.println("\n");


        Artist vanGogh = new Artist();
        vanGogh.setName("Van Gogh");
        vanGogh.setBio("Vincent Van Gogh was born on March 30, 1853, in Groot Zundert, North Brabant, Netherlands. ");
        vanGogh.getArtPiece(cafeTerraceAtNight);
        vanGogh.getArtPiece(starryNight);
        System.out.println(vanGogh.getPortfolio());
        System.out.println("\n");


        Artist michelangelo = new Artist();
        michelangelo.setName("Michelangelo");
        michelangelo.setBio("Michelangelo was an Italian sculptor, painter, architect, and poet of the High Renaissance.");
        michelangelo.getArtPiece(david);
        michelangelo.getArtPiece(pieta);
        System.out.println(michelangelo.getPortfolio());
        System.out.println("\n");

        Exhibition exhibition = new Exhibition();
        exhibition.addToExhibition(theKiss);
        exhibition.addToExhibition(starryNight);
        exhibition.addToExhibition(cafeTerraceAtNight);
        exhibition.addToExhibition(adele);
        exhibition.addToExhibition(david);
        exhibition.addToExhibition(pieta);
        System.out.println(exhibition.displayExhibitionDetails());

        exhibition.sortArtPiecesByTitle();
        System.out.println("\n");

        exhibition.searchArtPiece("night");
        System.out.println("\n");

        exhibition.cleanTitles();

    }
}
