//permet de generer un nom aleatoirement
public class Nommage {
    private final static char[] VOYELLES = { 'e', 'u', 'o', 'a', 'i', 'y', 'U', 'E', 'O', 'A', 'I', 'Y' };
    private final static char MAJ = 'A';
    private final static char MIN = 'a';

    public Nommage() {
    }
    
    private static boolean estVoyelle(char c) {
      //méthode qui vérifie si c est une voyelle
        for (int i = 0; i < VOYELLES.length; i++) {
            if (c == VOYELLES[i])
                return true;
        }
        return false;
    }

    private static char tirageVoyelle(char maj_min){
      //méthode qui fait un tirage au sort une voyelle (majuscule ou minuscule au choix: maj_min)
        char c = (char) ((int) (Math.random() * 26) + maj_min);
        while (!estVoyelle(c)) {
            c = (char) ((int) (Math.random() * 26) + maj_min);
        }
        return c;
    }

    private static char tirageConsonne(char maj_min) {
      //méthode qui fait un tirage au sort une consonne (majuscule ou minuscule au choix: maj_min)
        char c = (char) ((int) (Math.random() * 26) + maj_min);
        while (estVoyelle(c) == true) {
            c = (char) ((int) (Math.random() * 26) + maj_min);
        }
        return c;
    }

    public static String nom() {
      //méthode qui donne un nom alétoire composé de 4 lettres
        return "" + tirageConsonne(MAJ) + tirageVoyelle(MIN) + tirageConsonne(MIN) + tirageConsonne(MIN);

    }

}