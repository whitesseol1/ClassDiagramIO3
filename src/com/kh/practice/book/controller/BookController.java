package com.kh.practice.book.controller;

import java.io.File;
import java.io.IOException;

import com.kh.practice.book.model.dao.BookDAO;
import com.kh.practice.book.model.vo.Book;

public class BookController {

	private BookDAO bd=new BookDAO();
	
	public void makeFile() {
		
		File f=new File("book.txt");
		if(!f.exists()) {
		   try {
		   f.createNewFile();//파일을 생성하는 매소드 //예외처리 필요한 매소드..
		   }catch(IOException e) {
			e.printStackTrace();
		   }
		}
		
	}
	
	public void fileSave(Book[] bArr) {
		bd.fileSave(bArr);
		
	}
	
	public Book[] fileRead() {
		Book[] bArr=bd.fileRead();
		return bArr;
	}
	
	
}
