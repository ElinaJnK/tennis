

public class JoueurSuper extends JoueurPro {
	public JoueurSuper( int x_init, int y_init) {
		super(  x_init, y_init);
		luck = Math.random() * 20 + 70;
	}

  public Joueur clone() {
		JoueurSuper joueur = new JoueurSuper( this.x, this.y);
    this.luck +=Math.random() * 10 - 5;
		return joueur;
	}
   //differentes techniques que peut utiliser le joueur
	public double drive() {
		return super.drive()+20;
	}

	public double simple() {
		return super.simple()+20;
	}
}