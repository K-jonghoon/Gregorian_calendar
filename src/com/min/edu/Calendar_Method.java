package com.min.edu;
/**
 * 대중적으로 사용하는 그레고리안력을 분석하여 메소드로 구성된 만년 달력을 만들어보자
 * 1.년도/월 을 입력하면 해당년도/월의 달력이 console에 출력되도록 만든다
 * 2.년도를 입력하면 1년 달력이 모두 출력된다.
 * 
 * @author SAMSUNG
 * @version 10
 *
 */
public class Calendar_Method {

	/**
	 * 각 월의 최대 일 수는 고정값으로 되어 있음, 따라서 초기값으로 설정
	 */
	// final int a = 10; 인 경우 값을 저장       값을 저장하는 예약어이지만 객체에 적용하면 주소를 고정
	// final A b = new A(); 인 경우 주소를 저장
	private final int[] LEAP = {31,29,31,30,31,30,31,31,30,31,30,31};
	private final int[] PLAIN = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	/**
	 * 입력된 년도의 윤년 여부를 확인하는 메소드
	 * 윤년 : 4년에 한번이면서, 100의 배수 년도는 아니다. 400의 배수 년도는 윤년이다.
	 * @param 판단하고자 하는 년도
	 * @return 윤년인 경우 true, 평년은 false
	 */
	public boolean isCheckYear(int year) {
		boolean isc = false;
		
		if ((year%4==0 && year%100!=0) ||year%400==0) { // 4년에 한번이면서, 100의 배수 년도는 아니다. 400의 배수 년도는 윤년이다.
			isc = true;
		}
		
		return isc;
	}
	/**
	 * 입력받은 년도와 월의 최대 일수를 반환해주는 메소드
	 * @param year 입력 년도
	 * @param month 입력 월
	 * @return LEAP/PLAIN의 값
	 */
	public int getDayOfMonth(int year, int month) {
		int days = 0;
		
		if(isCheckYear(year)) {
			
			days = LEAP[month - 1];
		}else {
			days = PLAIN[month -1];
		}
		
		return days;
	}//getDay
	
	/**
	 * 입력받은 년도 미만까지의 년도를 윤년 판단하여
	 * 윤년은 366 / 평년는 365 더하여 누적값을 반환하는 메소드
	 * @param year 구하고자 하는 년도
	 * @return year 전까지의 총 일수
	 */
	public int calDays(int year) {
		int days=0;
		for (int i = 1; i < year; i++) {
			if(isCheckYear(i)) {
				days += 366;
			} else {
				days += 365;
			}
		}
		return days;
	}
	
	//오버로딩 : 메소드명은 같지만 argument타입만 다르면 다른 형태는 모두 오버로딩임
	/**
	 * 해당년도의 입력 월 미만까지의 각월의 최대 일 수는 누적
	 * @param year 월의 윤년판단 값
	 * @param month 누적해야할 1월부터 해당 월 전까지 기준 월
	 * @return 년도 누적 + 월 누적 일 수 
	 */
	public int calDays(int year, int month) {
		int days = calDays(year);
		for (int i = 1; i < month; i++) {
			if(isCheckYear(year)) {
				days += LEAP[i-1];
			} else {
				days += PLAIN[i-1];
			}
		}
		return days;
	}
   
	/**
	 * 년도 월 일을 누적하여 해당 년도/월/일의 총 일수를 반환하는 메소드
	 * @param year 해당 년도
	 * @param month 해당 월
	 * @param date 해당 일
	 * @return year month date의 총 일수 
	 */
	public int calDays(int year, int month, int date) {
		int days = calDays(year, month);
		days += date;
		return days;
	}
	
	public void print_Calender(int year, int month) {
		System.out.printf("\t\t%d년도\t%d월\n",year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int dayOfWeek = (calDays(year, month, 1) +1 -1)%7;// 0 // 다음달 1일까지 구한 다음 -1 하여 출력, 1년 1월 1일 월요일 시작이므로 +1
						// (   (365+31+28+1)     +1-1)%7   // 해당 년 월 일의 전달의 마지막 요일
						//   getDayOfMonth();									
		int dayOfMonth = getDayOfMonth(year, month); //31
		
		//int beforeDayOfMonth = getDayOfMonth(year, month-1);
		int beforeDayOfMonth = getDayOfMonthCheck(year,month); //31
		
		int beforeStart = beforeDayOfMonth - dayOfWeek + 1; // 32
		
		for (int i = beforeStart; i <= beforeDayOfMonth; i++) {
			System.out.printf("%d\t", i); // 31
		}
		
//		for (int i = 0; i < dayOfWeek; i++) {
//			System.out.print("-\t");
//		} // 이전 달력의 공백
		
		for (int i = 1; i <= dayOfMonth; i++) {
			System.out.printf("%d\t",i);
			if((dayOfWeek+i)%7==0) {
				System.out.println();
			}
		} //  달력 일수
		
		int afterDays = (7-(dayOfWeek + dayOfMonth)%7)%7;
		// 23년 9월 달력에서 10월의 1234567 출력하지 않는 방법
		for(int i = 1; i<=afterDays; i++) {
			System.out.printf("%d\t", i); // 1 2 3 4
		}
	}
	/**
	 * 입력받은 월이 1월이라면 index를 벗어나게 된다
	 * 따라서 1월이라면 year-1 , month를 12월로 고정
	 * 아니라면 year에 month-1로 값을 변경하여
	 * getDayOfMonth(int,int)를 호출하여 값을 리턴해줄것입니다.
	 * @param year
	 * @param month
	 * @return
	 */
	private int getDayOfMonthCheck(int year, int month) {
		int resultDate = 0;
		if(month==1) {
			resultDate = getDayOfMonth(year-1,12); //31
		}else {
			resultDate = getDayOfMonth(year, month-1);
		}
		return resultDate; //31
	}
}
