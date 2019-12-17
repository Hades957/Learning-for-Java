/*
	测试LinkedList和ArrayList的插入操作的效率
*/
import java.util.*;

public class TestLinkedList{
	private static final int COUNT = 100000;	
	public static void main(String[] args){
		arrayList();
		linkedList();
	}

	public static void arrayList(){
		List list = new ArrayList();
		long start = System.currentTimeMillis();
		for(int i=1;i<COUNT;i++){
			list.add(0,i);
		}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList:"+(end-start)+"ms");
	}

	public static void linkedList(){
		List list = new LinkedList();
		long start = System.currentTimeMillis();
		for(int i=1;i<COUNT;i++){
			list.add(0,i);
		}
		long end = System.currentTimeMillis();
		System.out.println("LinkedList:"+(end-start)+"ms");
	}
}