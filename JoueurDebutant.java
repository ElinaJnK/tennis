public class JoueurDebutant extends Joueur {

	public JoueurDebutant(int x_init, int y_init) {
		super(  x_init, y_init);
		luck = Math.random() * 20;
	}

	public Joueur clone() {
		JoueurDebutant joueur = new JoueurDebutant(  this.x, this.y);
    //le clone de ce joueur est plus ou moins meilleur que lui
    this.luck +=Math.random() * 10 - 5;
		return joueur;
	}
  //+ les skills varient de 0 & 50
  //débutant jusqu'à 20
	public double smash() {
    System.out.println(this.nom+" fait un smash");
		return Math.random() * luck+10;
	}

	public double amorti_droit() {
    System.out.println(this.nom+" fait un amorti_droit");
		return Math.random() * luck+5;
	}

	public double amorti_gauche() {
    System.out.println(this.nom+" fait un amorti_gauche");
		return Math.random() * luck+5;
	}

	public double drive() {
    System.out.println(this.nom+" fait un drive");
		return Math.random() * luck+5;
	}

	public double simple() {
    System.out.println(this.nom+" fait un mouvement simple");
		return Math.random() * luck+ 20;
	}
}