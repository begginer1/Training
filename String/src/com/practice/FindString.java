package com.practice;

import java.util.ArrayList;
public class FindString {
		public static ArrayList<String> findPosition(String str[][],String find)
		{
			ArrayList ob=new ArrayList<String>();
			for(int i=0;i<str.length;i++)
			{
				for(int j=0;j<str[i].length;j++)
				{
					if(str[i][j].equalsIgnoreCase(find))
						ob.add(i+" "+j);
				}
			}
			return ob;
		}
	public static void main(String args[])
		{
		String str[][]=new String[][]{{"hello","hell","helloworld","hey"},{"cat","dog"},{"cat","Lion"}};
		ArrayList<String> ob=findPosition(str,"cat");
		System.out.println("Index of where string is Present");
	for(String i:ob)
		System.out.println(i);
		}
}
