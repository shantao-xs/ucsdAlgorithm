import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    int initialA=a;
    int initialB=b;
    while(b!=0){
      int temp=b;
      b=a%b;
      a=temp;
    }
    return (long)initialA*initialB/a;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
