/**
 * FractionRow
 * Last Modified: April 2, 2024
 * 
 * An object representing a group of fractions. These fractions will be displayed and move down
 * the game screen together as a group, where the player can click on the one they believe is
 * largest to score points.
 */

public class FractionRow {
  private FractionStorage[] fractions;
  private RandomFractionGenerator random;
  private double maxValue;
  private double minValue;

  {
    maxValue = 0;
    minValue = 0;
  }

  /** 
   * Constructor for FractionRow
   * numOptions guarantee has not been determined yet
   * guarantees 2 <= demonSize <= 15
   */
  public FractionRow(int numOptions, int denomSize) {
    if (denomSize < 2 || denomSize > 15) {
      throw new IllegalArgumentException("Denominator must be between 2 and 15 digits");
    }
    fractions = new FractionStorage[numOptions];
    random = new RandomFractionGenerator(denomSize);
    generateFractions(denomSize);
  }

  /** Generates fractions into the fractions array using a RandomFractionGenerator */
  private void generateFractions(int denomSize) {
    for (int i = 0; i < fractions.length; i++) {
      long[] fraction = random.generateFraction();
      FractionStorage store = new FractionStorage(fraction[0], fraction[1]);
      fractions[i] = store;

      // store the maximum and minimum values in the array for scoring later
      maxValue = (store.getDecimalValue() > maxValue) ? store.getDecimalValue() : maxValue;
      if (minValue == 0) minValue = store.getDecimalValue();
      else minValue = (store.getDecimalValue() < minValue) ? store.getDecimalValue() : minValue;
    }
  }

  /** Prints data on each fraction */
  public void printFractionsData() {
    for (int i = 0; i < fractions.length; i++) {
      System.out.println(fractions[i].getNumerator() + " / " + fractions[i].getDenominator() + " = " + fractions[i].getDecimalValue());
    }
    System.out.println("Max value = " + maxValue);
    System.out.println("Min value = " + minValue);
  }

  /** Inner class that stores data for a Fraction */
  private class FractionStorage {
    private long numerator;
    private long denominator;
    private double decimalValue;

    /** Constructor for FractionStorage */
    public FractionStorage(long num, long denom) {
      numerator = num;
      denominator = denom;
      decimalValue = (double) num / denom;
    }

    /** Returns the numerator of the fraction */
    public long getNumerator() {
      return numerator;
    }

    /** Returns the denominator of the fraction */
    public long getDenominator() {
      return denominator;
    }

    /** Returns the decimal value of the fraction */
    public double getDecimalValue() {
      return decimalValue;
    }
  }
}