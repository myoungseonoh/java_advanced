package oop.inheritance.ex3;

import java.util.ArrayList;

public class StackBefore extends ArrayList {

	public void push(String in) { super.add(in); }
	
	public String pop() { return (String)super.getLast();	}
	
	public static void main(String[] args) {
		
		StackBefore s = new StackBefore();
		s.push("A");
		s.push("B");
		s.push("C");
		s.push("D");
		s.push("E");
		
		System.out.println(s.pop());
		
		System.out.println(s.getFirst());
		
//			s.get(5); // 의도하지 않은 메서드 노출
	
	}
}

