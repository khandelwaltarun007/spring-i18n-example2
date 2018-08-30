package spring.i18n.example2.main;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.i18n.example2.configuration.SpringConfiguration;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		MessageSource messageSource = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		Scanner scanner = new Scanner(System.in);
		
		Locale english = Locale.ENGLISH;
		System.out.print("Enter First Name : ");
		String firstName = scanner.nextLine();
		System.out.print("Enter Last Name : ");
		String lastName = scanner.nextLine();
		System.out.println("English:");
		System.out.println(messageSource.getMessage("nameMsg", new Object[] { firstName, lastName }, english));

		
		System.out.println("Dutch:");
		Locale dutch = new Locale("du");
		System.out.println(messageSource.getMessage("msg", null,"No message found in Dutch", dutch));

		System.out.println("French:");
		Locale french = new Locale("fn");
		System.out.println(messageSource.getMessage("msg", null,"No message found in French", french));
		
		System.out.println(messageSource.getMessage("hi", null,"No message found in logging",null));
	}
}
