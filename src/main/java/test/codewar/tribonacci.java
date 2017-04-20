package test.codewar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class tribonacci {
    public double[] tribonacci(double[] s, int n) {
        if(n == 0 )
            return new double[0];
        else if(s.length >= n)
            return Arrays.copyOfRange(s, 0, n);
        else {
            List<Double> arraylist = DoubleStream.of(s).mapToObj(Double::valueOf).collect(Collectors.toCollection(ArrayList::new));
            List<Double> arraylist2 = Arrays.stream(s).mapToObj(Double::valueOf).collect(Collectors.toList());
            for(int number = s.length; number < n; number++){
                arraylist2.add(number, arraylist.get(number-3) + arraylist.get(number-2) + arraylist.get(number-1));
                System.out.println("arraylist.get(number) is :"+arraylist.get(number));
            }
            return arraylist.stream().mapToDouble(Double::doubleValue).toArray();
        }
    }
}
