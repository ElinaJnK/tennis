public abstract class Joueur implements Skills {
	protected String nom;
	protected int classement;
	protected int x, y;
	protected double luck = 0.0;

	// x_init et y_init en fontion du terrain
	public Joueur(int x_init, int y_init) {
    //donne un nom aleatoire au joueur
		nom = Nommage.nom();
		try {
			x = x_init;
			y = y_init;
		} catch (NumberFormatException e) {
      //permet de verifier si x et y donnes sont bien des nombres
			System.out.println("Il faut des nombres dans Joueur(int,int)");
		}
	}

	public abstract Joueur clone();
  //retourne la position x du joueur
	public int getX() {
		return x;
	}
  //retourne la position y du joueur
	public int getY() {
		return y;
	}
  //change la position x du joueur
	public void setX(int x) {
		this.x = x;
	}
  //change la position y du joueur
	public void setY(int y) {
		this.y = y;
	}
  //retourne le nom du joueur
	public String getNom() {
		return nom;
	}
	
	public double chance (double f) {
		//on peut diminuer ou augmenter la luckCatchBall
		return this.luck;
	}

}