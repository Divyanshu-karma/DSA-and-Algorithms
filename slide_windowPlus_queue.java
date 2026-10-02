class Solution {
    public int longestSubarray(int[] a, int k) {
        int L=0;
        int R=0;
        Queue<Integer> q = new LinkedList<>();
        int maxx=Integer.MIN_VALUE;
        for(int R=0;R<a.length;R++){
        int sum+=a[R];
        q.offer(a[R]);
        if(sum%k==0){
            cs=R+1;
            maxx=Math.max(cs,maxx);
        }
        maxx=Math.max(canp(sum, q),maxx);
        R++;
        }
        // else if(canp(sum, q)!=-1){
        //     maxx=Math.max(canp(sum, q),maxx);
        // }
        
    }
    int canp(int sum,Queue<Integer> q){
        while(!q.isEmpty()){
        if((sum-q.peek())%3==0){
            return q.size();
        }else{
            q.poll();
        }
            
        }
        return -1;
    }
}
