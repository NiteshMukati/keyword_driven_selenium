package dummy_testing;

public class testSplit {

	public static void main(String[] args) {

		
		String splitS = "name=//xpath[@name='nitesh']";
		
		
		String name = splitS.split("=",2)[0];
		System.out.println("after 1st split Name ---> " +name);
		
		String value = splitS.split("=",2)[1];
		System.out.println("after 2nd split Value ---> "+value);
		
		System.out.println(splitS);
		
		
		
		
		
		
		
		
		
		
	}

}
