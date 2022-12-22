public class Simulation {
	// listJoueurs[0] est joueur à gauche du terrain
	// listJoueurs[1] est joueur à droitedu terrain
	private Joueur[] listJoueurs;
	private TerrainBad ter;
  //scoreG est le score du joueur à gauche du terrain
  //scoreD est le score du joueur à droite du terrain
	private int scoreG = 0;
	private int scoreD = 0;

  public Simulation(int longeur, int largeur,Joueur [] listJ) {
    try{
      if (listJ.length > 2){
        throw new MauvaisNombreDeJ("Trop de Joueurs pour un match de 2 personnes.");
      }
      else if (listJ.length < 2){
        throw new MauvaisNombreDeJ("Pas assez de Joueurs pour un match de 2 personnes.");
      }
    }catch (MauvaisNombreDeJ e){
      System.out.println("Mauvais nombre de joueurs");
      System.exit(-1);
    }
    listJoueurs = listJ;
		ter = new TerrainBad(largeur,longeur, listJoueurs);
    Volant volant = new Volant(0,0);
	}

	public Simulation() {
    //on aura 2 joueurs amateurs et un terrain qui a au moins 2 cases de largeur et 7 cases de longeur
    this(-1);
	}
  	public Simulation(int niveau) {
      //on aura 2 joueurs de niveau au choix et un terrain qui a au moins 2 cases de largeur et 7 cases de longeur
    choisirJ(niveau);
		ter = new TerrainBad((int) (Math.random() * 20 + 2), (int) (Math.random() * 10 + 7), listJoueurs);
		ter.placerAleaJ();
		ter.initTerrain();
		ter.placerJoueur();
	}

  public void choisirJ(int niveau){
    //méthode qui choisit le niveau des joueurs dans le match au choix 
    switch (niveau){
        case 0:
        //JoueurDebutant
          listJoueurs = new Joueur[2];
		      listJoueurs[0] = new JoueurDebutant(0, 0);
		      listJoueurs[1] =listJoueurs[0].clone();
          break;
        case 1:
        //JoueurInter
          listJoueurs = new Joueur[2];
		      listJoueurs[0] = new JoueurInter( 0, 0);
		      listJoueurs[1] =listJoueurs[0].clone();
          break;
        case 2:
        //JoueurPro
          listJoueurs = new Joueur[2];
		      listJoueurs[0] = new JoueurPro( 0, 0);
		      listJoueurs[1] =listJoueurs[0].clone();
          break;
        case 3:
        //JoueurSuper
          listJoueurs = new Joueur[2];
		      listJoueurs[0] = new JoueurSuper(  0, 0);
		      listJoueurs[1] =listJoueurs[0].clone();
          break;
        default:
        //JoueurAmateur
          listJoueurs = new Joueur[2];
		      listJoueurs[0] = new JoueurAmateur(  0, 0);
		      listJoueurs[1] =listJoueurs[0].clone();
          break;
      }
  }

	public boolean fin(int max_score) {
    //méthode retourne vrai si un joueur a plus de point que l'autre

    //si les scores dépassent le score max indiqué dans l'argument 
		if (max_score <= scoreG && max_score <= scoreD) {
			if (scoreD == scoreG)
				return false;
			else {
				if (scoreD < scoreG) {
					System.out.println("Joueur gauche a gagné la partie");
          LogMatch.getInstance().ajouterLog(listJoueurs[0].getNom()+" a gagné la partie");
					return true;
				} else {
					System.out.println("Joueur droite a gagné la partie");
          LogMatch.getInstance().ajouterLog(listJoueurs[1].getNom()+" a gagné la partie");
					return true;
				}
			}
		} 
    //sinon le premier qui atteint le score max va gagner
    else {
			if (scoreG == max_score) {
				System.out.println("Joueur gauche a gagné la partie");
        LogMatch.getInstance().ajouterLog(listJoueurs[0].getNom()+" a gagné la partie");
				return true;
			} else {
				if (scoreD == max_score) {
					System.out.println("Joueur droite a gagné la partie");
          LogMatch.getInstance().ajouterLog(listJoueurs[1].getNom()+" a gagné la partie");
					return true;
				} else
					return false;
			}
		}

	}

	public void addScore(int i) {
    //méthode qui ajoute les points au joueur indice i
		//i indique le joueur courant
		if (i == 0)
			scoreG++;
		else
			scoreD++;
	}

	public int inv_i(int i) {
    //méthode qui retourne 1 ou 0 en fonction de i
		if (i == 0)
			return 1;
		else
			return 0;
	}
	
	
	public int useSkill(int i) {
    //méthode qui retourne un entier aléatoire en utilisant les méthodes de Skills du joueur i et son luck
		int force =0;
		if (i!=0)
			i=1;
		int randSkill = (int)(Math.random()*4);
    System.out.println("randskill: "+(randSkill));
		switch (randSkill){
        case 0:
          force += listJoueurs[i].smash();
          LogMatch.getInstance().ajouterLog(listJoueurs[i].getNom()+" a fait un smash");
          break;
        case 1:
          force += listJoueurs[i].amorti_droit();
          LogMatch.getInstance().ajouterLog(listJoueurs[i].getNom()+" a fait un amorti droit");
          break;
        case 2:
          force += listJoueurs[i].amorti_gauche();
          LogMatch.getInstance().ajouterLog(listJoueurs[i].getNom()+" a fait un amorti gauche");
          break;
        case 3:
          force += listJoueurs[i].drive();
          LogMatch.getInstance().ajouterLog(listJoueurs[i].getNom()+" a fait un drive");
          break;
        default:
          force += listJoueurs[i].simple();
          break;
      }
		return (int)force;
	}

	// System.out.println();
	public void jeu() {
		//i est indice du joueur
    // i = 0 , terrain/joueur gauche
    // i = 1 , terrain/joueur droit
    int i = 0;
		int nbr =0;

		while (!fin(21)) {
      //permet de rajouter les actions dans le log
      LogMatch.getInstance().ajouterLog("Score G: "+Integer.toString(scoreG)+" Score D: "+Integer.toString(scoreD));
      //permet de faire une pause entre chaque affichage
      try{
				  Thread.sleep(1000);
		  }catch(InterruptedException ex){
				  Thread.currentThread().interrupt();
			}
			nbr++;
      System.out.println();
			System.out.println("boucle n° = " +nbr);
			System.out.println("joueur i (courant) = " +i);
			System.out.println("Score G = "+scoreG+", Score D ="+scoreD);
			//joueur i lance le volant
			ter.enleverJoueur();
			ter.placerAleaJ();
			ter.placerJoueur();
			int skill=useSkill(i);
			ter.tomberAlea(skill, inv_i(i));
			//on vérifie si le volant est correct
			if(!ter.tomberTad(inv_i(i))) {
				System.out.println("Joueur "+i+" a raté sa frappe");
				this.addScore(inv_i(i));
				i=inv_i(i);
				ter.printTab();
				continue;
			}
			//si le volant est correct, vérifions si l'adversaire peut frapper en retour
			///////
			int skillAd=useSkill(inv_i(i));
			int chancei = (int)listJoueurs[i].chance(0);
			int chancea=(int)listJoueurs[inv_i(i)].chance(0);
			//System.out.println("skill "+skill +" skill ad ="+skillAd+" chance i = "+chancei+" chance adv = "+ chancea);
			///////
			if (!ter.rattraperV(skill, skillAd, chancei, chancea)) {
				System.out.println("Joueur "+inv_i(i)+" a raté son retour");
				this.addScore(i);
				//i est toujours égal à i car inv_i(i) a raté le volant
				ter.printTab();
				continue;
			}
			//si l'adversaire peut frapper le volane en retour, on passe le volant à l'adversaire
			System.out.println("Les joueurs ont réussi de frappé le volant");
      //afficher le terrain avant que l'adversaire puisse frapper le volant en retour
			ter.printTab();
      //déplacer l'adversaire
			ter.deplacerJV(inv_i(i), inv_i(i));
       //afficher le terrain après que l'adversaire puisse frapper le volant en retour
			ter.printTab();
			i=inv_i(i);
				
		}
	}

}