public class Main {
	public static void main(String [] args) {
    //simulation de différents matchs en fonction du niveau
    /*Joueur[] tab = new Joueur[]{new JoueurPro(0,0), new JoueurSuper(5,2)};
    Simulation s = new Simulation(8,4,tab);
    s.jeu();*/


		Simulation s0 = new Simulation(0);
    s0.jeu();
    String sss0 = LogMatch.getInstance().afficherLog();
    System.out.println("Affichage du log:");
    System.out.println(sss0);
    LogMatch.getInstance().effacerInstance();
    
    /*Simulation s1 = new Simulation(1);
    s1.jeu();
    String sss1 = LogMatch.getInstance().afficherLog();
    System.out.println("Affichage du log:");
    System.out.println(sss1);
    LogMatch.getInstance().effacerInstance();
    
    Simulation s2 = new Simulation(2);
    s2.jeu();
    String sss2 = LogMatch.getInstance().afficherLog();
    System.out.println("Affichage du log:");
    System.out.println(sss2);
    LogMatch.getInstance().effacerInstance();
   
    Simulation s3 = new Simulation(3);
    s3.jeu();
    String sss3 = LogMatch.getInstance().afficherLog();
    System.out.println("Affichage du log:");
    System.out.println(sss3);
    LogMatch.getInstance().effacerInstance();
    
    Simulation s4 = new Simulation(4);
    s4.jeu();
    String sss4 = LogMatch.getInstance().afficherLog();
    System.out.println("Affichage du log:");
    System.out.println(sss4);
    LogMatch.getInstance().effacerInstance();*/
   
	}
}