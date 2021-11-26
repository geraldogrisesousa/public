package ba.com.grisecorp.data.repository;

import java.lang.reflect.Type;

public class Intanciate<T> {

	public Class getClassObject(Class<?> object)
	{
		Type base_class = object.getClass();
		Class ref_class = null;
		try 
		{
			ref_class = Class.forName(object.getClass().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    return ref_class;
	}
}
