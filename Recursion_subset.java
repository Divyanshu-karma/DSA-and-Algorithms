public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");
        int[] a={1,2,2};
        
	}
	static List<List<Integer>> f(int[] a){
	    List<List<Integer>> outer=new ArrayList<>();
	    outer.add(new ArrayList<>());
	    for(int i=0;i<a.length;i++){
	        List<Integer> inn=new ArrayList<>(outer.get(i));
	        inn.add(a[i]);
	        if(!outer.contains(new ArrayList<>(inn[0]))){
	            ounter.add(inn);
	        }
	    }
	} 
	

}
