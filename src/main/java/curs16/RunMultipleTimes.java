package curs16;

//cream o adnotare ca cea te testng, Test.class
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)  //la declaratie am spus ca se poate pune deasupra unei metode doar; putem declara sa se puna si deasupra clasei
public @interface RunMultipleTimes {

	int howManyTimes();
	
}
