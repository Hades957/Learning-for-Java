class Outter
{
	String name = "Õ‚≤ø¿‡name";
	class Inner1
	{
		String name = "Inner1 name";
		void hi(){
			String name = "Inner1 hi.name";	
			class Innerx
			{
				String name = "innerx name";
			}
			Innerx x = new Innerx();
			System.out.println(x.name);
			System.out.println("Inner1 void hi...\nthis.name:"+this.name
			+"\nname:"+name+"\nOutter.name:"+Outter.this.name);
		}
	}
	static class Inner2
	{
	}


}



public class Test1{
	public static void main(String[] args){
		Outter otter = new Outter();
		Outter.Inner1 inner1_1 = otter.new Inner1();
		Outter.Inner1 inner1_2 = new Outter().new Inner1();
		
		new Outter();
		inner1_1.hi();
		
	}
	
}
class{
	String name;
	int age;
}