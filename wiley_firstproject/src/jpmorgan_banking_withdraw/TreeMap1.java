package jpmorgan_banking_withdraw;


import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeMap1{
	public static void main(String[] args) {
		
		//Case 1
//		Set<Object> test = new TreeSet<Object>(new SortByIntUser2IDString());
		//Case 2
//		Set<Object> test = new TreeSet<Object>(new SortByStringUser2IDInt());
		//Case 3
		Set<Object> test = new TreeSet<Object>(new SortStrInt());
		
		test.add(new User2(1,"Adam"));
		test.add(new User2(2,"User2"));
		test.add(new Integer(1));
		test.add(new Integer(2));
		test.add(new String("Hello"));
		test.add(new String("Hi"));
		System.out.println(test);
	}


}
class User2{
	private int id;
	private String name;
	
	public User2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return id + " " + name ;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class SortByIntUser2IDString implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		if(o1 instanceof Integer) {
			if(o2 instanceof Integer)
				return (int)o1-(int)o2;
			else
				return -1;
		}
		else if(o1 instanceof User2) {
			if(o2 instanceof User2)
				return new SortByUser2ID().compare((User2)o1,(User2)o2);
			else
				return -1;
		}
		else if(o1 instanceof String){
			if(o2 instanceof String)
				return o1.toString().compareTo(o2.toString());
			else
				return 1;
		}
		return 0;
	}
	
}

class SortByStringUser2IDInt implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		if(o1 instanceof String){
			if(o2 instanceof String)
				return o1.toString().compareTo(o2.toString());
			else
				return -1;
		}
		else if(o1 instanceof User2) {
			if(o2 instanceof User2)
				return new SortByUser2ID().compare((User2)o1,(User2)o2);
			else
				return -1;
		}
		else if(o1 instanceof Integer) {
			if(o2 instanceof Integer)
				return (int)o1-(int)o2;
			else
				return 1;
		}
		return 0;
	}
	
}

class SortStrInt implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		if(o1 instanceof Integer) {
			if(o2 instanceof Integer)
				return (int)o1-(int)o2;
			else
				return 1;
		}
//---------------------------------------------------------------
//		else if(o2 instanceof Integer) {
//			if(o1 instanceof Integer)
//				return (int)o1-(int)o2;
//		}
//---------------------------------------------------------------
		else if(o1 instanceof String){
			if(o2 instanceof String)
				return ((String)o1).compareTo((String)o2);
			else if(o2 instanceof User2)
				return new SortByString1().compare(o1, o2);
			else
				return -1;
		}
//---------------------------------------------------------------
//		else if(o2 instanceof String){
//			if(o1 instanceof String)
//				return ((String)o1).compareTo((String)o2);
//			else if(o1 instanceof User2)
//				return new SortByString().compare(o2, o1);
//			else
//				return -1;
//		}
//---------------------------------------------------------------
		else if(o1 instanceof User2) {
			if(o2 instanceof User2)
				return new SortByUser2Name().compare((User2)o1, (User2)o2);
			else if(o2 instanceof String)
				return new SortByString1().compare(o1, o2);
			else
				return -1;
		}
//---------------------------------------------------------------
//		else if(o2 instanceof User2) {
//			if(o1 instanceof User2)
//				return new SortByUser2Name().compare((User2)o1, (User2)o2);
//			else if(o1 instanceof String)
//				return new SortByString().compare(o2, o1);
//			else
//				return -1;
//		}
//---------------------------------------------------------------
		return 0;
	}
	
}

class SortByUser2ID implements Comparator<User2>{

	@Override
	public int compare(User2 o1, User2 o2) {
		// TODO Auto-generated method stub
		return o1.getId()-o2.getId();
	}
	
}


class SortByString1 implements Comparator<Object>{
    @Override
    public int compare(Object o1, Object o2) {
        // TODO Auto-generated method stub
        if(o1 instanceof User2) {
        	if(o2 instanceof String)
        		return ((User2) o1).getName().compareTo((String) o2);
        }
        else if(o1 instanceof String) {
        	if(o2 instanceof User2)
        		return ((String) o1).compareTo(((User2) o2).getName());
        }
        return 0;
    }
}

class SortByUser2Name implements Comparator<User2>{

	@Override
	public int compare(User2 o1, User2 o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
}