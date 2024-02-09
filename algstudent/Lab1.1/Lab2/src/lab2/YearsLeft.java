package lab2;

import java.util.Date;

public class YearsLeft {

	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		long max = Long.MAX_VALUE;
		long left = max - now;
		Date date = new Date(max);
		System.out.println(date);
		long secs = left/1000;
		long hours = secs/3600;
		long days = hours/24;
		long years = days/365;
		
		System.out.println(years);
	}

}
