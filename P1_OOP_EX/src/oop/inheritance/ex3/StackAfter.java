package oop.inheritance.ex3;

import java.util.ArrayList;

public class StackAfter  {

	private ArrayList<String> list = new ArrayList<String>();
	
	public void push(String in) { list.add(in); }
	
	public String pop() { return list.getLast();	}
	
	public static void main(String[] args) {
		
		StackAfter s = new StackAfter();
		s.push("A");
		s.push("B");
		s.push("C");
		s.push("D");
		s.push("E");
		
		System.out.println(s.pop());
		
//		System.out.println(s.getFirst()); // 사용불가
		
	}
}

