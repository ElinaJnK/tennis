public class JoueurInter extends JoueurDebutant{
	  public JoueurInter(int x_init, int y_init){
	    super(x_init,y_init);
	    luck = Math.random()*20+20;
	  }
  //permet de faire le clone
	public Joueur clone() {
		JoueurInter joueur = new JoueurInter(  this.x, this.y);
    this.luck +=Math.random() * 10 - 5;
		return joueur;
	}
  //differentes techniques que peut utiliser le joueur
	public double smash() {
		return super.smash()+10;
	}

	public double amorti_droit() {
		return super.amorti_droit()+5;
	}

	public double amorti_gauche() {
		return super.amorti_gauche()+5;
	}
}