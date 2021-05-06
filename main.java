package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class main {
	 

	// abba 
	// i = 1 
	// map cho  ghi de value voi truong hop  trug key 
	
	
	// xay dung cay Segment Tree (chua gia tri nho nhat  trong cua day so)
	 
	// 0 4
	// 0 2		3 4 
	// 0 1		2 2		 3 3		4 4
	// 0 0		1 1		2 2			3 3			4 4
	// buildTree(mang chua phan tu ban dau, tree xay dung, left, right, index cua nut  hien tai)
	private static void buildTree(int[] a, int[] segtree, int left, int right, int index) {
		if(left == right) {
			segtree[index] = a[left];
			return;
		}
		
		int mid = (left + right)/2;
		buildTree(a, segtree, left, mid, 2*index+1);
		buildTree(a, segtree, mid+1, right, 2*index+2);
		segtree[index] = Math.min(segtree[2*index+1], segtree[2*index+2]);
		
	}
	
	private static final int INF = (int)1e9;
	private static double log2(int number) {
		return Math.log(number) /  Math.log(2);
	}
	
	// ham tim gia tri nho nhat trong doan tu from den to
	private static 	int minRange(int [] segtree,  int left, int right, int from, int to, int index) {
		if(from <= left &&  to >= right) {
			return segtree[index];
		}
		
		if(from > right ||  to < left) {
			return INF;
		}
		
		int mid = (left + right)/2;
		int a = minRange(segtree, left, mid, from, to, 2*index+1);
		int b = minRange(segtree, mid+1, right, from, to, 2*index+2);
		return Math.min(a, b);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {5, -7, 9, 0, -2, 8, 3, 6, 4, 1};
		// tim gia tri trong doan 2 den 5 
		int n  = a.length;
	
		// tinh chieu cao cua cay 
		int h = (int)Math.ceil(n);
		
		// so nut toi da 
		int sizeTree = (int) (2*Math.pow(2, h) - 1);
		int[] segtree = new int[sizeTree];
		Arrays.fill(segtree, INF);
		// xay dung cay phan doan
		buildTree(a, segtree, 0, n-1, 0);
		
		int fromRange = 2;
		int toRange = 7;
		// tim gia tri nho nhat trong doan fromRange den  toRange
		int min = minRange(segtree, 0, n-1, fromRange, toRange, 0);
		System.out.printf("gia tri nho nhat trong doan tu 2 den 7: %d\n",  min);
		
		
		
		
		
		

	}

	
}
