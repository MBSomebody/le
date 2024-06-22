package leteecode.algo;

public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }

        if (n % 2 == 1) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        return isPowerOfTwo(n >> 1);

    }

    public static void main(String[] args) {
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(6));
    }
}
