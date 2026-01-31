class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        
       int s = 0;
       int e = letters.size()-1;
        char ans = letters[0];
        int mid = s + (e - s) /2;
       while(s<=e){
        if(letters[mid] > target){
            ans = letters[mid];
            e = mid -1;
        }
        else{
            s = mid +1;
        }
        mid = s + (e - s) /2;

       }
       return ans;

        
    }
};