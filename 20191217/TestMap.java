import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
/*
	Java为数据结构中的映射提供了一个接口Java.util.Map，此接口主要有四个常用的实现类：HashMap、Hashtable、LinkedHashMap和TreeMap。 
	HashMap: 它是根据键的hashcode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序却是不确定的
*/
public class TestMap{
	public static void main(String[] args){
		Map map = new HashMap();
		map.put("a",100);
		map.put("b",200);
		map.put("d",400);
		map.put("c",300);
		//System.out.println(map);
		
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		Set set2 = map.keySet();
		Iterator it2 = set2.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
	}
}