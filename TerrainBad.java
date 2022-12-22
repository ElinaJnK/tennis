public class TerrainBad {
	// Indiquent ici la longueur(ln) et la largeur(la)
	private int ln, la, filet;
	private char[][] terrain;
	private Joueur[] listJoueurs;
	private Volant volant;

	public TerrainBad(int longueur, int largeur, Joueur[] listJoueur) {
		ln = longueur;
		la = largeur;
		// ln-1 et la doivent être paires pour pouvoir diviser le terrain en 2
		// ln est impaire : on doit diviser le terrain par 2 et une colonne pour le
		if (ln % 2 == 0)
			ln++;
		if (la % 2 != 0)
			la++;
    //longeur du terrain doit être supérieure à 7
		if (ln < 7)
			ln = 7;
    //largeur du terrain doit être supérieure à 7
		if (la < 2)
			la = 2;
		terrain = new char[la][ln];
		filet = getFilet();
		volant = new Volant(filet, la / 2);
		initTerrain();
		listJoueurs = listJoueur;
		placerJoueur();
	}

	public void placerAleaJ() {
		// cette méthode met aléatoirement les joueurs sur le terrain
		do {
			listJoueurs[0].setX(((int) (Math.random() * (getLong() - getFilet()))));
			listJoueurs[0].setY(((int) (Math.random() * getLarg())));
			listJoueurs[1].setX((int) (Math.random() * (getLong() - getFilet() - 1) + getFilet() + 1));
			listJoueurs[1].setY((int) (Math.random() * (getLarg())));
		} while (listJoueurs[0].getX() == getFilet() || listJoueurs[1].getX() == getFilet());
		// les abscisses des deux joueurs ne peuvent pas égaux au filet
	}

	public void tomberAlea(int chance, int i) {
		//méthode qui place la case où le volant va tomber
		// i indice adversaire
    //plus le niveau du joueur est grand, plus chance est grande
    //plus chance est grand, plus f est petit, plus le volant tombe bien dans le terrain adversaire
    int f =10-chance%10;
    System.out.println("f ="+f);
		if (!horsTerrain())
			terrain[volant.getY()][volant.getX()] = '-';
		if (toucheFilet()&&!horsTerrain())
			terrain[volant.getY()][volant.getX()] = '|';
		if (i == 0)
			volant.randomDrop(filet + 1 + f, 0 - f, la - 1 + f, 0 - f);
		else
			volant.randomDrop(ln - 1 + f, filet - f, la - 1 + f, 0 - f);

		if (horsTerrain())
			System.out.println("Le volant sort du terrain");
		else
			terrain[volant.getY()][volant.getX()] = 'O';
		if (tomberTad(i))
			System.out.println("Le volant tombe bien dans le terrain adversaire");
		else
			System.out.println("Le volant ne tombe pas dans le terrain adversaire");

		// il faut réintitialiser le volant s'il est hors terrain
	}

	public boolean tomberTad(int i) {
    //méthode qui retourne true si le volant tombe bien dans le terrain adversaire
		// i = 0 terrain droit
		// i = 1 indique le terrain adversaire
		if (horsTerrain())
			return false;
		if (i == 0)
			return (volant.getX() < filet && volant.getX() >= 0 && volant.getY() < la && volant.getY() > 0);
		else
			return (volant.getX() < ln && volant.getX() >= filet && volant.getY() < la && volant.getY() > 0);
	}
  
	public boolean rattraperV(double j, double adv, double luckj, double luckadv) {
    //verifie si le joueur adverse a bien rattrape le volant
		return adv + luckadv >= j + luckj;
	}

	public void deplacerJV(int i, int i_adv) {
		// déplacer le joueur vers le volant si rattraperV()==true
		// i est l'indice du joueur qu'on veut déplacer
		// i est l'indice de l'adversaire
		if (horsTerrain() || !tomberTad(i_adv)) {
			System.out.println("Volant est hors de la porté du joueur" + i + " donc il ne bouge pas");
			return;
		}
		enleverJoueur();
    if(volant.getX()==filet){
      if (i==0)
        listJoueurs[i].setX(getFilet()-1);
      
      else
        listJoueurs[i].setX(getFilet()+1);
  
    }
		else
      listJoueurs[i].setX(volant.getX());
		listJoueurs[i].setY(volant.getY());
		placerJoueur();
	}
  //permet de savoir si le volant est hors terrain
	public boolean horsTerrain() {
		// return true si le volant est hors terrain
		return (volant.getX() >= ln || volant.getX() < 0 || volant.getY() >= la || volant.getY() < 0);
	}

  //permet de savoir si on touche le filet ou non avec le volant
	public boolean toucheFilet() {
		if (volant.getX() == filet) {
			System.out.println("Le volant a touche le filet");
			return true;
		}
		return false;
	}

	// initTerrain() initialise le terrain en mettant dans toutes les cases la
	// valeur null pour indiquer qu'il y a aucun Joueur dans les cases
	public void initTerrain() {
		for (int j = 0; j < la; j++)
			for (int i = 0; i < ln; i++) {
				terrain[j][i] = '-';
				if (i == getFilet())
					terrain[j][i] = '|';
				if (volant.getY() == j && volant.getX() == i)
					terrain[j][i] = 'O';
			}
	}

	// placerJoueur() parcourt la listJoueur pour placer chaque Joueur sur le
	// terrain à leur place (x,y)
	public void placerJoueur() {
		terrain[listJoueurs[0].getY()][listJoueurs[0].getX()] = 'G';
    terrain[listJoueurs[1].getY()][listJoueurs[1].getX()] = 'D';
	}

  //enleve tous les joueurs
	public void enleverJoueur() {
		for (Joueur j : listJoueurs) {
			terrain[j.getY()][j.getX()] = '-';
			if (j.getX() == getFilet())
				terrain[j.getY()][j.getX()] = '|';
		}
	}

	// Affiche un terrain de ln*la
  public void printTab() {
		System.out.print(" ");
		if (terrain.length > 9)
			System.out.print(" ");
		// i représente les abscisses
		for (int i = 0; i < terrain[0].length; i++)
			// on affiche les abscisses
			System.out.print(" " + i + " ");

		System.out.println("");
		// j représente les ordonnées
		for (int j = 0; j < terrain.length; j++) {
			for (int i = 0; i < terrain[j].length; i++) {
				if (i == 0) {
					System.out.print("" + j);
					if (terrain.length >= 10 && j < 10)
						System.out.print(" ");
				}
				if (i > 9)
					System.out.print(" ");
				// X représente un joueur et - absence de joueurs
				System.out.print(" " + terrain[j][i] + " ");

			}

			System.out.println("");
		}
		System.out.println("Position du volant :"+volant.getX() + "," + volant.getY());
	}

	// Recupere la longeur du terrain
	public int getLong() {
		return terrain[0].length;
	}

	// Recupere la largeur du terrain
	public int getLarg() {
		return terrain.length;
	}

	// Recupérer la position du filet
	public int getFilet() {
		return terrain[0].length / 2;
	}
}
