package ReadAgain.tenSort.BucketSort;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 *      桶排序
 * 最好时间复杂度：O( n )
 * 最坏时间复杂度：O( n ^ 2)
 * 平均时间复杂度： O(n + k)
 * 空间复杂度： O（n + k）
 * 稳定
 *
 */
public class Main {
    public void BucketSort(int [] arr)
    {
        if(arr.length == 0 || arr == null){
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
            if(max < arr[i]){
                max = arr[i];
            }
        }

        int bucketCount = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i < bucketCount; i++){
            buckets.add(new ArrayList<>());
        }

        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / bucketCount;   // 这里为每一个数划分空间范围，用的是除法
            buckets.get(num).add(arr[i]);//  这里底层用的是归并排序，Arrays.sort 用的是快速排序
        }

        int index = 0;
        for(int i = 0; i < buckets.size(); i++){
            ArrayList<Integer> ll = buckets.get(i);
            Collections.sort(ll);
            System.out.println("第" + i + "桶");
            for(int j = 0; j < ll.size(); j++){
                System.out.print(ll.get(j) + " ");
                arr[index++] = ll.get(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Main demo = new Main();
        int [] arr = {23,90,76,3,2,1,5,67,};
        demo.BucketSort(arr);
        for(int item: arr)
        {
            System.out.print(item + " ");
        }
    }
}
