package ReadAgain.tenSort.BubbleSort;

/*
*       冒泡排序：
*   最好时间复杂度：O(n)
*   最坏时间复杂度：O（n ^ 2）
*   平均时间复杂度为 O(n ^ 2)
*   空间复杂度为 O(1)
*   稳定
*   ---------------------------------------
*   比较相邻的元素，将较大的元素移交到数组的最后一位
*
*/

public class Main {

    public void BubbleSort(int [] arr)
    {
        if(arr.length == 0 || arr == null)
            return;

        int length = arr.length;
        for(int i = 0; i < length - 1; i++)
        {
            for(int j = 0; j < length - 1 - i; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[ j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

   public static void main(String[] args)
   {
       Main demo = new Main();
       int [] arr = {31,21,25,43,1,7,3,11,2};
       demo.BubbleSort(arr);
       for(int item : arr)
       {
           System.out.print(item + " ");
       }
   }
}
