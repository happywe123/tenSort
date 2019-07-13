package ReadAgain.tenSort.SelectionSort;

/**
 *       选择排序
 *  最好，最坏，平均时间复杂度为 O（n^2）
 *  空间复杂度为 O（1）
 *  不稳定
 *  -------------------------------
 *  顾名思义就是选择一个元素，进行排序
 *
 */

public class Main {
   public void SelectionSort(int [] arr)
   {
       if(arr.length == 0 || arr == null)
           return;

       int length = arr.length;
       for(int i = 0; i < length; i++)
       {
           int min = arr[i];
           int index = i;
           for(int j = i + 1; j < length; j++)
           {
               if(min > arr[j])
               {
                   min = arr[j];
                   index = j;
               }
           }

           if(index != i)
           {
               arr[index] = arr[i];
               arr[i] = min;
           }
       }
   }


   public static void main(String[] args)
   {
       Main demo = new Main();
       int [] arr = {12,11,2,3,6,25};
       demo.SelectionSort(arr);
       for(int item : arr)
       {
           System.out.print(item + " ");
       }
   }
}
