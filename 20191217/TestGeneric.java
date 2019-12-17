import java.util.ArrayList;
import java.util.List;

public class TestGeneric{
	public static void main(String[] args){
		List list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		System.out.println(list);
	}
}