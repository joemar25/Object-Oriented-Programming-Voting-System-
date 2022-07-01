import java.util.*;
import java.lang.*;
import java.io.*;

class Test {
    public static void main(String[] args) throws java.lang.Exception {
        InputStream inputStream = System.in;
        Scanner in = new Scanner(inputStream);

        for (int i = 0; i < in.nextInt(); i++) {
            int first = in.nextInt();
            int second = in.nextInt();
            if (first < second)
                System.out.println("FIRST");
            else if (first > second)
                System.out.println("SECOND");
            else
                System.out.println("ANY");
        }

        in.close();

    }
}
/*
 * import java.util.*;
 * import java.lang.*;
 * import java.io.*;
 * 
 * class Test {
 * public static void main(String[] args) throws java.lang.Exception {
 * InputStream inputStream = System.in;
 * Scanner in = new Scanner(inputStream);
 * 
 * int num[][] = new int[in.nextInt()][2];
 * for (int i = 0; in.hasNext(); i++) {
 * num[i][0] = in.nextInt();
 * num[i][1] = in.nextInt();
 * if (num[i][0] < num[i][1])
 * System.out.println("FIRST");
 * else if (num[i][0] > num[i][1])
 * System.out.println("SECOND");
 * else
 * System.out.println("ANY");
 * }
 * 
 * }
 * }
 * 
 */
