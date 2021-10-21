package app.core.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class School {

	{
		System.out.println("School created");
	}


}
