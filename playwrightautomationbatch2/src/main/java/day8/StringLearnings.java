package day8;

public class StringLearnings {
	
	
	public static void main(String[] args) {
		
		int iterations = 1_000_000; // 1 million

        // Test StringBuffer
        long startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("Start");
        for (int i = 0; i < iterations; i++) {
            sbf.append("X");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) + " ms");

        // Test StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder sbd = new StringBuilder("Start");
        for (int i = 0; i < iterations; i++) {
            sbd.append("X");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) + " ms");

	}
}
