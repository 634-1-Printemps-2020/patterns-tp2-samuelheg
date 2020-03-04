package game;

import materials.Coin;
import materials.CoinState;

import java.util.List;

public class Rules {

  private static Rules uniqueRules = null;

  private Rules() {
  }

  public static Rules getRules(){
    if(uniqueRules == null){
      uniqueRules = new Rules();
    }
    return uniqueRules;
  }
  /**
   * Cette méthode permet de déterminer si une suite d'états de pièce permet de gagner à une partie
   * @param states liste d'états pour un joueur
   * @return true si un joueur a gagné, false sinon
   */
  public boolean checkWin(List<CoinState> states) {
    // TODO: Votre code ici
    int cpt = 0;
    for (int i = 1; i < states.size() ; i++) {
      if (cpt == 3){
        return true;
      }
      if(states.get(i).equals(states.get(i-1))){
        cpt ++;
      }else{
        System.out.println(states.get(i) + " - " + states.get(i-1));
        cpt = 0;
      }
    }
    return false;
  }
}
