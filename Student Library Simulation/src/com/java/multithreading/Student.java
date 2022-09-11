package com.java.multithreading;

import java.util.Random;

public class Student implements Runnable{
	
	private int studentId;
	private Book[] books;

	public Student(int studentId, Book[] books) {
		this.studentId = studentId;
		this.books = books;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random rd = new Random();
		
		while(true) {
			int bookId = rd.nextInt(Constant.NUMBER_OF_BOOKS);
			
			try {
				books[bookId].read(this);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student # "+studentId;
	}

}
