package com.min.edu.calender;

public class Calender2_Main {

	public static void main(String[] args) {
	
		Calendar2_Method CM = new Calendar2_Method();
		
//		int yearSum = 0;
//		for (int i = 1; i <= 2024; i++) {
//			
//			if(CM.isCheckYear(i)) {
//				yearSum++;
//				
//			}
//		}
//		System.out.println(yearSum); // 491
		//-----------------------------------------
//		int dayMax = 0;
//		int year = 2024;
//		for(int i = 1; i <= 12; i++) {
//			dayMax += CM.getDayOfMonth(year, i);
//		}
//		System.out.println(dayMax); // 366
		//-----------------------------------------
		// 윤년과 평년의 각각의 합을 구한다
//		int daySum1 = 0;
//		int daySum2 = 0;
//		int year =2024;
//		for(int i = 0; i < year; i++) {
//			
//			if(CM.isCheckYear(i)) {
//				daySum1++; 
//			} else {
//				daySum2++; 
//			}
//			
//		}
//		int dayTotal = (daySum1*366) + (daySum2*365);
//		System.out.println(dayTotal);
//		CM.print(2024, 4);
		int total = CM.calDays(2024, 4, 1);
		switch (total%7) {
		case 0:	System.out.println("일"); break;
		case 1: System.out.println("월"); break; 
		case 2:	System.out.println("화"); break; 
		case 3: System.out.println("수"); break; 
		case 4:	System.out.println("목"); break; 
		case 5: System.out.println("금"); break; 
		case 6: System.out.println("토"); break; 
		}
		System.out.println("해당 년도의 요일 " + (total%7));
		CM.print(2024, 4);
	}
		
}
