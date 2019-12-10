interface ISporter{
	public void play();
}

public class Lambda{
	public static void main(String[] args){
		ISporter s = new ISporter(){
			public void play(){
				System.out.println("Εά²½");
			}
		};
		s.play();

		ISporter a = ()->System.out.println("HHHH");
		a.play();
	}
}