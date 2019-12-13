package com.yunsi.app1.util;

import java.io.*;
import com.yunsi.app1.exception.*;
import com.yunsi.app1.pojo.*;
import com.yunsi.app1.pojo.sub.*;
public class Serialization{
	//对象序列化并存入文件
	public static void serializable(Object obj) throws IOException,ClassNotFoundException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);
		oos.close();		
		byte[] bs = bos.toByteArray();
		File file = new File("personInfo.txt");
		FileOutputStream fos = new FileOutputStream(file,true);
		fos.write(bs);
		fos.write(13);
		fos.write(10);



		ByteArrayInputStream bis = new ByteArrayInputStream(bs);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object object = ois.readObject();
		bos.close();
        ois.close();
        bis.close();
        if(object instanceof Student){
			Student ss = (Student)object;
			System.out.println(ss.getName()+ss.getId());
        }
		
		


		
   
		
	}
	//对象反序列化并读入内存
	/*
	public static Human[] deserializable() throws IOException,ClassNotFoundException{
		FileInputStream fis = new FileInputStream("personInfo.txt");
		//InputStream is = new ByteArrayInputStream(fis);
		InputStreamReader isr = new InputStreamReader(is);		
		BufferedReader br = new BufferedReader(isr);
		String data = null;
		Object obj = null;
		ObjectInputStream ois=null;
		while((data = br.readLine())!=null){			
			ois = new ObjectInputStream(new ByteArrayInputStream(data.getBytes()));
			obj = ois.readObject();
		}
		Student s = (Student)obj;
		System.out.println(s.getName());	
		
		ois.close();		
		fis.close();
		isr.close();
		br.close();
		return null;
	}
*/
	
}