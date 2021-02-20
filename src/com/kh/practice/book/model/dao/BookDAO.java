package com.kh.practice.book.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


import com.kh.practice.book.model.vo.Book;

public class BookDAO {

	
	private Book[] bArr=new Book[10];
	
	public void fileSave(Book[] bArr) {
		
		try( Scanner sc=new Scanner(System.in);
				ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("book.txt")) ){
		   if(bArr!=null) {
			oos.writeObject(bArr);
		   }
		}catch(EOFException eo) {
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Book[] fileRead() {
		
		try(ObjectInputStream ois
				=new ObjectInputStream(new FileInputStream("book.txt")) ){
			
//                	for(int i=0;i<bArr.length;i++){
//						if(bArr[i]==null) {
			       bArr=(Book[])ois.readObject(); //형변환후 집어넣기
			       //System.out.println(m);
						  
//						}
		}catch(EOFException e) {
					
		}catch(ClassNotFoundException e) {//얘도 꼭 처리해야함
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	
		
		return bArr;
	}
	
}
