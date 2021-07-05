package jpmorgan_banking_withdraw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class user
{
	private  int salary;
	private String city;
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	user(int sal,String city)
	{
		this.city=city;
		this.salary=sal;
	}
}
class Sortbyroll implements Comparator<user> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(user a, user b)
    {
        return a.getSalary() - b.getSalary();
    }
}
  
class Sortbycity implements Comparator<user> {
    
    public int compare(user a, user b)
    { 
        return a.getCity().compareTo(b.getCity());
    }
}
class Sortbyboth implements Comparator<user> 
{
	  public int compare(user a, user b)
	  {
				if(!(a.getCity().equals(b.getCity())) )
				{
					return a.getCity().compareTo(b.getCity());
				}
				return a.getSalary()-b.getSalary();

	  }
} 
public class comparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List l=new ArrayList();
		Scanner sc= new Scanner(System.in);
		Iterator itr;
		int sal;
		String city;
		user u;
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter salary:");
			sal=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter city:");
			city=sc.nextLine();
			u=new user(sal,city);
			l.add(u);
		}
		
		
		Collections.sort(l,new Sortbyboth());
		itr=l.iterator();
		while(itr.hasNext())
		{
			u=(user)itr.next();
			System.out.println(u.getSalary()+" "+u.getCity());
		}
	}

}





