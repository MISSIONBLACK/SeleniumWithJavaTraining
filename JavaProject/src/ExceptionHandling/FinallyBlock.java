package ExceptionHandling;

public class FinallyBlock {

	public static void main(String[] args) {
		
		try {
			String text = "Akash";
			System.out.println(text);
			
			String text1 = null;
			System.out.println(text1.length());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Inside Finally Block");
		}
	}

}
