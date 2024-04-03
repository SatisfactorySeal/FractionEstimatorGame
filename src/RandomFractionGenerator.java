import java.util.Random;

public class RandomFractionGenerator {
  private final double MIN_DOUBLE = 0.10;
  private final double MAX_DOUBLE = 0.80;
  private final double MAX_FRACTION_SPAN = 0.10;

  private Random random;
  private int denomSize;
  private double goalValue;

  {
    random = new Random();
  }

  public RandomFractionGenerator(int size) {
    denomSize = size;
    goalValue = MIN_DOUBLE + (MAX_DOUBLE - MIN_DOUBLE) * random.nextDouble();
  }

  public long[] generateFraction() {
    long[] fraction = new long[2];
    fraction[1] = getRandomLong();
    double actualValue = goalValue + MAX_FRACTION_SPAN * random.nextDouble();
    fraction[0] = (long) (fraction[1] * actualValue);
    return fraction;
  }

  private long getRandomLong() {
    int size = (denomSize <= 9) ? denomSize : 9;
    int firstPart = random.ints((int) Math.pow(10, size-1), (int) Math.pow(10, size))
      .findFirst()
      .getAsInt();
    if (denomSize <= 9) return (long) firstPart;
    long bound = (long) Math.pow(10, denomSize-9);
    return bound * (long) firstPart + (long) random.nextInt((int) bound);
  }
  
}
