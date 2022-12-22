//classe qui permet de faire un journal du match
public class LogMatch{
  private static LogMatch uniquelog;
  private String log;
  //constructeur privé pour une classe Singleton
  private LogMatch(){
    log = new String();
  }
  //verifie si une instance de log existe et la crée si non
  public static synchronized LogMatch getInstance(){
    if (uniquelog == null)
      uniquelog = new LogMatch();
    return uniquelog;
  }
  //permet de rajouter un log
  public void ajouterLog(String l){
    log += "*"+l+"*\n";
  }
  //retourne le log cree
  public String afficherLog(){
    return log;
  }
  //permet d'efface le log
  public synchronized void effacerInstance(){
    uniquelog = null;
  }
}