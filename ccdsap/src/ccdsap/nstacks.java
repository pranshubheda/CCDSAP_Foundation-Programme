package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class nstacks {
static class  inp{
	BufferedReader br;
	StringTokenizer st;
	InputStreamReader isr=new InputStreamReader(System.in);
	inp()
	{
		br=new BufferedReader(isr);
	}
	String next()
	{
		while(st==null||!st.hasMoreElements())
		{
			try {
				st=new StringTokenizer(br.readLine());
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}
	long nextLong()
	{
		return Long.parseLong(next());
	}
	int nextInt()
	{
		return Integer.parseInt(next());
	}
}
static long st[],nstk=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inp in=new inp();
		int t=in.nextInt();
		while(t-->0)
		{
			int n=in.nextInt();
			st=new long[n+1];
			long elements[]=new long[n];
			for(int i=0;i<n;i++)
				elements[i]=in.nextLong();
			nstk=0;
			for(int i=0;i<n;i++)
			{
				nstk=bs(nstk,elements[i]);
			}
			System.out.print(nstk+" ");
			for(int i=0;i<nstk;i++)
				System.out.print(st[i]+" ");
			System.out.println();
		}
	}
	static long bs(long size,long element)
	{
		int l=0,h=(int)size-1,mid;
		while(l<=h)
		{
			 mid=(l+h)/2;
			 if(st[mid]>element)
			 {
				 h=mid-1;
			 }
			 else
				 l=mid+1;
		}
		if(l==size)
			size++;
		st[l]=element;
		return size;
	}
 
}