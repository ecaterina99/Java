
public static void main(String[] args) {
    String convertString = "GCAT";
    dnaToRna(convertString);
    girlOrBoy("XX");
    
}

//Use method replaceAll
public static void dnaToRna(String dna) {
    dna = dna.replaceAll("[T]", "U");
    System.out.println(dna);
}

//Use String.contains
public static void girlOrBoy(String sperm) {
    String answer = "";

  /*  if(sperm.contains("Y")) {
        answer="Congratulations! You're going to have a son.";
    }else {
        answer = "Congratulations! You're going to have a daughter.";
    }
    System.out.println(answer);

   */
    System.out.println("Congratulations! You're going to have a "
            + (sperm.contains("Y") ? "son." : "daughter."));
}



