package ReadAgain.tenSort.QuickSort;

/**
 *      快速排序
 *  最好时间复杂度：O(n log 2 n)
 *  最坏时间复杂度: O( n ^ 2)
 *  平均时间复杂度：O（n log 2 n）
 *  空间复杂度：O（n log 2 n）
 *  不稳定
 */
public class Main {

    public void QuickSort(int [] arr, int start, int end)
    {
        if(start >= end)   // 递归终止条件
            return;

        int i = start;
        int j = end;
        int pivot = arr[start];

        while(i < j)
        {
            while(i < j && arr[j] > pivot)   // 首先从数组的后边向前查找
                j--;
            while(i < j && arr[i] <= pivot)   // 记住相等的情况不要丢，否则会发生错误
                i++;

            if(i < j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[start] = arr[i];   // 交换基准值，并进行递归运算
        arr[i] = pivot;

        QuickSort(arr, start,i - 1);
        QuickSort(arr, i + 1, end);

    }

    public static void main(String [] args){
        Main demo = new Main();
        int [] arr = {5,8,2,3,4,9};
        demo.QuickSort(arr,0,arr.length - 1);
        for(int item: arr)
        {
            System.out.print(item + " ");
        }
    }
}
