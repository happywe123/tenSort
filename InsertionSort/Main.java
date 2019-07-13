package ReadAgain.tenSort.InsertionSort;

/**
 *      插入排序
 *  最好时间复杂度：O（ n ）
 *  最坏时间复杂度：O（ n ^ 2）
 *  平均时间复杂度：O(n^2)
 *  空间复杂度： O(1)
 *  稳定
 *  ------------------------------------
 *  从未排序的数组中，依次插入到已排序的数组中去
 */

public class Main {
    public void InsertionSort(int [] arr)
    {
        if(arr.length == 0 || arr == null)
            return;

        int length = arr.length;
        for(int i = 1; i < length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current)   // 这里注意逻辑与的顺序，先比较大小
            {                                    // 否则会发生数组越界的错误
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args)
    {
        Main demo = new Main();
        int [] arr = {65,23,45,10};
        demo.InsertionSort(arr);
        for(int item : arr)
        {
            System.out.print(item + " ");
        }
    }
}
