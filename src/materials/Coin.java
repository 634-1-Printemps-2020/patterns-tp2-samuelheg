package materials;

public class Coin {

  private CoinState coinState;
  private static Coin uniqueCoin = null;

  public Coin() {

  }

  public static Coin getCoin(){
    if(uniqueCoin == null){
      uniqueCoin = new Coin();
    }
    return uniqueCoin;
  }

  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  public void throwCoin() {
    // TODO : Votre code ici
    this.coinState = CoinState.randomState();
  }

  public CoinState getState() {
    return coinState;
  }


}
