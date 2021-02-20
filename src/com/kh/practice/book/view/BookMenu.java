package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {
	
	private Scanner sc;
	
	private BookController bc;
	
	private Book[] bArr;
	
	public BookMenu() {
		sc=new Scanner(System.in);
		bc=new BookController();
		bc.makeFile();
		bArr=bc.fileRead();
	}

	public void mainMenu() {
		
		boolean run=true;
		while(run) {
			sc = new Scanner(System.in);
			System.out.print("1.도서 추가 저장\n2.저장 도서 출력\n9.프로그램 끝내기\n메뉴번호 :");
			int cho=0;
			if(sc.hasNextInt()) {
				cho=Integer.parseInt(sc.nextLine());
			} else if( sc.hasNext()){
				
				sc.nextLine();
			}else {
				sc.reset();
				continue;
			}
	
			//System.out.println("while" + cho);
			switch (cho) {
				case 1 : fileSave(); break;
				case 2 : fileRead(); break;
				case 9 : System.out.println("프로그램 종료");run=false;break;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void fileSave() {
		
		System.out.print("도서명 :");
		String title=sc.nextLine();
//		sc.nextLine();
		System.out.print("저자명 :");
		String author=sc.nextLine();
		System.out.print("도서가격 :");
		int price=Integer.parseInt(sc.nextLine());
//		sc.nextLine();
		System.out.print("출판날짜(yyyy-mm-dd):");
		String date=sc.nextLine();
		String[] str=date.split("-");
		Calendar c=Calendar.getInstance();
		c.set(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]));
		System.out.print("할인율:");
		double discount=Double.parseDouble(sc.nextLine());
		Book b=new Book(title, author, price, c,discount);
				
		for(int i = 0; i <  bArr.length; i++) {
			if(bArr[i] == null) {
				bArr[i] = b;
				break;
			}else {
				continue;
			}
		}

		bc.fileSave(bArr);
		sc.close();
	}
	
	public void fileRead() {
		bArr=bc.fileRead();
		for(int i=0;i<bArr.length;i++) {
			if(bArr[i]!=null) {
		System.out.println(bArr[i]);}
	}
	
	}
}
