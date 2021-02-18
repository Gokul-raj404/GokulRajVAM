package com.valuemomentum.training.concurrency;

public class MyThread extends Thread {

	public static void main(String[] args) {
		
		MyThread objex =new MyThread();
		objex.create();
		System.out.println("this is main thread");
		//objex.run();

	}

	public void create() {
		Thread Objth =new Thread(this);
		Objth.start();
	}
	
	public void run() {
		while(true)
		{
			try{
				System.out.println("child thread");
				Thread.sleep(500);
				}
			catch(InterruptedException e) {
			}
		}
}}
