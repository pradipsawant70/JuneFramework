package reflectionDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class RefDemo {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InvocationTargetException 
	{
		
		Students s1=new Students();
		
		Class c1=s1.getClass();
		//this will return runtime class of this object s1
		System.out.println(c1.getName());
		
		Constructor const1=c1.getConstructor();
		System.out.println(const1.getName());
		
		Method[] allMethods=c1.getMethods();
		//This will return array of Method type, Method is seperate class in reflection
		for (Method m : allMethods) 
		{
			System.out.println(m.getName());			
		}
		
		Field f1=c1.getDeclaredField("collName");
		System.out.println(f1);	//public java.lang.String reflectionDemo.Students.collName
		System.out.println(f1.getName());	//collName
		System.out.println(f1.get(s1));		//LNCT
		
		Method pvtmethod=c1.getDeclaredMethod("breaktime");
		pvtmethod.setAccessible(true);
		pvtmethod.invoke(s1);
					
	}

}
