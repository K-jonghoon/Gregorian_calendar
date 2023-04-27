package com.min.edu.calender;

public class Calendar2_Method {

	private final int[] LEAP = {31,29,31,30,31,30,31,31,30,31,30,31};
	private final int[] PLAIN = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public boolean isCheckYear(int year) {
		boolean isc = false;
		if(year%4==0 && year%100!=0 || year%400==0) {
			isc = true;
		}
		return isc;
	}
	
	public int getDayOfMonth(int year, int month) {
		int result = 0;
		if(isCheckYear(year)) {
			result = LEAP[month-1];
		} else {
			result = PLAIN[month-1];
		}
		return result;
	}	
		
	// 1~2023년까지 총 누적 일수
	public int calDays(int year) {
		int day = 0;
		for (int i = 1; i < year; i++) {
			if(isCheckYear(i)) { // 조건문 : 윤년이라면
				day += 366;
			}else { // 윤년 아니라면
				day += 365;
			}
		}
		return day;
	}	
	
	// 1.1~2023.12 총 누적일수 + 1~3월까지 총 누적 일수
	public int calDays(int year, int month) {
		int dayTot = calDays(year);
		
		for (int i = 1; i < month; i++) { // 누적 월 일수
			if(isCheckYear(year)) {
				dayTot += LEAP[i-1];
			} else {
				dayTot += PLAIN[i-1];
			}
		}
		return dayTot;
	}
	
	// 1.1~2023.12 총 누적일수 + 1~3월까지 총 누적 일수 +date 까지의 총 누적일수
	public int calDays(int year, int month, int date) {
		int dayResult = calDays(year, month);
		dayResult += date;
		return dayResult;
	}
	
	//전달의 최대 일수 - 현재달력의 dayOfWeek
//	 -> 2월이면 1월
//	 -> 12월이면 11월
//	 -> 1월이면 이전년도의 12월
	//(dayOfWeek + getDayOfMonth)%7 이후 나머지를 출력
	
	public void print(int year, int month) {
		System.out.printf("\t\t%d년도%d월\n",year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int dayOfWeek = (calDays(year, month, 1)+1-1)%7;
		
		int dayOfMonth = getDayOfMonth(year, month);
		
		for(int i = 1; i<= dayOfWeek; i++) {
			
			System.out.print("\t");
			
		}
		for(int i = 1; i<= dayOfMonth; i++) {
			System.out.printf("%d\t",i);
			if((dayOfWeek+i)%7==0) {
				System.out.println();
			}
		}
		for(int i = 1; i< 7-dayOfWeek ; i++) {
			System.out.print(i+"\t");
		}
	}
}
