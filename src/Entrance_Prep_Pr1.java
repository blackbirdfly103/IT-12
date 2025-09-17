import java.util.*;

public class Entrance_Prep_Pr1 {
    private int N;
    private List<Double> validPoints = new ArrayList<>();

    public void ReadPoints() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            double point = sc.nextDouble();
            if (point > 0) {
                validPoints.add(point);
            }
        }
    }

    public double MinDpoints() {
        Set<Double> unique = new TreeSet<>(validPoints);
        List<Double> sorted = new ArrayList<>(unique);

        double minDiff = Double.MAX_VALUE;
        for (int i = 1; i < sorted.size(); i++) {
            double diff = sorted.get(i) - sorted.get(i - 1);
            if (diff < minDiff) minDiff = diff;
        }
        return minDiff;
    }

    public List<Double> Laureates() {
        List<Double> sorted = new ArrayList<>(validPoints);
        sorted.sort(Collections.reverseOrder());

        double thirdHighest = 0;
        int uniqueCount = 0;
        double last = Double.NaN;
        for (double v : sorted) {
            if (v != last) {
                uniqueCount++;
                last = v;
                if (uniqueCount == 3) {
                    thirdHighest = v;
                    break;
                }
            }
        }

        List<Double> laureates = new ArrayList<>();
        for (double v : validPoints) {
            if (v >= thirdHighest) {
                laureates.add(v);
            }
        }
        return laureates;
    }

    public void printResults() {
        System.out.println("valid works - " + validPoints.size());
        System.out.printf("minimal difference - %.3f\n", MinDpoints());
        List<Double> laureates = Laureates();
        System.out.print("laureates - ");
        for (int i = 0; i < laureates.size(); i++) {
            System.out.print(laureates.get(i));
            if (i < laureates.size() - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Entrance_Prep_Pr1 s = new Entrance_Prep_Pr1();
        s.ReadPoints();
        s.printResults();
    }
}
