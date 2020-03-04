package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules;
    private Coin coin;
    private Map<Player, List<CoinState>> history;

    public Game() {
        this.history = new HashMap<>();
        this.rules = Rules.getRules();
        this.coin = Coin.getCoin();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
      // TODO: Votre code ici
        if(!this.history.containsKey(player)){
            this.history.put(player, new ArrayList<CoinState>());
        }

    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
      // TODO: Votre code ici
        for (Player player: this.history.keySet()) {
            while(!this.rules.checkWin(this.history.get(player))){
                player.play(this.coin);
                this.history.get(player).add(this.coin.getState());
            }
        }
    }

    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {
      // TODO: Votre code ici
      return new Statistics(getAverageToWin(),getFewerMovesToWin(),getMostMovesToWin(),getTotalNumberMoves());
    }

    private int getAverageToWin(){
        return getTotalNumberMoves()/this.history.keySet().size();
    }

    private int getFewerMovesToWin(){
        int moves = 0;
        for (Player player: this.history.keySet()) {
            if(moves == 0){
                moves = this.history.get(player).size();
            }
            if(this.history.get(player).size() < moves){
                moves = this.history.get(player).size();
            }
        }
        return moves;
    }

    private int getMostMovesToWin(){
        int moves = 0;
        for (Player player: this.history.keySet()) {
            if(this.history.get(player).size() > moves){
                moves = this.history.get(player).size();
            }
        }
        return moves;
    }

    private int getTotalNumberMoves(){
        int total= 0;
        for (Player player: this.history.keySet()) {
            total += this.history.get(player).size();
        }
        return total;
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
      // TODO: Votre code ici
      return this.history;
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
      // TODO: Votre code ici
      return this.history.get(player);
    }

}
