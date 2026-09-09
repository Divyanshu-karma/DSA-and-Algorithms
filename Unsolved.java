public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");
        f("","abc");
	}
	
	static void f(String p,String up){
	    
	    if(up.isEmpty()){
	        System.out.println(p);
	        return;
	    }
	    char ch=up.charAt(0);
	    for(int i=0;i<=p.length();i++){
	        System.out.println(p.substring(0,i)+ch+p.substring(i,p.length()));
	    }
// 	    f(p,up.substring(1));
	    f(p+up.charAt(0),up.substring(1));
	}}
