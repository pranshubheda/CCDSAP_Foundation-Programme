package ccdsap;

import java.util.*;
class Stacks
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t,i,j,ans,mid,n,p,temp,low,high;
		t=sc.nextInt();
		while(t-->0)
		{
			n=sc.nextInt();p=0;
			int a[]=new int[n];
			int b[]=new int [n];
			for(i=0;i<n;i++)
				a[i]=sc.nextInt();
			b[0]=a[0];
			p++;
			for(j=1;j<n;j++)
			{
				temp=a[j];ans=p;
				low=0;high=p-1;
				while(low<=high)
				{
					mid=(low+high)/2;
					if(temp<b[mid])
					{
						high=mid-1;
						ans=mid;
					}
					else 
						low=mid+1;
				}
 
				b[ans]=temp;
				if(ans==p)
					p++;
			}
			System.out.print(p+" ");
			for(i=0;i<p;i++)
				System.out.print(b[i]+" ");
			System.out.println();
		}
	}
} 