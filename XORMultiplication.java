    /*
     * [2017-05-15] Challenge #315 [Easy] XOR Multiplication
     * 
     * */
    public class XORMultiplication {
        public static int XORM(int a, int b){
            int check = 1,result = 0;
            for(int i=0;i<31;i++){
                result = (b & (check<<i)) != 0 ? result ^ (a<<i) : result;
            }
            return result;
        }
        public static void main(String args[]){
            int a = 13, b = 11;
            System.out.println(a + "@"+b+"="+XORM(a,b));
        }
    }
