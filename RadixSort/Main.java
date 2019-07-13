package ReadAgain.tenSort.RadixSort;

/**
 *      基数排序
 *  最好，最坏，平均时间复杂度：O（n * k）
 *  空间复杂度：O（n + k）
 *  稳定
 *
 */

public class Main {
    public void RadixSort(int [] arr, int d)
    {
        if(arr == null || arr.length == 0)
            return;

        int exp = 1;    // 用来记载位数
        int index = 0;
        int length = arr.length;
        int [][] bucket = new int[10][length];  // 临时数组，
        int [] order = new int[10];      // 临时数组里的一维数组，用于表示各位的个数

        while(exp <= d)
        {
            for(int item : arr)
            {
                int number = (item / exp) % 10;    // 取出对应位数的数，进行分类存储
                bucket[number][order[number]] = item;
                order[number]++;    // 下标表示数值，
            }

            for(int i = 0; i < order.length; i++)
            {
                if(order[i] != 0)
                {
                    for(int j = 0; j < order[i]; j++)
                    {
                        arr[index++] = bucket[i][j];  // 将对应位排好序的数进行排序，放进原始数组
                    }
                    order[i] = 0;   // 清空
                }
            }
            exp = exp * 10;
            index = 0;
        }
    }

    public static void main(String[] args){
        Main demo = new Main();
        int [] array = {73,22,43,55,14,28,65,39,81};
        demo.RadixSort(array,10);
        for(int item:array)
        {
            System.out.print(item + " ");
        }
    }
}
