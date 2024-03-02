import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if(n<=1){
            return n;
          }
          
        int[] fibArr = new int[n+1];
        fibArr[0]=0;
        fibArr[1]=1;
        for(int i=2;i<=n;i++){
        fibArr[i]=(fibArr[i-1]+fibArr[i-2])%10;
        }
        return fibArr[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

