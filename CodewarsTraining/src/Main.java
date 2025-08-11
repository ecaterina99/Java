public static void main(String[] args) {
    String convertString = "GCAT";
    dnaToRna(convertString);
}

//Use method replaceAll
public static void dnaToRna(String dna) {
    dna = dna.replaceAll("[T]", "U");
    System.out.println(dna);
}


