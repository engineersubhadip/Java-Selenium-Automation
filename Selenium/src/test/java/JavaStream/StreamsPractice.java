package JavaStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsPractice {
	
	static void filterEven() {
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
		
		list.stream().filter(currEle -> currEle % 2 == 0).collect(Collectors.toList()).forEach(currEle -> System.out.println(currEle));
	}
	
//	Given a list of integers, find out all the numbers starting with 1 using Stream functions?
	
	static void NumberStartingWithOne() {
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
		
		list.stream().map(currEle -> currEle+"").filter(currEle -> currEle.charAt(0)=='1').forEach(currEle -> System.out.println(Integer.parseInt(currEle)));
	}
	
//	How to find duplicate elements in a given integers list in java using Stream functions?
	
	static void DuplicateElements() {
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
		
		list.stream().collect(Collectors.groupingBy(currEle -> currEle, Collectors.counting())).entrySet().stream().filter(currEle -> currEle.getValue()>1).collect(Collectors.toList()).forEach(currEle -> System.out.println(currEle.getKey()));
	}
	
//	Given the list of integers, find the first element of the list using Stream functions?
	
	static void FindFirstElement() {
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		
		myList.stream().limit(1).forEach(currEle -> System.out.println(currEle));
	}
	
//	Given a list of integers, find the total number of elements present in the list using Stream functions?
	
	static void FindTheTotalNumberOfElements() {
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		
		Long count =  myList.stream().count();
		System.out.println("Total Elements present "+count);
	}
	
//	Given a list of integers, find the maximum value element present in it using Stream functions?
	
	static void FindMaxElement() {
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		
		Integer maxEle = myList.stream().max(Integer :: compare).get();
		
		System.out.println("The max Ele "+maxEle);
	}

//	Given a String, find the first non-repeated character in it using Stream functions?
	
	static void FirstNonRepeated() {
		
	}
	
//	FOR MORE  :- https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
	
	
	public static void main(String[] args) {

//		Filter out the even numbers in the array and print them
		
		filterEven();
		
//		//	Given a list of integers, find out all the numbers starting with 1 using Stream functions?
		System.out.println("--------------");
		NumberStartingWithOne();
		
//		How to find duplicate elements in a given integers list in java using Stream functions?
		System.out.println("----------------");
		DuplicateElements();
		
		System.out.println("----------------");
		FindFirstElement();
		
		System.out.println("-------------------");
		FindTheTotalNumberOfElements();
		
		System.out.println("----------------");
		FindMaxElement();
	}

}
