package Activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] A = {10,77, 10, 54, -11, 10};
        System.out.println("Result: " +sumCheck(A));
    }

    public static boolean sumCheck(int[] Arr) {
        int sum = 0;
        for (int i = 0; i < Arr.length; i++) {

            if (Arr[i] == 10) {
                sum = sum + Arr[i];
            }
            if (sum > 30){
                break;
        }
    }
        return sum==30;
    }
}
