package dailyprogrammer14;

public class SqrtTheHardWay {
    public static void main(String[] args){
        String[][] test = {{"0"," 12345"},{"8","123456"},{"1", "12345678901234567890123456789" }};
        for(String[] current: test){
            int p = Integer.parseInt(current[0]);
            double n = Double.parseDouble(current[1]);
            System.out.printf("%."+p+"f \n", sqrt(n)); 
        }
    }
    public static double sqrt(double n){
        double m = n;
        for(int i=0; i < 100; i++){
            // Newton-Raphson method, 100 iterations should do it :)
            n = n-(((n*n)-m)/(2*n));
        }
        return n;
    }
}
