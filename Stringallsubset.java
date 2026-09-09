public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");
        f("","abc");
	}
	static void f(String p,String up){
	    if(up.isEmpty()){
	        System.out.println(p+" ");
	        return;
	    }
	    f(p,up.substring(1));
	    f(p+up.charAt(0),up.substring(1));
	}
