package test.codewar;

/**
 * Created by leo on 2017/2/10.
 */
public class DigPow {
    public static long digPow(int n, int p) {
        String intString = String.valueOf(n);
        long sum = 0;
        for (int i = 0; i < intString.length(); ++i, ++p)
            sum += Math.pow(Character.getNumericValue(intString.charAt(i)), p);
        return (sum % n == 0) ? sum / n : -1;
    }
}
