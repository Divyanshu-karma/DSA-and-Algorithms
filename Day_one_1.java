// https://leetcode.com/problems/next-greater-element-i/submissions/2199872476/



class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // sol-2
        int[] answ=new int [nums1.length];
        HashMap<Integer,Integer> h=new HashMap<>();
        Stack<Integer> s=new Stack<>();
        // s.push(nums2[0]);
        for(int i=0;i<nums2.length;i++){
            s.push(nums2[i]);
            for(int j=i+1;j<nums2.length;j++){

            if(s.peek()<nums2[j]){
                h.put(s.pop(),nums2[j]);
                break;
            }
            }
            // else{
            //     h.put(s.peek(),-1);
            //     h.put(nums2[i],-1);
            // }
            // s.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            answ[i]=h.getOrDefault(nums1[i],-1);

        }

        // int[] answ=new int [nums1.length];
        // Arrays.fill(answ,-1);
        


        // for(int i=0;i<nums1.length;i++){
        //     int j=0;
        //     while(j<nums2.length){
        //     if(nums1[i]==nums2[j]){
               
              
        //         for(int k=j+1;k<nums2.length;k++){
        //             if(nums2[j]<nums2[k]){
        //             answ[i]=nums2[k];
        //             break;
        //             }
                
        //         }
        //         break;
        //     }
        //     j++;
        //     }
        // }
        return answ;
    }
}
