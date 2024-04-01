package Controller;

public class Operation {
	private static int colorIndex=0;
	public static void find(int index) {
		colorIndex =index;
	}

	public  static int  getColor() {
		
		return colorIndex ;
	}
}
