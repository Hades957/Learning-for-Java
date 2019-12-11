public class Test{
	public static void main(String[] args){
		Student s = new Student();
		Student s1 = new Student("zhang三",18);
		Student s2 = new Student("李4",22,"2222222");
		System.out.println(s.getName()+" "+s.getAge());
		System.out.println(s1.getName()+" "+s1.getAge());
		System.out.println(s2.getName()+" "+s2.getAge()+" "+s2.getNo());
	}
}