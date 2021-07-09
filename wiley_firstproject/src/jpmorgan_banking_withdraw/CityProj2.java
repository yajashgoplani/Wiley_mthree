package jpmorgan_banking_withdraw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class CityProj2 {

	public static void main(String[] args) {		
				//Just adding elements in the Arraylist
				List <Address11> l= new ArrayList<Address11>();
				List <User11> user= new ArrayList<User11>();
				List <Integer> postal= new ArrayList<Integer>();
				Map <Integer,String> map= new HashMap<Integer,String>(); 
				List <Address12> result=new ArrayList<Address12>();
				
				
				List <User12> Lnewuser;
				Address12 w;
				
				
				l.add(new Address11("BLR",560001));
				l.add(new Address11("BLR",560002));
				l.add(new Address11("DEL",110001));
				User11 m=new User11(2,"User2",l);
				user.add(m);
				l=new ArrayList<Address11>();
				
				l.add(new Address11("BLR",560038));
				l.add(new Address11("DEL",110096));
				l.add(new Address11("DEL",110001));
				m=new User11(44,"User44",l);
				user.add(m);
				l=new ArrayList<Address11>();
				l.add(new Address11("BOM",400018));
				l.add(new Address11("BOM",400037));
				l.add(new Address11("DEL",110001));
				l.add(new Address11("BLR",560001));
				m=new User11(3,"User3",l);
				user.add(m);
				
				//Printing Users
				for(User11 u:user)
				{
					System.out.println(u);
				}
				l=new ArrayList<Address11>();
				l=user.stream().map(User11::getAddress11).flatMap(List::stream).collect(Collectors.toList());
				postal=l.stream().map(u-> {map.put(u.zip,u.city); return u.zip;}).collect(Collectors.toList());
				
				List <Integer> key=new ArrayList<Integer>(map.keySet());
				
				for(int i=0;i<key.size();i++)
				{
					Lnewuser=new ArrayList <User12>();
					w=new Address12();
					int check=(int)key.get(i);
					w.zip=check;
					w.city=map.get(check);
					for(User11 o:(user.stream().filter(u-> u.getAddress11().stream().anyMatch(bri-> bri.zip==check) ).collect(Collectors.toList())))
					{
						Lnewuser.add(new User12(((User11)o).id,((User11)o).name));
					}
					w.user1=Lnewuser;
					//map1.put(w, Lnewuser);
					result.add(w);
				}
				Collections.sort(result,new SortUser());
				for(Address12 i:result)
				{
					Collections.sort(((Address12)i).user1,new SortList1());
				}
				for(Address12 i:result)
				{
					System.out.print("Address {"+i.city+", "+i.zip+" {");
					for(User12 u:i.user1)
					{
						System.out.print(u+"  ");
					}
					System.out.println("} }");
					
				}
				
				
				
				
				
	}
}	
class User11
{
	public int id;
	public String name;
	public List <Address11> Address11;
	public User11(int id, String name, List<Address11> Address11) {
		
		this.id = id;
		this.name = name;
		this.Address11 = Address11;
	}
	public User11()
	{
		
	}
	public List<Address11> getAddress11() {
		return Address11;
	}
	public void setAddress11(List<Address11> Address11) {
		this.Address11 = Address11;
	}
	@Override
	public String toString() {
		return "User11 [id=" + id + ", name=" + name + ", city1=" + Address11.get(0).city + ", city2=" +Address11.get(1).city + "]";
	}
	
}
class Address11
{
	public String city;
	public int zip;
	public Address11(String city, int zip) {
		
		this.city = city;
		this.zip = zip;
	}
}
class Address12
{
	public String city;
	public int zip;
	public List<User12> user1;
}
class User12 
{
	public int id;
	public String name;
	public User12(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "{id=" + id + ", name=" + name + "}";
	}
}

class SortUser implements Comparator<Address12>
{
	
	public int compare(Address12 o1,Address12 o2)
	{
		if((((Address12)o2).user1.size()-((Address12)o1).user1.size())!=0)
			return ((Address12)o2).user1.size()-((Address12)o1).user1.size();
		else
			return ((Address12)o1).city.compareTo(((Address12)o2).city);
	}
}
class SortList1 implements Comparator<User12>
{
	public int compare(User12 o1,User12 o2)
	{
		return ((User12)o1).id-((User12)o2).id;
	}
}
/*class SortCityUser implements Comparator<Address12>
{
	public int compare(Address12 a,Address12 b)
	{
			return a.city.compareTo(b.city);	
	}
}*/
