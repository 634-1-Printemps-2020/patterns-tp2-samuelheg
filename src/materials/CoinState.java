package materials;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum CoinState {

  HEADS, TAILS;

  private static final List<CoinState> VALUES =
          Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();

  public static CoinState randomState()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }


}
