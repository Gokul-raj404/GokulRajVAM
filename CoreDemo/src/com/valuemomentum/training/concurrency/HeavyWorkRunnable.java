package com.valuemomentum.training.concurrency;

public class HeavyWorkRunnable implements Runnable {

	public static void main(String[] args) {
		
		
		
		
		}

	@Override
	public void run() {
		System.out.println("heavy processing"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
			//doDBProcessing();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("doing -end"+Thread.currentThread().getName());
		
	}
		
	}

	

