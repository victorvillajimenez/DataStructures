String string = "Hello World!";
char[] chars;

chars.length; // => size
string.length(); // => size

new String(chars); // => to string
string.toCharArray(); // => to chars[]

string.charAt(index); // => char at index position

java.util.Arrays.sort(chars); // => return void, but char[] is sorted
java.util.Arrays.toString(chars); // => [!,  , H, W, d, e, l, l, l, o, o, r]

// initializations and declarations
chars = new char[8];
chars[0] = 's';
chars = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i'};

Character.getNumericValue(char); // => returns 10 if char is 'a' or 'A'. 35 if it is 'z' or 'Z'


import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int t = 0; t < n; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }
    }
}

// =====================
Both are mutable and are storaged at the heap
StringBuffer  = Thread safe, synchronized, slow
StringBuilder = No thread safe, asyn, faster

