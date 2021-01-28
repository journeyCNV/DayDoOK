package dayDo;
/**
 * 日期
 */
import java.util.Calendar;

public class DayDoDate {
	
	Calendar cal = Calendar.getInstance();
	
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	int nextDay;
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public String[][] getCalendar(){
		String a[][] = new String[6][7];
		cal.set(year, month-1,1);
		int whichDofW = cal.get(Calendar.DAY_OF_WEEK)-1;
		int day = 0;
		
		//判断一个月有多少天
		int[] mon1= {1,3,5,7,8,10,12};
		int[] mon2= {4,6,9,11};
		if(java.util.Arrays.binarySearch(mon1, month)>=0){
			day = 31;
		}
		else if(java.util.Arrays.binarySearch(mon2, month)>=0) {
			day = 30;
		}
		else if(((year%4==0)&&(year%100!=0))||(year%400==0)) {
			day = 29;
		}else {
			day = 28;
		}
		
		//二维数组依次排序
		nextDay = 1;
		for(int k = 0;k < 6;k++) {
			if(k == 0) {
				for(int j = whichDofW;j<7;j++) {
					a[k][j]=" "+nextDay;
					nextDay++;
				}
			}else {
				for(int j=0;j<7&&nextDay<=day;j++) {
					a[k][j]=" "+nextDay;
					nextDay++;
				}
			}
		}
		
		return a;
	}
	
}
