package jpmorgan_banking_withdraw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * Login 
 * *    ---prints balance, account number ,branch code
 * * 	Deposit Amount
 * * 	Withdraw Amount
 * * 	Money Transfer
 * * 	Mini Statement
 * View Balance
 * *	---prints balance
 * OpenAccount
 * *    ---Ask for necessary details
 */



public class BankApp {
	static boolean Login(List<Customer> c,String Acc,String Pass)
	{
		boolean ch=false;
		if(c.stream().anyMatch(u->((u.getAccno()).equals(Acc))&&u.getPass().equals(Pass)))
		{
			
		}
		return ch;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		List<Customer> accounts=new ArrayList<Customer>();
		String accno,pass;
		int j=101;
		Boolean z;
		Customer c;
		while(true)
		{
			System.out.println("1)Login \n2)Create Account\n3)Quick Balance Check\n4)Exit");
			int i=sc.nextInt();
			sc.nextLine();
			switch(i)
			{
				case 1:
					System.out.print("Enter your Account Number:");
					accno=sc.nextLine();
					System.out.print("Enter Password:");
					pass=sc.nextLine();
					System.out.println(accounts.get(0).getAccno());
					z=Login(accounts,accno,pass);
					if(z==false)
						System.out.println("Wrong Credentials");
					
					break;
				case 2:
					c=new Customer();
					c.createAcc();
					accounts.add(c);
					c.setAccno("SBI0023"+String.valueOf(j));
					c.setBranch("SBI0023");
					break;
			}
			j++;
		}	
	}
}

class Customer
{
	private String fname,mname,lname,email,pass,pan,accno,branch;
	public int balance;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	private long mobile;
	public void createAcc()
	{
		boolean b;
		Scanner sc=new Scanner(System.in);
		do{
			System.out.print("Enter First Name:");
			this.fname=sc.nextLine();
			b=Pattern.matches("[A-Za-z]+",fname);
			if(!b)
				System.out.println("Only alphabets are allowed");
		}while(!b);
		/*do{
			System.out.print("Enter Middle Name(If Any):");
			this.mname=sc.nextLine();
			b=Pattern.matches("[A-Za-z]*",mname);
			if(!b)
				System.out.println("Only alphabets are allowed");
		}while(!b);
		do{
			System.out.print("Enter Last Name:");
			this.lname=sc.nextLine();
			b=Pattern.matches("[A-Za-z]+",lname);
			if(!b)
				System.out.println("Only alphabets are allowed");
		}while(!b);
		do{
			System.out.print("Enter Email Id:");
			this.email=sc.nextLine();
			b=Pattern.matches("^[A-za-z0-9_.]*@[A-Za-z]+.[A-Za-z]{2,4}$",email);
			if(!b)
				System.out.println("Only alphabets are allowed");
		}while(!b);
		do{
			System.out.print("Enter Phone Number:");
			this.mobile=Long.parseLong(sc.nextLine());
			b=Pattern.matches("^[7-9]{1}[0-9]{9}$",String.valueOf(mobile));
			if(!b)
				System.out.println("Only alphabets are allowed");
		}while(!b);
		do{
			System.out.print("Enter your PAN Number:");
			this.pan=sc.nextLine();
			b=Pattern.matches("^[A-Z]{5}[0-9]{4}[A-Z]{1}$",pan);
			if(!b)
				System.out.println("Only alphabets are allowed");
		}while(!b);*/
		do{
			System.out.print("Enter your Password:");
			this.pass=sc.nextLine();
			b=Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$",pass);
			if(!b)
				System.out.println("Atleast one uppercase,lowercase,number,special character required");
		}while(!b);
		System.out.println("------------Creating Account------------");
		
	}	
}
/*
class Account()
{
	
}
*/