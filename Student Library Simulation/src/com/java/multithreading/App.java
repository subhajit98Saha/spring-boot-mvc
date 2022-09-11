package com.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] students =null;
		Book[] books = null;
		
		ExecutorService executor = Executors.newFixedThreadPool(Constant.NUMBER_OF_STUDENTS);
		
		try {
			books = new Book[Constant.NUMBER_OF_BOOKS];
			students = new Student[Constant.NUMBER_OF_STUDENTS];
			
			for(int i=0;i<Constant.NUMBER_OF_BOOKS;i++) {
				books[i] = new Book(i);
			}
			
			for(int i=0;i<Constant.NUMBER_OF_STUDENTS;i++) {
				students[i] = new Student(i,books);
				executor.execute(students[i]);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			executor.shutdown();
		}
	}

}
