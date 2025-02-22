package array;

public class ReversePairs{
    // TLE 
    // not optimized
    public static void main(String[] args) {
        
    }
    public int reversePairs(int[] nums) {
        int op=0;
        for(int i=0;i<nums.length-1;i++){
            long iv=nums[i];
            for(int j=i+1;j<nums.length;j++){
                long jv=nums[j];
                if(iv>2*jv){
                    op++;
                }
            }
        }
    return op;
    }
}