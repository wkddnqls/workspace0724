package solo.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class num {

	public static void main(String[] args) {
		   Set<Integer> numbers = new HashSet<>();

	        while (numbers.size() < 6) {
	            int random = (int)(Math.random() * 49); // 0~100
	            numbers.add(random);
	        }

	        System.out.println(numbers);
	    }
	}
