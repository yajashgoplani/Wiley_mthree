package jpmorgan_banking_withdraw;
import java.util.*;
class Mark implements Runnable{

	private List<Integer> Integers=Collections.emptyList();
	@Override
	public void run() {
		Integers=new ArrayList<>();
	for(int i=10;i>0;--i)
	{
		if(!Integers.contains(i))
		Integers.add(i);
		System.out.println(Thread.currentThread().getName()+"----"+i);
	}

	}
	public List<Integer> getIntegers() {
		return Integers;
	}
	
}
public class NewThread {

		public static void main(String[] args) {
			Mark u=new Mark();
			Thread t1=new Thread(u);
			Thread t2=new Thread(u);
			
			t1.start();
			t2.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(u.getIntegers());
		}

	}


