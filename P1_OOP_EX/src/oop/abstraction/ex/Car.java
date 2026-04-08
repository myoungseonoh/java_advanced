package oop.abstraction.ex;
//
//interface Car {
//
//	void start()			// 시동을 걸다
//  void stop();			// 시동을 끄다
//	void brake();			// 브레이크를 걸다
//	void accelerate();		// 속도를 올린다.
//	int getCurrentSpeed();	// 현재속도 확인
//}


abstract class Car {

	   int speed = 0;
	   boolean isRunning = false;

	   public void start() {
		   if (isRunning) {
			   System.out.println("이미 시동이 켜져 있습니다.");
			   return;
	        }
		   startEngine();
		   isRunning = true;
	   }
	   
	   public void stop() {
		   if (!isRunning) {
			   System.out.println("이미 시동이 꺼졌습니다.");
			   return;
	        }
		   stopEngine();
		   isRunning = false;
	   }
	   
	   public void brake() {
		   if (!isRunning) {
			   System.out.println("시동이 꺼졌습니다.");
			   return;
	        }
		   performBrake();
		   speed = 0;
	   }
	   
	   public final void accelerate() {
	        if (!isRunning) {
	            System.out.println("시동이 꺼져 있습니다.");
	            return;
	        }
	        
	        performAccelerate();  	// 차종별로 다름
	    }

	   public int getCurrentSpeed() {  // 현재속도 확인
	       return speed;
	   }
	   
	   // 추상 메서드
	   abstract void startEngine();
	   abstract void stopEngine();
	   abstract void performAccelerate();
	   abstract void performBrake();
	   abstract void screenSpeed();
}
