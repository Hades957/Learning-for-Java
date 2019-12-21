package com.yunsi.homework;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) {
		Properties props = new Properties();
//		try(InputStream in = 
//				TestProperties.class.getResourceAsStream("/com/yunsi/homework/config.properties");){
		try(InputStream in = TestProperties.class.getResourceAsStream("/config2.properties");
				Reader r = new InputStreamReader(in)
				){
			props.load(r);
			System.out.println(props);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
