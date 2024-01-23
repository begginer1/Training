package com.practice;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		Pattern pattern=Pattern.compile("[a-z]+[0-9]*@gmail.com");
		Matcher m=pattern.matcher(s);
		if(m.matches())
			System.out.println("Email is Valid");
		else
			System.out.println("Email is not Valid");
		
	}
}
