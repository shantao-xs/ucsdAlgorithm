import java.util.*;
//! 不知道怎么迭代，重点在于连续除取余，直到无法取余，则最后一个除数就是最大公因数
public class GCD {
  private static int gcd_naive(int a, int b) {
    while(b!=0){
      int temp=b;
      b=a%b;
      a=temp;
    }
    return a;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
