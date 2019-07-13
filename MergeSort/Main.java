package ReadAgain.tenSort.MergeSort;
/**
 *      归并排序
 *  最好，最坏，平均时间复杂度： O（ n * log 2 n）
 *  空间复杂度：O（ n ）
 *  稳定
 *  ----------------------------------------
 *  将数组一分为二，递归合并
 *
 */
public class Main {

    public void merge(int [] arr, int start, int mid, int end)
    {
        int [] temp = new int [end - start + 1];
        int i = start;
        int j = mid + 1;   // 注意这里是 mid + 1
        int index = 0;

        while(i <= mid && j <= end)
        {
            if(arr[i] <= arr[j])
                temp[index++] = arr[i++];
            else
                temp[index++] = arr[j++];
        }

        while(i <= mid)
            temp[index++] = arr[i++];

        while(j <= end)
            temp[index++] = arr[j++];

        for(int key = 0; key < temp.length; key++)
        {
            arr[start + key] = temp[key];    // 注意这里是从 start 开始，而不是 0
        }
    }

    public void merge_sort_up2down(int [] arr, int start, int end)
    {
        if(start >= end)   // 注意这里递归终止的条件 start >= end
            return;

        int mid = start + ((end - start) >> 1);
        merge_sort_up2down(arr,start,mid);
        merge_sort_up2down(arr,mid+ 1,end);   // 注意这里 mid + 1 才能把数组分成两个部分
        merge(arr,start,mid,end);
    }

    public static void main(String[] args){
        Main demo = new Main();
        int [] arr = {4,34,65,25,85,22,62,5,54,3};
        demo.merge_sort_up2down(arr,0,arr.length - 1);   // 这里注意数组的长度，否则会发生下标越界
        for(int item: arr)
        {
            System.out.print(item + " ");
        }
    }
}
