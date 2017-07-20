package com.test.common;

import java.util.Iterator;
import java.util.TreeSet;

public class Test {
public static void main(String[] args) {
	/*HashSet i = new HashSet<>();
	i.add(new Integer(1));
	i.add(new Integer(1));
System.out.println(i.size());	*/
	/*String[] a = { "f", "o", "o", "bar" };
	System.out.println(Test.concat(a));*/
	
	/*TreeSet x = new TreeSet();
	x.add("One");
	x.add("Two");
	x.add("Three");
	x.add("Four");
x.add("One");
	Iterator i = x.iterator();
	while(i.hasNext()) {
		System.out.println(i.next());
	}*/
	System.out.println(func3());
	
	/*while(scanner.hasNext()){
		String line = scanner.nextLine();
		if(!line.equalsIgnoreCase("")){
			String[] elements = line.split(",");
			int people = Integer.parseInt(elements[0]);
			int interval = Integer.parseInt(elements[1]) - 1;
			
			LinkedList<Integer> lineUp = new LinkedList<Integer>();
			
			for(int i = 0; i < people; i++){
				lineUp.add(i);
			}
			
			int currIndex = 0;
			while(lineUp.size() > 0){
				int nextIndex = currIndex + interval;
				while(nextIndex >= lineUp.size()){
					nextIndex -= lineUp.size();
				}
				System.out.print(lineUp.get(nextIndex) + " ");
				currIndex = nextIndex;
				lineUp.remove(nextIndex);
				
				if(lineUp.size() == 1){
					System.out.println(lineUp.get(0));
					break;
				}
			}
		}
	}*/
}
static int func1() {
	System.out.println("Inside func1");
	return 1;
}
static int func2() {
	System.out.println("Inside func2");
	return 1;
}
static int func3() {
	System.out.println("Inside func3");
	return func1() + func2();
}


static String concat(String[] strings) {
	String s = "";
	for(String str:strings) {
		s = s.concat(str);
	}
	return s;
	
}
}
