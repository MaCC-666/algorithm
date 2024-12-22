package sort;
public class quickSortdemo2 {
    public static void main(String[] args) {
        int nums2[]={4,6,8,2,1,3,9,0,5,7};
        int[] nums3 = {1, 1, 1, 1, 1};
        int[] nums = {5,4,3,2,1};
        int nums1[]={-1,-1,-1,4,4,4,0,0,0,0,0};

        quickSort1(nums,0,nums.length-1);
        for (int num : nums) {
            //"\t"和'\t'有区别，如果是字符的形式的话，就相当于二者数相加
            System.out.print(num+"\t");
        }
    }
    public static void quickSort1(int[] nums, int i, int j) {
        //1.设置基准数，双指针。
        int start = i;
        int end = j;
        //注意这里if判断的顺序，不然会导致jz赋值空指针
        if(start>end){
            return;
        }
        int jz = nums[i];

        while (end > start) {

            while (nums[end] > jz) {
//            if(end==start)
//                break;
                end--;
            }
            //需要start!=end这个条件，不然逆序数组会出界
            //以及是<=这个条件
            while (start != end && nums[start] <= jz) {
                start++;
            }

          //  if(start!=end){如果end=start则这段可以跳过
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            //}
        }
        int temp = nums[start];
        nums[start] =nums[i];
        nums[i]=temp;
        quickSort1(nums,i,start-1);
        quickSort1(nums,end+1,j);
    }
}
