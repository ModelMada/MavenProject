package curs16;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import org.testng.annotations.*;

public class TestExample {

	@Test(invocationCount = 4)		//invoc metoda de 4 ori
	public void printCeva() {
		System.out.println("Testng print!");
	}
	
	@RunMultipleTimes(howManyTimes = 4)
	public void printAltceva() {
		System.out.println("CustomPrint!");
	}
	
	//functionalitatea adnotarii RunMultipleTimes se pune intr-o metoda, nu se pune in clasa mama RunmultipleTimes; fac obiect al adnotarii ca sa am access 
	@BeforeClass			//executa metoda inaintea rularii altor metode din clasa respectiva
	public void setup() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		TestExample testExample = new TestExample();
		
		for(Method method : testExample.getClass().getDeclaredMethods()) {		//citeste toate metodele si trece prin ele, petru toate metodele di clasa
			if(method.isAnnotationPresent(RunMultipleTimes.class)) {	//daca metoda contine urmatoarea adnotare
					RunMultipleTimes annotation = method.getAnnotation(RunMultipleTimes.class);		//creez un obiect al adnotarii
					for(int i=0; i< annotation.howManyTimes();i++) {
						method.invoke(testExample);
					}
					
			}
	}
}
}
