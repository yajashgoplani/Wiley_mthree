package jpmorgan_banking_withdraw;

import java.util.*;

class Fib {
	public static void main(String[] args) {
		Thread m1= new Thread(new Fib1(),"m1");
		Thread m2= new Thread(new Fib1(),"m2");
		m1.start();
		m2.start();
	}
}
class Fib1 extends Thread{

			List<Integer> l = new ArrayList<Integer>();

			static int a = 0, b = 1, c = 1;
			public synchronized void run() {
				for (int i = 0; i < 10; i++) {
					//synchronized(Fib1.class)
					{
						System.out.println("Thread-"+Thread.currentThread().getName()+" "+a + " + " + b + " = " + c);
						a = b;
						b = c;
						c = a + b;
						l.add(c);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		
}