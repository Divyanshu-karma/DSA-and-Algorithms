/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
// import java
public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");\
        int[] nums={1,0,1,1,0,1,1,1};
        int i=0;
        int j=0;
        int ans=0;
        int cs=0;
        HashMap<Integer,Integer> hh=new HashMap<>();
        while(j<nums.length){
            // hh.put(nums[j],hh.getOrDefault(nums[j],0)+1);
            if(nums[j]==0 && hh.getOrDefault(0, 0)==1 ){
                // cs=j-i+1;
                // ans=Math.max(ans,cs);
                hh.put(nums[i],hh.getOrDefault(nums[i],0)-1);
                i++;
                cs=cs-1;
            }
            else{
                hh.put(nums[j],hh.getOrDefault(nums[j],0)+1);
                // cs=j-i+1;
                cs=cs+1;
                ans=Math.max(ans,cs);
            }
            j++;
        }
        System.out.println( ans);
	}
}
