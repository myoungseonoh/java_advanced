package oop.encapsulation.ex1.pk1;

import oop.encapsulation.ex1.pk2.F;
//import oop.encapsulation.ex1.pk2.G;

public class A {

	public void publicMethod() { System.out.println("Public Method"); }						// ALL
	protected void proetectedMethod() { System.out.println("protected Method"); }			// SubClass & Package
	void defaultMethod() { System.out.println("default Method"); privateMethod(); }			// Package
	private void privateMethod() { System.out.println("private Method"); }					// Class

}

class B extends A {
	
	public void run() {
		publicMethod();
		proetectedMethod();
		defaultMethod();
		// privateMethod();  (X)
		
		F f = new F();
//		G g = new G();	// 다른 패키지의 default 클래스 접근 안됨
	}
}

class C {

	public void run() {
		
		A a = new A();
		
		a.publicMethod();
		a.proetectedMethod();
		a.defaultMethod();
		// a.privateMethod(); (X)
	}
}
