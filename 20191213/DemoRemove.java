import java.util.*;

public class DemoRemove{
	public static void main(String[] args){
		List lst = new ArrayList();
		lst.add(1);lst.add(2);lst.add(3);
		Iterator it = lst.iterator();
		while(it.hasNext()){
			Object ele = it.next();
			if(((Integer)ele)==1){
				it.remove();
			}
		}
		System.out.println(lst);
	}
}