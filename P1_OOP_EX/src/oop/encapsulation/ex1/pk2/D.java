package oop.encapsulation.ex1.pk2;

import oop.encapsulation.ex1.pk1.A;

public class D {

	public void run() {
		
		A a = new A();
		
		a.publicMethod();
		//a.proetectedMethod();		// (X)
		//a.defaultMethod();		// (X)
		//a.privateMethod();		// (X)
		
		F f = new F();
		G g = new G();
	}
}

 class E extends A {

	public void run() {
		
		publicMethod();
		proetectedMethod();
		//defaultMethod();			// (X)
		//privateMethod();			// (X)
	}
}

