import java.util.*;

public class DZI_ZAD26 {
    public static void main(String[] args) {
        NumR reader = new NumR();
        MaxCal calc = new MaxCal(reader.getnum());
        calc.printResults();
    }
}

class NumR {
    private int[] num;

    public NumR() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        num = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            num[i] = list.get(i);
        }
    }


    public int[] getnum() {
        return num;
    }
}

class MaxCal{
    private int bigger;
    private int maxDigit;

    public MaxCal(int[] numbers) {
        int max = fMax(numbers);
        bigger = max + 1;
        maxDigit = fMaxDigit(bigger);
    }

    private int fMax(int[] arr) {
        int m = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > m) m = x;
        }
        return m;
    }

    private int fMaxDigit(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        StringBuilder sb = new StringBuilder(new String(digits)).reverse();
        return Integer.parseInt(sb.toString());
    }

    public void printResults() {
        System.out.println("Max Element = " + bigger);
        System.out.println("Max Digit = " + maxDigit);
        System.out.println("next Max Digit = " + (maxDigit + 1));
    }
}
