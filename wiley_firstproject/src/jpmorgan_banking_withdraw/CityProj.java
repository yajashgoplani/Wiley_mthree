package jpmorgan_banking_withdraw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CityProj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Address1>l=new ArrayList<Address1>();
		List <User5> user=new ArrayList<User5>();
		List <List<User5>> user1= new ArrayList<List<User5>>();
		List <Address2> result=new ArrayList<Address2>();
		List <User6> Lnewuser;
		
		Address2 w;
		l.add(new Address1("DEL",110001));
		l.add(new Address1("BLR",560001));
		User5 m=new User5(2,"User2",l);
		user.add(m);
		List <Address1>l1=new ArrayList<Address1>();
		l1.add(new Address1("GN",201385));
		l1.add(new Address1("BLR",560001));
		m=new User5(1,"User1",l1);
		user.add(m);
		List <Address1>l3=new ArrayList<Address1>();
		l3.add(new Address1("GN",201385));
		l3.add(new Address1("BLR",560001));
		m=new User5(3,"User3",l3);
		user.add(m);
		for(User5 u:user)
		{
			System.out.println(u);
		}
		List<String> city,city1,city2;
		city= new ArrayList<String>();
		city1=new ArrayList<String>();
		city2=new ArrayList<String>();
		List<List<Address1>> q= new ArrayList <List<Address1>>();
		//{u1 u2 u3}
		//[dl, bn,bn bn, gn gn] city   { address address address }
		//[Dl ,BLR GN]  city1
		city=user.stream().map(u->(u.getAddress1())).flatMap(List::stream).map(u->u.city).collect(Collectors.toList());
		city1 =user.stream().map(u->(u.getAddress1())).flatMap(List::stream).map(u->u.city).distinct().collect(Collectors.toList());
		for(String i:city1)
		{
			if(Collections.frequency(city, (String)i)>1)
			{
				city2.add((String)i);
			}
		}
		System.out.println(city2);
		
		
		//city2[blr,gn]
		
		for(int i=0;i<city2.size();i++)
		{
			Lnewuser=new ArrayList <User6>();
			w=new Address2();
			String check=(String)city2.get(i);
			w.city=check;
			w.user=user.stream().filter(u-> u.getAddress1().stream().anyMatch(bri-> bri.city==check) ).collect(Collectors.toList());
			user1.add(w.user);
			for(User5 o:user1.get(i))
			{
				Lnewuser.add(new User6(((User5)o).id,((User5)o).name));
			}
			w.user1=Lnewuser;
			result.add(w);
		}
		//Collections.sort(result,new SortCityUser());
		for(Address2 i:result)
		{
			Collections.sort(((Address2)i).user1,new SortList());
		}
		for(Address2 i:result)
		{
			
			System.out.print("Address {"+i.city+", {");
			for(User6 u:i.user1)
			{
				System.out.print(u+"  ");
			}
			System.out.println("}");
			
		}
		
	}

}
class User5
{
	public int id;
	public String name;
	public List <Address1> Address1;
	public User5(int id, String name, List<Address1> Address1) {
		
		this.id = id;
		this.name = name;
		this.Address1 = Address1;
	}
	public List<Address1> getAddress1() {
		return Address1;
	}
	public void setAddress1(List<Address1> Address1) {
		this.Address1 = Address1;
	}
	@Override
	public String toString() {
		return "User5 [id=" + id + ", name=" + name + ", city1=" + Address1.get(0).city + ", city2=" +Address1.get(1).city + "]";
	}
	
}
class Address1
{
	public String city;
	public int zip;
	public Address1(String city, int zip) {
		
		this.city = city;
		this.zip = zip;
	}
}
class Address2
{
	public String city;
	public int zip;
	public List<User5> user;
	public List<User6> user1;
}
class User6 
{
	public int id;
	public String name;
	public User6(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "{id=" + id + ", name=" + name + "}";
	}
}

class SortList implements Comparator<User6>
{
	public int compare(User6 o1,User6 o2)
	{
		return ((User6)o1).id-((User6)o2).id;
	}
}
class SortCityUser implements Comparator<Address2>
{
	public int compare(Address2 a,Address2 b)
	{
			return a.city.compareTo(b.city);	
	}
}