/*
Problem: Longest Substring Without Repeating Characters
Platform: LeetCode
Difficulty: Medium

Logic:
Use the sliding window technique with two pointers (left and right).
Maintain an array to store the last seen index of each character.
When a repeated character is found within the current window,
move the left pointer to one position after the previous occurrence.
Update the maximum length at each step.

Time Complexity: O(n)
Space Complexity: O(256)-hasharray
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int hashlen=256;
        int [] hash=new int[256];
        Arrays.fill(hash,-1);
        int r=0,l=0,maxlen=0,len=0;
        while(r<n){
            if(hash[s.charAt(r)]!=-1){
                if(hash[s.charAt(r)]>=l){
                      l=hash[s.charAt(r)]+1;
                }
            }
            len=r-l+1;
            maxlen=Math.max(maxlen,len);

            hash[s.charAt(r)]=r;
            r++;
        }
     return maxlen;
    }
}
