import java.util.Arrays;
import java.util.Scanner;
//! 注意Array.sort方法的使用！

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double[] unitValue = new double[values.length];
        for(int i=0;i<unitValue.length;i++){
            unitValue[i]=(double)values[i]/weights[i];
        }

        
        Integer[] indexs = new Integer[values.length];
        for(int i=0;i<indexs.length;i++){
            indexs[i]=i;
        }
        //用索引记录位置，用unitValue直接排序，这样无需改变unitValue数组的位置，而只需要在一个索引数组里变化，从而可以无缝引用到values,weight等多个数组
        //这里用了箭头函数来执行比较操作，并使用了.sort()方法
        Arrays.sort(indexs,(a,b) -> {
            double result = unitValue[indexs[a]]-unitValue[indexs[a]];
            if(result>0){
                return 1;
            }else{
                return 0;
            }
        });

        //! 注意！这里要考虑可能capacity< weight[i]的情况！所以需要用Math.min比较，计算价值时也需要考虑到可以装入的重量
        for(int i=0;i<indexs.length && capacity>0;i++){
            int bestWeight = Math.min(weights[indexs[i]],capacity);
            capacity-=bestWeight;
            value+=unitValue[indexs[i]]*bestWeight;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
