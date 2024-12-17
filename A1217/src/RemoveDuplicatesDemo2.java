public class RemoveDuplicatesDemo2 {
    public int removeDuplicates(int[] nums) {
        if(nums.length<3){
            return nums.length;
        }
        int i=0;
        int j=0;
        int k=0;

        while (j<nums.length){
            int count =1;
            while (j<nums.length&&nums[i]==nums[j++]){
                count++;
            }
            if(j<nums.length&&count>2){
                nums[++k]=nums[j];
                nums[i]=nums[j];
            }

        }
        return k

    }
}
