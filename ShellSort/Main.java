package ReadAgain.tenSort.ShellSort;

/**
 *      希尔排序
 *  最好时间复杂度: O( n )
 *  最坏时间复杂度：O( n ^ 2)
 *  平均时间复杂度：O(n^1.3)
 *  空间复杂度：O(1)
 *  不稳定
 *  -------------------------
 *  插入排序的升级版，并非是一个一个的取出比较，而是隔几个进行比较
 *
 */

public class Main {
   public void ShellSort(int [] arr)
   {
       if(arr.length == 0 || arr == null)
           return;

       int length = arr.length;
       for(int gap = length / 2; gap > 0; gap = gap / 2)
       {
           for(int i = gap; i < length ; i +=gap)
           {
               int current = arr[i];
               int j = i - gap;
               while(j >= 0 && arr[j] > current)
               {
                   arr[j + gap] = arr[j];
                   j = j - gap;
               }
               arr[j + gap] = current;
           }
       }
   }

   public static void main(String [] args){
        Main demo = new Main();
        int [] arr = {56,34,78,22,2,64,3};
        demo.ShellSort(arr);
        for(int item: arr)
        {
            System.out.print(item + " ");
        }
   }
}
