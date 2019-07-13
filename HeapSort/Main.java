package ReadAgain.tenSort.HeapSort;

/**
 *      堆排序
 *  最好，最坏，平均时间复杂度：O（n log 2 n）
 *  空间复杂度：O(1)
 *  不稳定
 */

public class Main {
    public void Sort(int [] arr)
    {
        if(arr.length == 0)
            return;

        for(int i = arr.length / 2 - 1; i >= 0; i--)  // 从第一个非叶子节点开始
        {                                            // 建堆
            adjustHeap(arr, i, arr.length);
        }

        for(int i = arr.length - 1; i >= 0; i--)
        {                           // 这里进行排序，注意从数组的尾部进行，比较方便，快捷
            swap(arr, 0, i );    // 当然这里符合排序的习惯，从一端开始，另一端是已排好序的
            adjustHeap(arr, 0, i);
        }
    }

    // 这里注意，参数里有一个 length, 我开始以为不要 length,直接 array.length 获取，
    // 试了之后，才发现，这样不对。为什么？因为 arr 的后半部分是已经排好序的，不需要参与到这个
    // 调整的过程了
    public void adjustHeap(int [] arr, int i, int length)
    {
        int temp = arr[i];

        for(int k = 2 * i + 1; k < length; k = 2 * k + 1)
        {
            if((k + 1) < length && arr[k + 1] > arr[k])
                k = k + 1;   // 这里直接进行 k 值的变化，是因为前面的部分已经是排好序的

            if(arr[k] > temp)
            {
                arr[i] = arr[k];    // 大顶堆
                i = k;
            }
        }
        arr[i] = temp;
    }

    public void swap(int [] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int [] arr = {7,4,8,12,3,2,1,15,10};
        Main demo = new Main();
        demo.Sort(arr);
        for(int item: arr)
        {
            System.out.print(item + " ");
        }
    }
}
