package ReadAgain.tenSort.CountingSort;

/**
 *      计数排序
 *  最好，最坏，平均时间复杂度：O(n + k)
 *  空间复杂度：O（ n + k）
 *  稳定
 *
 */

public class  Main {

    public void CountingSort(int [] arr)
    {
        if(arr == null || arr.length == 0){
            return;
        }

        // 这里找到原始数组的最大值
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }

        int [] temp = new int[max + 1];

        for(int i = 0; i < arr.length; i++){
            temp[arr[i]]++;
        }

        int index = 0;
        for(int i = 0; i < temp.length; i++){
            while(temp[i] != 0){
                arr[index++] = i;
                temp[i]--;
            }
        }
    }

    public static void main(String [] args){
        Main demo = new Main();
        int [] arr = {5,4,6,33,6,3,6,3,6,76,43,7,4,7,96};
        demo.CountingSort(arr);
        for(int item:arr)
        {
            System.out.print(item + " ");
        }
    }
}
