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
			System.out.print("1.���� �߰� ����\n2.���� ���� ���\n9.���α׷� ������\n�޴���ȣ :");
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
				case 9 : System.out.println("���α׷� ����");run=false;break;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void fileSave() {
		
		System.out.print("������ :");
		String title=sc.nextLine();
//		sc.nextLine();
		System.out.print("���ڸ� :");
		String author=sc.nextLine();
		System.out.print("�������� :");
		int price=Integer.parseInt(sc.nextLine());
//		sc.nextLine();
		System.out.print("���ǳ�¥(yyyy-mm-dd):");
		String date=sc.nextLine();
		String[] str=date.split("-");
		Calendar c=Calendar.getInstance();
		c.set(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]));
		System.out.print("������:");
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
