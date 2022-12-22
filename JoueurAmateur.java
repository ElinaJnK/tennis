public class JoueurAmateur extends JoueurInter{
  public JoueurAmateur(  int x_init, int y_init) {
    super(x_init,y_init);
    luck = Math.random()*30+20;
  }

  public Joueur clone() {
		JoueurAmateur joueur = new JoueurAmateur(this.x, this.y);
    this.luck +=Math.random() * 10 - 5;
		return joueur;
	}
  //differents skills que possede le joueur
  public double smash() {
			return super.smash()+5;
	}

	public double amorti_droit() {
			return super.amorti_droit()+5;
	}

  public double amorti_gauche() {
			return super.amorti_gauche()+5;
	}
}