import java.util.Scanner;
public class ClosestMinMax {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int size=scanner.nextInt();
        int array[]=new int[size];
        for(int i=0;i<size;i++)
        {
            array[i]=scanner.nextInt();
        }
        System.out.println(findClosestMinMax(array,size));
    }

    public static int findClosestMinMax(int array[],int size)
    {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        //finding min and max element of the array
        for(int i=0;i<size;i++)
        {
            if(max<array[i])
            {
                max=array[i];
            }
            if(min>array[i])
            {
                min=array[i];
            }
        }

        //finding minimum subarray that contain max and min elements
        int result=size;
        int min_index=-1;
        int max_index=-1;
        for(int i=0;i<size;i++)
        {
            if(array[i]==min)
            {
                min_index=i;
                if(max_index >= 0)
                {
                    result=Math.min(result,Math.abs(max_index-i)+1);
                }
            }
            if(array[i] == max)
            {
                max_index=i;
                if(min_index >= 0)
                {
                    result=Math.min(result,Math.abs(min_index-i)+1);
                }
            }
        }

        return result;
    }
}
