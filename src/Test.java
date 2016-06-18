
public class Test {
	public static void main(String[] args) {
		StairCase(6);
	}
	
    static void StairCase(int n) {
        
        for (int i = 0; i < n; i++) {
            int space = n-1-i;
            while (space > 0) {
                System.out.print(" ");
                space--;
            }
            int j = i + 1;
            while (j > 0) {
                System.out.print("#");
                j--;
            }
            System.out.println();
        }

    }
}
