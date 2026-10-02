class Solution {
    public int toyCount(int[] arr, int k) {
        Arrays.sort(arr);
        // code here
        int L = 0;
        int R = 0;

        // Added missing variable declarations
        int sum = 0;
        int c = 0;
        int maxx = -1;

        // Changed 'a' to 'arr' to match the method parameter
        
        while(R < arr.length) {
            
            while(sum > k) {
                sum -= arr[L];
                c--;
                L++;
            }

            // Changed 'a' to 'arr'
            sum += arr[R];
            c++;
            // Changed 'target' to 'k' to match the method parameter
            if(sum <= k) {
                // c++;
                maxx=Math.max(maxx,c);
            }
            // else if(sum > k) {
            //     sum -= arr[R];
            //     // c--;
            // }
            // else {
            //     c++;
            //     maxx = Math.max(maxx, c);
            //     while(sum == k) {
            //         sum -= arr[L];
            //         L++; // Changed 'left' to 'L' to match the declared variable
            //         c--;
            //     }
            // }
            R++;
        }
            
        

        // Added return statement to satisfy the 'int' return type
        return maxx; 
    }
}
