package sort;
public class QuickSort {
    public static void main(String[] args) {
        int nums[]={4,6,8,2,1,3,9,0,5,7};
        quickSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.print(num+'\t');
        }
    }
    public static void quickSort(int[] nums, int i, int j) {
        //1.设置基准数，双指针。
        int start = i;
        int end = j;

        int jz = nums[i];
        if(start>end){
            return;
        }
        while (end > start) {

            while (nums[end] > jz) {
//            if(end==start)
//                break;
                end--;
            }

            while (start != end && nums[start] <= jz) {
                start++;
            }

            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = end;
        }
        int temp = nums[start];
        nums[start] =nums[i];
        nums[i]=temp;
        quickSort(nums,i,start-1);
        quickSort(nums,end+1,j);
    }

}
