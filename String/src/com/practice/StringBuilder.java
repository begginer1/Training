package com.practice;

public class StringBuilder {
public char[] str;
public StringBuilder()
{
	str=null;
}
public StringBuilder(String s)
{
	this.str=s.toCharArray();
}


public String append(String input)
{
	String ans;
	char temp[]=str;
	
	// total len previous + current
	int len=temp.length+input.length();
	
	// creating new Array to append
	str=new char[len];
	
	// copying previous data
	for(int i=0;i<temp.length;i++)
	str[i]=temp[i];
	// adding new  data
	for(int j=temp.length ;j<len;j++)
	str[j]=input.charAt(j-temp.length);
		ans=new String(str);
		
		return ans;
}

public String insert(String input,int index)
{
	String ans;
	char temp[]=str;
	int len=temp.length+input.length();
	str=new char[len];
	
	if(index>=str.length)
		ans=null;
	else if(index<0)
		ans=null;
	else if(input==null)
		ans= new String(str);
	
	else {
	for(int i=0;i<index;i++)
		str[i]=temp[i];
	
	// new string inserted
	for(int i=0;i<input.length();i++)
	{
		str[index+i]=input.charAt(i);
	}
	
	for(int i=index,j=0;i<temp.length;i++,j++)
	{
		str[index+input.length()+j]=temp[i];
	}
	
ans= new String(str);
	}
return ans;

}

public String delete(int startIndex,int endIndex)
{
	char temp[];
	String ans=null;
	// check if start and end index are between string
	if(startIndex==0||endIndex==str.length-1)
		ans="";
	else if(startIndex<0||endIndex>str.length||startIndex>endIndex)
		ans=null;
	else if((startIndex>=0&&startIndex<str.length)&& (endIndex>=0&&endIndex<str.length))
	{
		for(int i=0;i<str.length;i++)
		{
			if((endIndex+i+1)<str.length)
			str[startIndex+i]=str[endIndex+i+1];
			else
				break;
		}
		int  n=endIndex-startIndex+1; // No of Index we need to delete
		temp=new char[str.length-n];
		for(int i=0;i<temp.length;i++)
		temp[i]=str[i];
		ans=new String(temp);
	}
	
	
return ans;
}

public String getString()
{
	return new String(str);
}

public static void main(String args[])
{ 
	StringBuilder ob=new StringBuilder("HelloWorld");
	System.out.println(ob.append("Everyone"));
	String s=ob.insert( "Java",5);
	if(s==null)
	{
		System.out.println("Wrong Input");
	}
	else
		System.out.println(s);
	s=ob.delete(5,13);
	if(s==null)
	{
		System.out.println("Wrong Input");
	}
	else
		System.out.println(s);
	
}
}
