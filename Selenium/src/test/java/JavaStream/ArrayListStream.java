package JavaStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.Assert;

import com.google.common.collect.Streams;

class customComparator implements Comparator<Map.Entry<Integer, Long>> {
	public int compare(Map.Entry<Integer, Long> e1, Map.Entry<Integer, Long> e2) {
		return e1.getKey().compareTo(e2.getKey());
	}
}

public class ArrayListStream {
	
	public static void streamFilter() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Rakulpreet");
		names.add("Xiu");
		names.add("Adam");
		names.add("Alekhya");
		
		Long count = names.stream().filter(currName -> currName.charAt(0) == 'A').count();
		
		System.out.println(count);
	}
	
	public static void streamPrint() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Rakulpreet");
		names.add("Xiu");
		names.add("Adam");
		names.add("Alekhya");	
		
//		names.stream().filter(currName -> currName.charAt(0)=='A').forEach(currName -> System.out.println(currName));
		
		names.stream().filter(currName -> currName.length() > 4).limit(1).forEach(currName -> System.out.println(currName));
		
	}
	
	public static void streamMap() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Rakulpreet");
		names.add("Xiu");
		names.add("Adam");
		names.add("Alekhya");
		
//		Print Names in UpperCase which ends with "t"
		
		names.stream().filter(currName -> currName.endsWith("t")).map(currName -> currName.toUpperCase()).forEach(currName -> System.out.println(currName));
	}
	
	public static void streamFreqMap() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Rakulpreet");
		names.add("Xiu");
		names.add("Adam");
		names.add("Abhijeet");
		
		names.stream().collect(Collectors.groupingBy(currName -> currName, Collectors.counting())).entrySet().stream().forEach(currEle -> System.out.println("Key "+currEle.getKey()+" Value "+currEle.getValue()));
	}

	public static void streamSorting() {
//		Print the names with first letter as "a" and in sorted Manner
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Rakulpreet");
		names.add("Xiu");
		names.add("Adam");
		names.add("Alekhya");
		
		names.stream().filter(currName -> currName.charAt(0)=='A' && currName.length() > 4).sorted().forEach(currName -> System.out.println(currName));
	}
	
	
	public static void streamMerging() {
//		Merge 2 streams into one and sort them and then print them
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Rakulpreet");
		names.add("Xiu");
		names.add("Adam");
		names.add("Alekhya");
		
		List<String> other = Arrays.asList("Man","Woman","Whale","Tiger");
		
		Streams.concat(names.stream(), other.stream()).sorted().forEach(currEle -> System.out.println(currEle));
	}

	public static void streamMergingHashMap() {
//		I want to merge 2 lists and then create a freq Map
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Rakulpreet");
		names.add("Xiu");
		names.add("Adam");
		names.add("Alekhya");
		
		List<String> other = Arrays.asList("Man","Woman","Whale","Tiger");
		
		Map<String, Long> hashMap =  Streams.concat(names.stream(), other.stream()).collect(Collectors.groupingBy(currEle -> currEle, Collectors.counting()));
	}
	
	
	public static void streamCollect() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Rakulpreet");
		names.add("Xiu");
		names.add("Adam");
		names.add("Alekhya");
		
//		Capture all the names which starts with "A"
//		Sort them
//		Store them in a ArrayList
//		Print them
		
		ArrayList<String> result =  names.stream().filter(currName -> currName.charAt(0)=='A').sorted().collect(Collectors.toCollection(ArrayList::new));
		
		result.stream().forEach(currEle -> System.out.println(currEle));
	}
	
	
	public static void printUniqueNumber() {
		
		List<Integer> arr = Arrays.asList(3,2,2,7,5,1,9,7);
		
//		Printing the Unique Numbers :-
				
		arr.stream().collect(Collectors.groupingBy(currEle -> currEle, Collectors.counting())).entrySet().stream().filter(currEle -> currEle.getValue() == 1).forEach(currEle -> System.out.println(currEle.getKey()));
		
		System.out.println("------AScending Order printing------");
//		Print all the Unique Numbers in Ascending order :-
		
		arr.stream().collect(Collectors.groupingBy(currEle -> currEle, Collectors.counting())).entrySet().stream().filter(currEle -> currEle.getValue() == 1).sorted(new customComparator()).forEach(currEle -> System.out.println(currEle.getKey()));
	}
	
	public static void streamBooleanCheck() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Rakulpreet");
		names.add("Xiu");
		names.add("Adam");
		names.add("Alekhya");
		
//		Check if "Adam" is present or not
		
		Boolean flag = names.stream().anyMatch(currName -> currName.equalsIgnoreCase("adam"));
		
		Assert.assertTrue(flag);
	}
	
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Rakulpreet");
		names.add("Xiu");
		names.add("Adam");
		names.add("Alekhya");
		
//		Count number of Names starting with "A".
		
		int count = 0;
		
		for (int i=0; i<names.size(); i++) {
			char currChar = names.get(i).charAt(0);
			if (currChar == 'A') {
				count ++;
			}
		}
		System.out.println(count);
		
		System.out.println("--------Via Java Stream--------");
		
		streamFilter();
		
		System.out.println("--------Stream Print----------");
		
		streamPrint();
		
		System.out.println("--------Stream Map----------");
		
		streamMap();
		
		System.out.println("---------streamFreqMap------------------");
		
		streamFreqMap();
		
		System.out.println("-------------streamSorting--------------");
		
		streamSorting();
		
		System.out.println("-------------streamMerging--------------");
		
		streamMerging();
		
		System.out.println("------streamMergingHashMap------------");
		
		streamMergingHashMap();
		
		System.out.println("------streamBooleanCheck------------");
		
		streamBooleanCheck();
		
		System.out.println("-------streamCollect----------");
		
		streamCollect();
		
		System.out.println("--------printUniqueNumber----------");
		
		printUniqueNumber();
	}

}
