public class Test {
  public static void main(String[] args) {
    for (int n = 2; n <= 10000; n++) {
      BigInteger mersenneNumber =
          BigInteger.TWO.pow(n).subtract(BigInteger.ONE);
      if (isPrime(mersenneNumber)) {
        System.out.println(mersenneNumber);
      }
    }
  }

  public static boolean isPrime(BigInteger number) {
    if (number.compareTo(BigInteger.TWO) < 0) {
      return false;
    }
    if (number.compareTo(BigInteger.TWO) == 0
        || number.compareTo(BigInteger.valueOf(3)) == 0) {
      return true;
    }
    if (number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
      return false;
    }
    BigInteger sqrt = number.sqrt();
    for (BigInteger i = BigInteger.valueOf(3); i.compareTo(sqrt) <= 0; i =
        i.add(BigInteger.TWO)) {
      if (number.mod(i).equals(BigInteger.ZERO)) {
        return false;
      }
    }
    return true;
  }
}
