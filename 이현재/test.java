package 이현재;

public class test {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(514229 % 1234567);
        System.out.println(832040 % 1234567);
        System.out.println(832040 + 514229);
        int[] solution = solution();
        int[] solution01 = solution01();

        for (int i = 0; i < solution.length; i++) {
            System.out.println(i + "번째");
            System.out.println("solution = " + solution[i] + " solution01 = " + solution01[i]);
        }
    }

    public static int[] solution() {
        int[] fibonacci = new int[32];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 1] % 1234567 + fibonacci[i - 2] % 1234567;
        }
        return fibonacci;
    }

    public static int[] solution01() {
        int[] fibonacci = new int[32];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1234567;
        }
        return fibonacci;
    }
}
