import java.lang.Exception;
//permet de verifier si on a bien le bon nombre de joueurs
public class MauvaisNombreDeJ extends Exception{
  public MauvaisNombreDeJ(String message){
    super(message);
    
  }
}