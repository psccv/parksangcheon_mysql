package kr.or.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Tire{
	public void run() {
		System.out.println("일반 타이어가 굴러갑니다.");
	}
}
class SnowTire extends Tire{
	@Override
	public void run() {
		System.out.println("스노우 타이어가 굴러갑니다.");
	}
}

public class HelloWorld {

	public static void main(String[] args) {
		int startBno = (1 - 1) * 10;
		System.out.println("쿼리변수 (1page - 1) * perPageNum = " + startBno);
		startBno = (2 - 1) * 10;
		System.out.println("쿼리변수 (2page - 1) * perPageNum = " + startBno);
		startBno = (3 - 1) * 10;
		System.out.println("쿼리변수 (3page - 1) * perPageNum = " + startBno);
		//천장함수 사용법
		int endPage = (int)Math.ceil((1/10.0)*10);
		System.out.println("Math.ceil((1page/10.0)*10) = " + endPage);
		endPage = (int)Math.ceil((2/10.0)*10);
		System.out.println("Math.ceil((2page/10.0)*10) = " + endPage);
		endPage = (int)Math.ceil((3/10.0)*10);
		System.out.println("Math.ceil((3page/10.0)*10) = " + endPage);
		
		/*List<String> files = new ArrayList<>();
		
		files.add("샘플1.jpg");
		files.add("샘플2.jpg");
		files.add("샘플3.jpg");
		
		String[] fileNames = new String[files.size()];
		
		int cnt = 0;
		
		for(String fileName : files) {
			fileNames[cnt++] = fileName;
		}
		System.out.println(fileNames[0]);
		System.out.println(fileNames[1]);
		System.out.println(fileNames[2]);*/
		
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;
		tire.run();
		
		
/*		System.out.println(" Hello World !");
		int score=85;
		String result=(!(score>90))?"가":"나";
		System.out.println(result);
		if(!(score>90)) {
			result ="가";
		}else {
			result ="나";
		}
		System.out.println(result);
		int x =10;
		int y =5;
		System.out.println((x>7)&&(y<=5));
		System.out.println((x<7)&&(y<=5));
		System.out.println((x<7)||(y<=5));*/
		
	/*	int sum=0;
		
		for(int i=1; i<=100;i++) {
			sum=sum+i;
		}
		int cnt=1;
		while(cnt<=100) {
			sum=sum+cnt;
			cnt=cnt+1;
		}
		System.out.println("1부터100까지의 합은 : "+sum+" 입니다");*/
		/*boolean run=true;
		int balance=0;
		Scanner scanner=new Scanner(System.in);
		
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1.예금|2.출금|3.잔고|4.종료");
			System.out.println("------------------------------");
			System.out.print("선택> ");
			
			String menuNum=scanner.next();
			
			switch (menuNum) {
			case "1":
				System.out.print("예금액> ");
				balance+=scanner.nextInt();
				break;
			case "2":
				System.out.print("출금액> ");
				if(balance>=scanner.nextInt()) {
					balance-=scanner.nextInt();
				}else {
					System.out.println("출금액이 예금액보다 많습니다.");
				}
				
				break;
			case "3":
				System.out.print("잔고> ");
				System.out.print(balance+"원");
				break;
			case "4":
				run=false;
				break;
			 default :
				 System.out.print("다시 입력해주세요. ");
				 break;
			}
			System.out.println();
		}
		System.out.println("프로그램 종료");*/
	}
}
