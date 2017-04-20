package test.codewar;

import java.util.Arrays;

/**
 * Created by leo on 2017/2/8.
 */
public class kata {
    public static String HighAndLow(String numbers) {
        String[] splited = numbers.split(" ");
        int[] intarray =  Arrays.stream(splited).mapToInt(Integer::parseInt).sorted().toArray();
        if(intarray.length == 1)
            return String.valueOf(intarray[0]) + " " + String.valueOf(intarray[0]);
        else
            return String.valueOf(intarray[intarray.length-1]) + " " + String.valueOf(intarray[0]);
    }
}
