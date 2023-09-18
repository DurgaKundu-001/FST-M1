package Activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args){
        int[] Arr={56,4,8,2,19,99,78,6,87,7};
        System.out.println("The array before sorting: "+ Arrays.toString(Arr));
        sortArray(Arr);
        System.out.println("The array after sorting: "+ Arrays.toString(Arr));

    }
public static void sortArray(int[] A){
        int AL=A.length;
        for(int i=1;i<AL;i++){
            int temp=A[i];//4
            int j= i-1;

            while (j>=0 && temp<A[j]){
                A[j+1]=A[j];
                j=j-1;
            }
            A[j+1]=temp;

        }

}

}
