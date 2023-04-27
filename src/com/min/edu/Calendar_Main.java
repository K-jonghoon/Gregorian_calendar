package com.min.edu;

public class Calendar_Main {

	public static void main(String[] args) {
		
		Calendar_Method calM = new Calendar_Method();
		//System.out.println(calM.getDayOfMonth(2024, 2));
		
		//------------2024년까지의 윤년 갯수---------------
//		int yearSum = 0;
//		for (int i = 1; i <= 2024; i++) {
//			
//			if(calM.isCheckYear(i)) {
//				yearSum++;
//				
//			}
//		}
//		System.out.println(yearSum); // 496
		//------------- 윤년의 일수 ---------------------
//		int maxDays = 0;
//		int year = 2024;
//		for (int i = 1; i <= 12; i++) {
//			maxDays += calM.getDayOfMonth(year, i);
//		}
//		System.out.println(maxDays); // 윤년의 일수366
		//--------------------------------------------
		//TODO 문제 1 : 2024년 3월 1일 요일 구하기
//		>2024/03/01
//		> year : 1~2023 => A1+A2 = a 
//			- leap년도 * 366 = A1
//			- plain년도 * 365 = A2
//		> month : 입력받은 년도가 윤년인지 판단해야함 (true), 1~2월 =>b
//		> date(요일) : 1
//		> (a+b+1)%7 =>
		//--------------------------------------------
		//System.out.println(calM.isCheckYear(2024)); // true 윤년이다.
		
//		int a1 = 0;
//		int a2 = 0;
//		// 2023년까지의 윤년과 평년의 총합
//		for(int i = 1; i<2024; i++) {
//			if(calM.isCheckYear(i)) {
//				a1++; // 윤년의 총합
//			} else {
//				a2++; // 평년의 총합
//			}
//		}
//		int sumYear = (a1*366 + a2*365);
//		System.out.println("2023까지 총 일수 : "+ sumYear);
//		
//		int totalDate = sumYear + (31+29) + 1;
//		System.out.println("2024년3월1일까지 총 일수 : " + totalDate);
//		System.out.println("2024년3월1일 요일 : " + totalDate%7);
//		
		//----------------------------------------------
//		int totalDays = calM.calDays(2024, 4, 1);
//		switch (totalDays%7) {
//		case 0:System.out.println("일"); break;
//		case 1:System.out.println("월"); break;
//		case 2:System.out.println("화"); break;
//		case 3:System.out.println("수"); break;
//		case 4:System.out.println("목"); break;
//		case 5:System.out.println("금"); break;
//		case 6:System.out.println("토"); break;
//		}
//		System.out.println("해당 년도의 요일 " + (totalDays%7));
		for (int i = 1; i <=12; i++) {
			calM.print_Calender(2023, i);
			System.out.println("\n\n");
		}
		
		
	}

}
