package Client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.beans.Address;
import com.xoriant.beans.College;
import com.xoriant.beans.Company;
import com.xoriant.beans.Customer;
import com.xoriant.beans.Employee;
import com.xoriant.beans.Order;
import com.xoriant.beans.Student;

@ComponentScan(basePackages = "com.xoriant.beans")
public class Client {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	//	ApplicationContext context = new AnnotationConfigApplicationContext(Client.class);//whenever the atttribute values have to be set @component should not be used
	//	Employee emp = (Employee) context.getBean(Employee.class);
		Customer cust = context.getBean(Customer.class);
		System.out.println(cust);
		Address address = context.getBean(Address.class);
		System.out.println(address);//autowire is only for dependency reference type
		Student student = context.getBean(Student.class);
		System.out.println(student);
		
		Order order = context.getBean(Order.class);
		System.out.println(order);
		
		Company company = context.getBean(Company.class);
		System.out.println(company);
		
		College college = context.getBean(College.class);
		System.out.println(college);
	}

}
