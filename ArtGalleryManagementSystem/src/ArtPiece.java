public abstract class ArtPiece {
    private String title;
    private String artistName;
      String description;

    public ArtPiece() {
    }

    public abstract void displayDetails (String title, String artistName, String description);

    public String formatDescription(String description){
        description = description.replaceAll("\\s+", " ").replaceAll("painting","masterpiece").trim();

        char[] charArray = description.toCharArray();

        if (charArray.length > 0) {
            charArray[0] = Character.toUpperCase(charArray[0]);
        }
        for(int i=1; i < charArray.length-1; i++){
            if(charArray[i] == '.'){
            charArray[i+2] = Character.toUpperCase(charArray[i+2]);
            }
        }
        description = new String(charArray);
        return description;
    }



    public void setTitle( String title ) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setArtistName( String artistName ) {
        this.artistName = artistName;
    }
    public String getArtistName() {
        return artistName;
    }
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }


}
