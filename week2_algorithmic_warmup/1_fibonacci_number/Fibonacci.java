import java.util.Scanner;
//![out of boundary] 注意：对于n=0的情况，就不能命名fibArr[1]=1;，会越界！
public class Fibonacci {
  private static long calc_fib(int n) {
    
    if(n<=1){
      return n;
    }
    
    int[] fibArr = new int[n+1];
    fibArr[0]=0;
    fibArr[1]=1;
    for(int i=2;i<=n;i++){
      fibArr[i]=fibArr[i-1]+fibArr[i-2];
    }
    return fibArr[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
