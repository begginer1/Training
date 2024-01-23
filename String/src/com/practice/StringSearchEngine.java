package com.practice;
import java.util.ArrayList;

public class StringSearchEngine {
String text;
public StringSearchEngine(String text)
{
	this.text=text;
}

		public  ArrayList<Integer> findPosition(String pattern)
		{
			ArrayList ob=new ArrayList<Integer>();
			for(int i=0;i<text.length();i++)
			{int j=0;
				for(;j<pattern.length();j++)
				{
					if(text.charAt(i)==pattern.charAt(j))
						i++;
					else
						break;
				}
				if(j==pattern.length()) {
					ob.add(i-pattern.length());
					i-=1;
			}
			}
			return ob;
		}
	public static void main(String args[])
		{
		
		StringSearchEngine obj=new StringSearchEngine("The sample text for this case is this");
		String pattern="th";
		ArrayList<Integer> list=obj.findPosition(pattern);//Function is case Sensitive so t and T are different
		System.out.println("Index in which pattern exists");
	for(Integer i:list)
		System.out.println(i.intValue());
		}


}
