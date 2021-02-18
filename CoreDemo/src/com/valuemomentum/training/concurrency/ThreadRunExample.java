package com.valuemomentum.training.concurrency;

public class ThreadRunExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1=new Thread(new HeavyWorkRunnable(),"t1");
		Thread t2=new Thread(new HeavyWorkRunnable(),"t2");
		
		System.out.println("starting runnable threads");
		t1.start();
		t2.start();
		System.out.println(" runnable threads started");
		Thread t3=new MyThread2("t3");
		Thread t4=new MyThread2("t4");
		System.out.println("Starting MyThreads");
		t3.start();
		t4.start();
		System.out.println("Mythreads started");
		
		
		
		

	}

}
