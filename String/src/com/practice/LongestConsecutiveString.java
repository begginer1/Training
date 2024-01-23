package com.practice;

public class LongestConsecutiveString {

public static String longestPrefix(String s1,String s2)
{
	String ans="";
	int mn=Math.min(s1.length(), s2.length());
	for(int i=0;i<mn;i++)
	{
		if(s1.charAt(i)==s2.charAt(i))
			ans+=s1.charAt(i);
		else
			break;
	}
	return ans;
}

public static void main(String args[])
{
	String arr[][]=new String[][]{{"hello","hell"},{"helloworld","hey"}};
	String ans=arr[0][0];
	for(int i=0;i<arr.length;i++)
	{
		for(int j=0;j<arr[i].length;j++)
			ans=longestPrefix(ans,arr[i][j]);
	}
	System.out.println("LongestPrefix: "+ans);
}
}
