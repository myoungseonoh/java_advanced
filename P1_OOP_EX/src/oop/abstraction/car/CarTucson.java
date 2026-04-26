package oop.abstraction.car;
//
//public class CarTucson implements Car {
//	
//	int speed = 0;
//	
//	public CarTucson() {
//	}
//	
//
//	@Override
//	public void start() {
//		System.out.println("Start Tucson..");
//		
//	}
//
//	@Override
//	public void stop() {
//		System.out.println("Stop Tucson..");
//		
//	}
//
//	@Override
//	public void brake() {
//		System.out.println("Bake Tucson..");
//		
//	}
//
//	@Override
//	public void accelerate() {
//		System.out.println("Accelerate Tucson..");
//		speed += 10;
//		
//	}
//
//	@Override
//	public int getCurrentSpeed() {
//		return speed;
//	}	
//}

class Character {
    void spell(String code) {   }
}


class Alphabet extends Character {

    void spell(int code) {   }			 
    void spell(String code) {   }
   
}



public class CarTucson extends Car {
	
	public CarTucson() {
	}
	
	@Override
	void startEngine() {
		System.out.println(" . Start Tucson Engine..");
	}

	@Override
	void stopEngine() {
		System.out.println(" . Stop Tucson Engine..");
	}

	@Override
	void performAccelerate() {
		System.out.println(" . Accelerate..");
		speed += 10;
	}

	@Override
	void performBrake() {
		System.out.println(" . Brake..");
		
	}	
}
