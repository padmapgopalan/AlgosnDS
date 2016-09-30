package com.ppg;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Has static functions. getRandomIntegers returns M random unique number with upper bound N. 
 * getRandomElements returns M random array elements
 * largestInCircularArray returns the largest element in a circular sorted array 
 * searchInCircularArray searches for a number in a circular array
 * printTwoNodesMatchingSuminBST Print two adjoacent nodes out of three in a BST that matches a given sum
 */
public class NumberUtilts {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("getRandomIntegers 8 numbers with 70 as upper bound");
		 */
		/*
		Set<Integer> outArray = getRandomIntegers(8, 70);
		for (Integer j:outArray)
			System.out.println(j);

		System.out.println("getRandomIntegers 70 numbers with 8 as upper bound");
		//getRandomIntegers(70, 8);
		
		Integer [] inputArray = {45,67,89,55,68,99,0,1,2};
		Object [] outArr = getRandomElements(inputArray, 3);
		for (Object x : outArr)
			System.out.println(x);
		
		*/
		
		/*
		int [] inArray = {7};
		System.out.println(largestInCircularArray(inArray));		
		
		int [] inputArray0 = {0, 1, 2, 45, 55, 67, 68, 89 ,99};		
		System.out.println(largestInCircularArray(inputArray0, 0, 8, 1));
		
		int [] inputArray2 = {45, 55, 67, 68, 89 ,99, 0, 1, 2};
		System.out.println(largestInCircularArray(inputArray2, 0, 8, 1));
		
		int [] inputArray3 = {68, 89 ,99, 0, 1, 2, 45, 55, 67};
		System.out.println(largestInCircularArray(inputArray3, 0, 8, 1));

		
		int [] inputArray4 = {0, 1, 2, 45, 55, 67, 68, 89 ,99, 110};		
		System.out.println(largestInCircularArray(inputArray4, 0, 9, 1));
		
		int [] inputArray5 = {45, 55, 67, 68, 89 ,99, 110, 0, 1, 2};
		System.out.println(largestInCircularArray(inputArray5, 0, 9, 1));
		
		int [] inputArray6 = {68, 89 ,99, 110, 0, 1, 2, 45, 55, 67};
		System.out.println(largestInCircularArray(inputArray6, 0, 9, 1));
		
		int [] inputArray7 = {67, 68, 89 ,99, 110, 0, 1, 2, 45, 55};
		System.out.println(largestInCircularArray(inputArray7, 0, 9, 1));
		
		*/
		
		/*
	
		int [] inputArray8 = {0, 1, 2, 45, 55, 67, 68, 89 ,99, 110};		
		System.out.println(searchInCircularArray(inputArray8, 45));
		
		int [] inputArray9 = {45, 55, 67, 68, 89 ,99, 110, 0, 1, 2};
		System.out.println(searchInCircularArray(inputArray9, 45));
		
		int [] inputArray10 = {68, 89 ,99, 110, 0, 1, 2, 45, 55, 67};
		System.out.println(searchInCircularArray(inputArray10, 45));
		
		int [] inputArray11 = {67, 68, 89 ,99, 110, 0, 1, 2, 45, 55};
		System.out.println(searchInCircularArray(inputArray11, 55));
		
		int [] inputArray11a = {67, 68, 89 ,99, 110, 0, 1, 2, 45, 55};
		System.out.println(searchInCircularArray(inputArray11a, 4));
		*/
		
		
		/*
		int [] inputArray12 = {0, 1,1, 2, 45, 55, 67, 68, 89 ,99, 110};		
		printTwoNodesMatchingSuminBST(inputArray12, 209);
		*/
	}

	/**
	 * Generated M random unique integers less than N. Uses a set to ensure unqueness
	 * @param M
	 * @param N
	 * @return
	 * @throws Exception
	 */
	public static Set<Integer> getRandomIntegers(int M, int N) throws Exception{
		Random randomNumber = new Random(9);
		if (M>N)
			throw new Exception("No of random numbers to be generated M cannot be greater than the Boundary N");
		Set<Integer> randomIntSet = new HashSet<>();
		while(randomIntSet.size() < M){
			randomIntSet.add(randomNumber.nextInt(N));
		}
		return randomIntSet;
		
	}
	
	/**
	 * Return M random array elements
	 * @param inputArray
	 * @param M
	 * @return
	 * @throws Exception
	 */
	public static Object[] getRandomElements( Object[] inputArray, int M) throws Exception{
		if (inputArray == null)
			return  null;
		
		
		Set<Integer> outArray = getRandomIntegers(M, inputArray.length);
		Object[] outObjectArray = new Object[M];
		
		int i = 0;
		for (Integer j:outArray) {
			outObjectArray[i++] = inputArray[j];
		}
		return outObjectArray;
		
	}
		

	/**
	 * Returns if a number is found in a sorted array
	 * @param integerlist
	 * @param startPos
	 * @param endPos
	 * @param noToSearch
	 * @return
	 */
	private static boolean binarySearch(int[] integerlist, int startPos, int endPos, int noToSearch){
		/*
		 * 
		 * int [] inputArray = {0, 1, 2, 45, 55, 67, 68, 89 ,99};
		System.out.println(binarySearch(inputArray, 0, 8, 46));
		*/
		//System.out.println("bitn " + ": startPos:" + startPos + ", endPos:" + endPos);

		if (startPos > endPos)
			return false;
		int pos = (startPos + endPos)/2;
		int elementAtPos = integerlist[pos];
		if (noToSearch == elementAtPos)
			return true;
		
		if (noToSearch < elementAtPos){
			endPos = pos - 1;
		}else{
			startPos = pos + 1;
		}
		if (binarySearch(integerlist,startPos,endPos, noToSearch))
			return true;
			
		
		return false;
	}
	
	/**
	 * Returns the largest element in a sorted array that is pivoted
	 * @param integerlist
	 * @return the largest number
	 * @throws Exception
	 */
	public static int largestInCircularArray(int[] integerlist) throws Exception{
		if (integerlist == null || integerlist.length == 0)
			throw new Exception("Input needs to be an array of integers: Cannot be null or size zero");
				
		return largestInCircularArray(integerlist, 0, integerlist.length - 1, 1);
	}

		
	private static int largestInCircularArray(int[] integerlist, int startPos, int endPos, int z){
		//System.out.println("itn " + z++ + ": startPos:" + startPos + ", endPos:" + endPos);

		if (startPos == endPos)
			return integerlist[startPos];
		if ((startPos + 1) == endPos)
			return Math.max(integerlist[startPos], integerlist[endPos]);
		int midPos = (startPos + endPos)/2;
		int middleNo = integerlist[midPos];
		int middleNoPlusOne = integerlist[midPos + 1];
		int startNo = integerlist[startPos];
		int endNo = integerlist[endPos];
		
		if (middleNo > middleNoPlusOne)
			return middleNo;
		boolean secondHalf = false;
		if (middleNo >= startNo)
			secondHalf = true;
		
		
		if (secondHalf)
			return largestInCircularArray(integerlist, midPos + 1,  endPos, z);
		else
			return largestInCircularArray(integerlist,  startPos, midPos, z);		
		
	}

	/**
	 * Returns true if searchNo is found in a sorted circular array; else false
	 * @param integerlist
	 * @param searchNo
	 * @return
	 */
	public static boolean searchInCircularArray(int[] integerlist,  int searchNo){
		if (integerlist == null || integerlist.length == 0)
			return false;
		return searchInCircularArray(integerlist, 0, integerlist.length - 1, 1,  searchNo);
	}

		
	private static boolean searchInCircularArray(int[] integerlist, int startPos, int endPos, int z, int searchNo){
		//System.out.println("citn " + z++ + ": startPos:" + startPos + ", endPos:" + endPos);

		if (startPos > endPos)
			return false;
		
		int startNo = integerlist[startPos];
		int endNo = integerlist[endPos];
		
		
		if (startNo < endNo)
			return binarySearch(integerlist, startPos, endPos, searchNo);
		
		int midPos = (startPos + endPos)/2;
		int middleNo = integerlist[midPos];
		if (middleNo == searchNo)
			return true;
		
		
		
		boolean pivotInSecondHalf = false;
		if (middleNo >= startNo)
			pivotInSecondHalf = true;
		
		
		if (pivotInSecondHalf){
			if (searchNo < middleNo && searchNo >= startNo){
				return binarySearch(integerlist, startPos, midPos - 1, searchNo);
			}else{
				return searchInCircularArray(integerlist,  midPos + 1, endPos, z, searchNo);
			}
		}
		else {
			if (searchNo > middleNo && searchNo <= endNo){
				return binarySearch(integerlist, midPos + 1, endPos, searchNo);
			}else{
				return searchInCircularArray(integerlist, startPos,  midPos - 1, z, searchNo);
			}
		}
		
		
	}
	
	
	/**
	 * Prints all 2 out of three adjacent nodes that sum up to a given number in a BST
	 * @param bst
	 * @param sum
	 */
	public static void printTwoNodesMatchingSuminBST(int[] bst, int sum){
		
		int arrLength = bst.length;
		
		if (arrLength < 3) {
			if ((bst[0] + bst[1]) == sum){
				System.out.println(bst[0] + " " + bst[1]);
				return;
			}
		}
		for (int i=0; i<arrLength-2; i++){
			int lookForVal = sum - bst[i];
			if (lookForVal <= 0){
				return;
			}
			
			if (lookForVal == bst[i+1]) {
				System.out.println(bst[i] + " " + bst[i+1]);
			}
			
			if (lookForVal == bst[i+2]) {
				System.out.println(bst[i] + " " + bst[i+2]);
			}
		}
		
		if ((bst[arrLength -2 ] + bst[arrLength - 1]) == sum){
			System.out.println(bst[arrLength -1] + " " + bst[arrLength -2]);
			return;
		}
	}
	
}
