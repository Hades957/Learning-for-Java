import java.util.*;

public class TestTraverseMap{
	public static void main(String[] args){
		Map map = new HashMap();
		map.put("111","aaa");
		map.put("222","bbb");
		map.put("444","ddd");
		map.put("333","ccc");

		Object v = null;
		Set ks = map.keySet();
		for(Object k : ks){
			v = map.get(k);
			System.out.println(k+"=>"+v);
		}
		Iterator it = ks.iterator();
		while(it.hasNext()){
			Object k = it.next();
			v = map.get(k);
			System.out.println(k+"->"+v);
		}

		System.out.println("\n\n获取Map中所有的键值对组成的对象(是Map.Entry类型)的集合，然后针对这个集合遍历:");
		//获取key和value键值对(组成的一个对象)，以Set形式返回
		Set es = map.entrySet();
		for(Object ee : es){
			Map.Entry me = (Map.Entry)ee;
			Object kk = me.getKey();
			Object vv = me.getValue();
			System.out.println(kk+"="+vv);
		}
		
		//还有一种就是把所有的值个获取出来，以Collection形式返回
		Collection coll = map.values();
		for(Object vv : coll){
			System.out.println("vv="+vv);
		}
	}
}

