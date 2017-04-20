package test.codewar;

import java.util.Arrays;

/**
 * Created by leo on 2017/2/10.
 */
public class Abbreviator {
    public String abbreviate(String string) {

        StringBuilder s = new StringBuilder(string);
        return s.reverse().toString();

    }
}
