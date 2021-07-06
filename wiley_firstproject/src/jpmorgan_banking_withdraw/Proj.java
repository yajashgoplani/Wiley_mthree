package jpmorgan_banking_withdraw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
class SortBySalary implements Comparator<Employee> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(Employee a, Employee b)
    {
        return (int)(a.salary - b.salary);
    }
}

public class Proj {
	
	  
	public static List<Employee> filterOut(List <User> users)
	{
		List <Employee> emp=new ArrayList<Employee>();
		for(Object i:users)
		{
			if(i instanceof Employee)
			{
				emp.add((Employee)i);
			}
		}
		return emp;
	}
	public static boolean costCheck(List <Employee> emp)
	{
		Employee x;
		double sum=0,bud=0;
		for(Object i:emp) {
			sum+=((Employee)i).salary;
			bud=((Employee)i).project.budget;
		}
		if(bud<sum)
		{
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee x;
		boolean y;
		List <User> users=new ArrayList<User>();
		List <Employee> emp=new ArrayList<Employee>();
		Project p=new Project(10001,"Wil01",1000);
		users.add(new User("1000","aman"));
		users.add(new User("1001","anil"));
		users.add(new Employee("1002","amit",new Address("Delhi","110063"),p,(double)400));
		users.add(new Employee("1003","akshay",new Address("Delhi","110011"),p,(double)500));
		users.add(new Employee("1004","akash",new Address("Delhi","110063"),p,(double)300));
		emp=filterOut(users);
		Collections.sort(emp,new SortBySalary());
		while(true)
		{	if(costCheck(emp))
			{
				emp.remove(0);
			}
			else 
			{
				break;
			}
		}
		Iterator itr= emp.iterator();
		while(itr.hasNext())
		{
			x=(Employee)itr.next();
			System.out.println(x.name+" "+x.project.name+" "+x.salary);
		}
	}

}
class User
{
	public String id;
	public String name;
	User(String id,String name)
	{
		this.id=id;
		this.name=name;
	}
}
class Employee extends User
{
	Address address;
	Project project;
	double salary;
	public Employee(String id, String name, Address address, Project project, double salary) {
		super(id, name);
		this.address = address;
		this.project = project;
		this.salary = salary;
	}
	
	
}
class Address
{
	String city;
	String zipcode;
	public Address(String city, String zipcode) {
		this.city = city;
		this.zipcode = zipcode;
	}	
}
class Project
{
	int projectId;
	String name;
	double budget;
	public Project(int projectId, String name, double budget) {
		this.projectId = projectId;
		this.name = name;
		this.budget = budget;
	}
	
}
