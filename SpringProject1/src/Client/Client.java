package Client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.beans.Address;
import com.xoriant.beans.Customer;
import com.xoriant.beans.Employee;

public class Client {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	Employee emp = (Employee) context.getBean("employee");
	emp.printMsg();
	System.out.println(emp);
	
	Employee emp2 = (Employee) context.getBean("employee2"); // this is the same object retrieved in different way.THis is the other way to retrieve the object
	System.out.println(emp2);//in this the property call the setter method of Employee to set the values
	
	Address address = (Address) context.getBean("address1");
	System.out.println(address);
	
	Customer cust =  (Customer) context.getBean("customer1"); // this is the same object retrieved in different way.THis is the other way to retrieve the object
	System.out.println(cust);
}
}
