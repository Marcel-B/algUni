package de.marcel.uni;

public class SortAlgs {
	public static void showArray(double[] S){
		for(int i = 0; i < S.length - 1; i++)
			System.out.print(S[i] + " - ");
		System.out.println(S[S.length - 1]);
		
	}
	private static void swap(double[] S, int n, int m){
		showArray(S);
		double tmp = S[n];
		S[n] = S[m];
		S[m] = tmp;
		showArray(S);
		System.out.println("============================================");
	}
	
	private static int findx(double[] S, int i, int j){
		int k = i + 1;
		System.out.println("findx(S, " + i + ", " + j + ")");
		while(k <= j && S[k] == S[k-1])
			k++;
		System.out.println("if(" +k+ " > " + j+")");
		System.out.println("else if(" +S[k-1] + " < " +S[k]+ ")"); 
		System.out.println("else " + (k-1));
		if(k>j)	
			k = -1;		
		else if(S[k-1] < S[k])			
		  k = k;			
		else
			 k--;		
		System.out.println("New Index = " + k);
		return k;
	}
	
	private static int partition(double[] S, int i, int j, double x){
		System.out.println("partition(s, i, j, x)");
		System.out.println("i = " + i);
		System.out.println("j = " + j);
		System.out.println("x = " + x);
		int l = i;
		int r = j;
		System.out.println("start l = " + l);
		System.out.println("start r = " + r);
		while(l < r){
			while(S[l] < x)
				l++;
			while(!(S[r] < x))
				r--;
			if(l<r)
				swap(S, l, r);
		}
		System.out.println("ende l = " + l);
		System.out.println("ende r = " + r);
		return l;
	}
	
	private static void quickSort(double[] S, int i, int j){
		int k;
		int xindex;
		if(i < j){
			xindex = findx(S, i, j);
			if(xindex != -1){
				k = partition(S, i, j, S[xindex]);
				System.out.println("k = " + k);
				System.out.println("i = " + i);
				System.out.println("j = " + j);
				System.out.println("S[" + xindex + "] = " + S[xindex]);
					
				System.out.println("quickSort1(S, i, k-1)");
				
				quickSort(S, i, k-1);
				System.out.println("quickSort2(S, k, j)");
				quickSort(S, k, j);				
			}
		}
	}
	
	public static void quickSort(double[] S){
		quickSort(S, 0, S.length-1);
	}
}
