package dailyprogrammer21;

public class TheAddingCalculator{
    public static int add(int a, int b){
        return a + b;
    }
    public static int sub(int a, int b){
        int inverse_b = Integer.MIN_VALUE;
        while(inverse_b + b != 0) {
            inverse_b++;
        }
        return a + inverse_b;
    }
    public static int multi(int a, int b){
        int result = 0;
        for(int i=0; i < b; i++){
            result += a;
        }
        return result;
    }
    public static int div(int a, int b){
        int result = 0;
        while( a != 0 ){
            a = sub(a,b);
            result++;
        }
        return result;
    }
    public static int pow(int a, int b){
        int result = 1;
        while(b > 0){
            result = multi(result, a);
            b = sub(b,1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sub(-2,3));
        System.out.println(add(-2,3));
        System.out.println(div(6,3));
        System.out.println(pow(2,3));
    }
}
