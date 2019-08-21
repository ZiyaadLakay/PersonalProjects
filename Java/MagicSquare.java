//ZIYAAD LAKAY


import java.util.Scanner;

public class MagicSquare {

    public MagicSquare() {

    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        //CHECK IF ODD OR EVEN

        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter a single dimension of the required size of the square: ");
        int n = sc.nextInt();

        if (n % 2 == 0) {        //even
            System.out.println("Sorry, this is not a valid dimension.\nPlease choose an odd number as your dimension.");
        } else {      //odd
            CreateAMagicSquare(n);
        }
    }

    public static int[][] CreateAMagicSquare(int n) {
        int k = 1;

        int row = 0;
        int col = 0;

        int middle = (n - 1) / 2;

        col = middle;

        int[][] ms = new int[n][n];
        ms[row][col] = k;

        row = n - 1;
        col = middle - 1;

        k = 2;

        while (k <= n * n) {
            if (k % n == 0) {
                //move down

                if (row == n - 1) {
                    ms[row][col] = k;
                    row = 0;

                } else {
                    ms[row][col] = k;
                    row++;

                }

            } else {
                //move up first (outer if)
                //move left second (inner if)
                if (row == 0) {

                    if (col == 0) {
                        ms[row][col] = k;
                        col = n - 1;

                    } else {
                        ms[row][col] = k;
                        col--;

                    }

                    row = n - 1;

                } else {

                    if (col == 0) {
                        ms[row][col] = k;
                        col = n - 1;

                    } else {
                        ms[row][col] = k;
                        col--;

                    }

                    row--;

                }

            }

            k++;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ms[i][j] + "\t");
            }
            System.out.println();
        }

        return ms;

    }

}
