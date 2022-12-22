public class JoueurPro extends JoueurInter {
	public JoueurPro(int x_init, int y_init) {
		super(x_init, y_init);
		luck = Math.random() *20+50;
	}
  	public Joueur clone() {
		JoueurPro joueur = new JoueurPro(  this.x, this.y);
    this.luck +=Math.random() * 10 - 5;
		return joueur;
	}
  //differentes techniques que peut utiliser le joueur
  public double smash() {
		return super.smash()+10;
	}

  public double amorti_droit() {
		return super.amorti_droit()+10;
	}
	
  public double amorti_gauche() {
		return super.amorti_gauche()+10;
	}
}	