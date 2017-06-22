package dailyprogrammer9;
// [2017-06-19] Challenge #320 [Easy] Spiral Ascension
public class NumberSpiral {
    public static void main(String args[]){
        if(args[0] == null)
            System.exit(0);
        int input = Integer.parseInt(args[0]);
        int[][] output = new int[input][input];
        int iX=0,iY=0,num=1,start=0,end=input*input;
        while(num <= end && input != 1){
            int max  = ((input-1)-start);
            int min  = start;
            
            output[iY][iX] = num++;
            if(iY == min && iX < max){
                iX++;
            }else if(iX == max && iY < max){
                iY++;
            }else if(iY == max && iX > min){
                iX--;
            }else if(iX == min && iY > min){
                iY--;
            }
            if(iX == start && iY == start){
                start++;
                iX = iY = start;
            }
        }
        System.out.println();
        if(input != 1){
            for(int[] a: output){
                for(int b: a){
                    System.out.print(b + "\t");
                }
                System.out.println("\n");
            }
        }
        else{
            System.out.print("1");
        }
    }
}
