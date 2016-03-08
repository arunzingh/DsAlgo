package com.arun.practise;

public class CircleKillingSurvivor {
	public static int whoRemainsAlive(int N) {
		int t = N, ctr = 0, val = 1;
		while (t > 1) {
			ctr++;
			if (t % 2 != 0) {
				val = val + (int) Math.pow(2, ctr);
			} 
			t = t / 2;
		}
		return val;
	}

	public static void main(String[] args) {
		CircleKillingSurvivor c = new CircleKillingSurvivor();
		System.out.println(c.whoRemainsAlive(1000));
	}
}
