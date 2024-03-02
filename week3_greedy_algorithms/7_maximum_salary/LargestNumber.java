import java.util.*;

public class LargestNumber {
    //* todo：遵循先理解、后思考、最后执行：①认真读题，推演示例 ②先算时间复杂度 ③写伪代码 ④实际代码 ⑤在main里写测试案例
    //! 误区1：不认真读题，链接a中str1和str2多个字符串，而不是把所有字符串打散成个位数字再重组
    //! 误区2：先做后想浪费时间，没有提前算大O
    
    //* 思路：对每个小单位，比较str1和str2大小并返回排序1/-1(耗时：O(1))，然后将该方法应用到整体大单位进行排序（二分法，耗时：O(log n)）
    //! 易错1：不能单纯比较str1和str2的大小，而应该比较str1str2 vs str2str1
    //! 易错2：sort的顺序和降序，默认a>b的情况下,return a-b>0， return b-a<0，故整数是顺序，复数是降序
    //! 易错3：为什么不能在连接str1和str2后比较整数值大小？因为连接后可能会超出Integer.MAX_VALUE导致计算错误，而用compareTo直接比较str就不会有这个问题
    //! 易错4：如果string[]a为空？
    
    
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        if(a.length==0 || a==null){
            return "";
        }

        //O(log n)
        Arrays.sort(a,(str1,str2)->{
            //O(1)
            return (str2+str1).compareTo(str1+str2);
        });

        //O(n)
        for(int i=0;i<a.length;i++){
            result+=a[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

