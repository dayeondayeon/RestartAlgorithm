package basic;

public class Main {
    public static void main(String[] args) {
        System.out.println(func4(5));
        System.out.println(func4(97615282));
        System.out.println(func4(1024));
    }

    static int func3(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (i * i == num) {
                return 1;
            }
        }
        return 0;
    }

    static int func4(int num) {
        int answer = 1;
        for (int i = 1; Math.pow(2, i) <= num; i++) {
            answer *= 2;
        }
        return answer;

        /**
         * while (2 * val <= num)
         *  val *= 2;
         * */
    }
}
