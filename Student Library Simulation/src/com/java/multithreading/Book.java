package com.java.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
	private int id;
	private Lock lock;
	
	public Book(int id) {
		this.id = id;
		this.lock = new ReentrantLock();
	}
	
	public void read(Student student) throws InterruptedException{
		lock.tryLock(1,TimeUnit.MINUTES);
		System.out.println(student+" reading: "+this);
		Thread.sleep(2000);
		lock.unlock();
		System.out.println(student+" has finished reading book :"+id);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book #"+id;
	}
}
