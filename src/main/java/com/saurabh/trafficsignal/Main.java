package com.saurabh.trafficsignal;

abstract class Road {
	private int time;

	public Road(int time) {
		this.time = time;
	}
}

class Road1 extends Road {
	public Road1(int t) {
		super(t);
	}
}

class Excecution extends Thread {
	String roadName;

	public Excecution(String roadName) {
		this.roadName = roadName;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName());
		if (Thread.currentThread().getName().equals("Thread1")) {
			System.out.println("Signal 1 is On" + roadName);
		}
	}
}

class Signal {
	public static Road getRoad(String road) {
		if (road.equals("road1"))
			return new Road1(10);
		return null;
	}
}

public class Main {
	public static void main(String args[]) throws InterruptedException {
		boolean flag = true;
		System.out.print("Hello");
		while (flag) {
			Road r1 = Signal.getRoad("road1");
			// Road r2 = Signal.getRoad("road2");
			// Road r3 = Signal.getRoad("road3");
			// Road r4 = Signal.getRoad("road4");
			Excecution e = new Excecution("road1");

			Thread t1 = new Thread(e);
			t1.start();
			t1.join();
			// Thread t2 = new Thread(r2);
			// t2.join();
			// Thread t3 = new Thread(r3);
			// t3.join();
			// Thread t4 =new Thread(r4);
			// t4.join();
		}
	}
}
