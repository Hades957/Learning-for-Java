import java.util.*;

public class DemoIterator{
	public static void main(String[] args){
		List lst = new ArrayList();
		lst.add(18);
		lst.add(true);
		lst.add("abc");
		System.out.println("\n普通循环\n");
		for(int i=0;i<lst.size();i++){
			Object ele = lst.get(i);
			System.out.println(ele+" ");
		}
		System.out.println("\n\nforEach循环针对List集合进行遍历");
		for(Object ele : lst){
			System.out.println(ele+" ");
		}
		System.out.println("\n\n使用Iterator对List进行遍历");
		Iterator it = lst.iterator();
		while(it.hasNext()){
			Object ele = it.next();
			System.out.println(ele+" ");
		}
		
	}
}