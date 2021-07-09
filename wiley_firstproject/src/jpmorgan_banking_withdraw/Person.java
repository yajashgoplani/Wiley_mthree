package jpmorgan_banking_withdraw;
import java.util.*;
class Save
{
	private String name;
	private char des;
	private int age;
	private float salary;
	private String empid;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getDes() {
		return des;
	}
	public void setDes(char des) {
		this.des = des;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	int validateName(String name)
	{
		int c=0;
		for(int i=0 ;i<name.length();i++)
			if(name.charAt(i)==' ')
				c++;
		if(c>2)
		{
			System.out.println("Name cannot have more than two spaces");
			return 0;
		}
		return 1;
	}
	char create()
	{
		int flag;
		Scanner sc= new Scanner(System.in);
		do {
				System.out.print("\nEnter your name:");
				name= sc.nextLine();
				flag=validateName(name);
		}while(flag==0);
		do {
			String input;
			System.out.print("Enter your age:");
			input= sc.nextLine();
			try
			{
				age=Integer.parseInt(input);
				if(age<18||age>60)
					System.out.println("Age should be greater than 18 and less than 60");
			}
			catch (NumberFormatException ne) 
			{
				System.out.println("Input is not a number, continue");
			}
		}while(age<18||age>60);
		do {
				flag=0;
				System.out.print("Enter your Designation:");
				des= sc.nextLine().charAt(0);
				if(des!='P'&&des!='M'&&des!='T')
				{
					flag=1;
					System.out.println("Please Enter Correct Designation");
				}
				else
				{
					if(des=='P')
						salary=30000;
					else if(des=='M')
						salary=35000;
					else
						salary=25000;
				}
		}while(flag==1);
		System.out.print("Want to add more(y/n):");
		return (sc.nextLine().charAt(0));	
	}
	void display()
	{
		System.out.println("\nName:"+name+"\nage:"+age+"\nDesignation:"+des+"\nSalary:"+salary+"\nEmployee ID:"+empid);
	}
	void raiseSal(int per)
	{
		float g=(1+((float)per/100));
		salary=salary*g;
	}
}
public class Person {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0,k=0,per;
		int flag=0,flagr=0,flagd=0;
		String id,com="Wiley";
		char c;
		Save s[]= new Save[50];
		while(true)
		{
			k=0;flagr=0;
			System.out.println("\n1)create\n2)display\n3)raise sal\n4)Exit");
			Scanner sc= new Scanner(System.in);
			System.out.print("Enter your choice: ");
			int a = sc.nextInt();
			sc.nextLine();
			switch(a)
			{
				case 1:
					do {
							if(k!=0)
								i++;
							k++;
							s[i]=new Save();
							c=s[i].create();
							if(i<10)
								s[i].setEmpid(com+"0"+Integer.toString(i+1));
							else
								s[i].setEmpid(com+Integer.toString(i+1));
					}while(c=='y'&&k!=10);	
					if(k==10)
						System.out.print("\nLIMIT EXCEED");
					flag=1;
					break;
				case 2:
					if(flag==0)
						System.out.println("Atleast Create Some Records first");
					else
						for(int j=0;j<i;j++)
							s[j].display();
							flagd=1;
					i--;
					break;
				case 3:
					if(flagd==1)
					{
						System.out.print("Enter your Employee ID:");
						id=sc.nextLine();
						for(int j=0;j<i;j++)
						{
							if(s[j].getEmpid().equals(id))
							{
								do {
								System.out.print("Percentage Increase:");
								per=sc.nextInt();
								s[j].raiseSal(per);
								sc.nextLine();
								flagr=1;
								}while(per>30);
								break;
							}
						}
						if(flagr==0)
							System.out.println("Sorry, Employee Id does not exists");
					}
					else
						System.out.println("Please first display records then choose this option");
					i--;
					break;
				case 4:
					System.exit(0);
				default:
					System.out.println("Wrong Input");
					i--;
					break;
			}		
			i++;
		}
	}

}
