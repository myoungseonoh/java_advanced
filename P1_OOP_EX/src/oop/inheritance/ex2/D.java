package oop.inheritance.ex2;

class A {
    void process() { step1(); step2(); }
    void step1() { System.out.println("A.step1"); }
    void step2() { System.out.println("A.step2"); }
}

class B extends A {
    @Override
    void step1() { System.out.println("B.step1"); }
}

class C extends B {
    @Override
    void step2() { System.out.println("C.step2"); }
}

public class D extends C {

    @Override
    void step1() { 
        super.step1();  // B.step1 호출
        System.out.println("D.step1 추가"); 
    }
    
	public static void main(String args[]) {
	
		D d = new D();
		d.process();
	}
}
