public class FractionRow {
  private FractionStorage[] fractions;
  private RandomFractionGenerator random;
  private double maxValue;
  private double minValue;

  {
    maxValue = 0;
    minValue = 0;
  }

  public FractionRow(int numOptions, int denomSize) {
    if (denomSize < 2 || denomSize > 15) {
      throw new IllegalArgumentException("Denominator must be between 2 and 15 digits");
    }
    fractions = new FractionStorage[numOptions];
    random = new RandomFractionGenerator(denomSize);
    generateFractions(denomSize);
  }

  private void generateFractions(int denomSize) {
    for (int i = 0; i < fractions.length; i++) {
      long[] fraction = random.generateFraction();
      FractionStorage store = new FractionStorage(fraction[0], fraction[1]);
      fractions[i] = store;
      maxValue = (store.getDecimalValue() > maxValue) ? store.getDecimalValue() : maxValue;
      if (minValue == 0) minValue = store.getDecimalValue();
      else minValue = (store.getDecimalValue() < minValue) ? store.getDecimalValue() : minValue;
    }
  }

  public void printFractionsData() {
    for (int i = 0; i < fractions.length; i++) {
      System.out.println(fractions[i].getNumerator() + " / " + fractions[i].getDenominator() + " = " + fractions[i].getDecimalValue());
    }
    System.out.println("Max value = " + maxValue);
    System.out.println("Min value = " + minValue);
  }

  private class FractionStorage {
    private long numerator;
    private long denominator;
    private double decimalValue;

    public FractionStorage(long num, long denom) {
      numerator = num;
      denominator = denom;
      decimalValue = (double) num / denom;
    }

    public long getNumerator() {
      return numerator;
    }

    public long getDenominator() {
      return denominator;
    }

    public double getDecimalValue() {
      return decimalValue;
    }
  }

}
