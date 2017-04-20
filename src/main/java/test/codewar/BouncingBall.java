package test.codewar;

public class BouncingBall {

    public static int bouncingBall(double h, double bounce, double window) {
        if(bounce <=0 || 1<=bounce || window>=h)
            return -1;

        int result = 1;
        for(double height = h*bounce; height>=window; height*=bounce){
            result+=2;
        }

        return result;
    }
}
