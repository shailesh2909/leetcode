class Solution {
public:
    bool hasIncreasingSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        if(k == 1) return true;
        for(int i=0; i <= n - 2*k;i++){
            int aflag = 1 , bflag = 1;
            for(int j=i;j<i+k-1;j++){
                if(nums[j] >= nums[j+1]){
                    aflag = 0;
                    break;
                }
            }

            if(aflag){
                int start = i+k;
                int end = i + (2 * k);
                for(;start < end-1;start++){
                    if(nums[start] >= nums[start+1]){
                        bflag = 0;
                        break;
                    }
                }
            }

            if(aflag && bflag) return true;
        }

        return false;
    }
};