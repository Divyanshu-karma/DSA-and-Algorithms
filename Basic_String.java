public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");
        String s1="asedbdcds";
        String s2="d";
		String ans="";
		int j=0;
		while(j<s2.length()){
		  //  int i=0;
		  //  if(s1.contains(s2.charAt(j))){
		  int check=s1.indexOf(s2.charAt(j));
		    while(check!=-1){
		       ans+= s2.charAt(j);
		       s1= s1.substring(0,check)+""+s1.substring(check+1);
		       check=s1.indexOf(s2.charAt(j));
		    }
	
		        j++;
		    
		}
		System.out.println(ans);
	}
}
