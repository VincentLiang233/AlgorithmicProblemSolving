import java.util.ArrayList;
import java.util.Arrays;

public class MidtermReview{
    public static void main(String[] args){
        System.out.println(Long.toBinaryString((long)(0xffffffff)));
    }

    public static void fun(int x){
        if (x <= 0)
            return;
        System.out.println(x);
        fun(x-1);
        fun(x-1);
        System.out.println(x);
    }

    public static ArrayList<Integer> primes(int n){
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        for (int p = 2; p < n; p++){
            if (isPrime[p]){
                for (int i = p*2; i < n; i+= p){
                    isPrime[i] = false;
                }
                result.add(p);
            }
        }
        return result;
    }
    public static boolean checkBrackets(String s ){
        int counter = 0;
        for (int i = 0; i < s.length(); i++){
            if (counter < 0){
                return false;
            }
            if (s.charAt(i) == '('){
                counter += 1;
            }else if (s.charAt(i) == ')'){
                counter -=1;
            }
        }
        return (counter == 0);
    }
    public static void generate(int k, int subset){
        if (k < 0){
            System.out.println(Integer.parseInt(Integer.toBinaryString(subset),2));
            return;
        }
        generate(k-1, subset);
        generate(k-1, subset | (1<<k));
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0)
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}

//Notes:
//1. Asymptotic Analysis
//  O(n): We say f(n) is O(g(n)) if there exists c and N such that c*g(n) >= f(n) >= 0 for every n >= N.
//  Theta(n): We say f(n) is Theta(g(n)) if there exists c1,c2 and N such that c1*g(n) <= f(n) <= c2*g(n) for every n >= N.
//  Omega(n): We say f(n) is Omega(g(n)) if there exists c and N such that f(n) >= c*g(n) for every n >= N.
//  On average, single cpu performs 10^9 operations per second.

//2. Data type
//Java: boolean 1 bit;
//      byte 8 bits (1 byte);
//      char 16 bits (2 bytes);
//      short 16 bits (2 bytes);
//      int  32 bits (4 bytes);
//      long  64 bits (8 bytes);
//      float  32 bits (4 bytes);
//      double  64 bits (8 bytes);

//3. Linear Data structures (Java)
// List : ArrayList (Vector), LinkedList
// Stack : Stack
// Queue : ArrayDeque, PriorityQueue

// Challenge:
// Detect cycles within LinkedList:
//     1. Start two points at head of the LinkedList
//     2. j += 2 while i += 1
//     3. if before ending, j == i => there exists loop
//     4. To get the size of the loop, after they meet, let one of the points go through the loop again to find the size.

// Function Call Stacks:
//     Check above.
// Challenge(for mixed brackets):
//     keep a stack of characters
//     for each opening brackets, push it onto the stack
//     for each closing bracket,
//         if matches top of the stack, then pop the stack
//         otherwise invalid
//     if the stack is empty, then valid, otherwise invalid

//Evaluate Prefix Expressions
//scan from right to left !!!
//for each token:
//  if the token is an operand then:
//      push onto a stack
//  else if the token is an operator:
//      compute (s.pop) (operator) (s.pop)
//      s.push(result)
//return top of the stack as the result

//Evaluate Postfix:
//scan from left to right

//4.Bit-mask
//Setting the kth bit to be on: x |= (1 << k)
//Setting the kth bit to be off: x = x & ~(1 << k)
//Reversing the kth bit: x = x ^ ( 1 << k)
//Inverting all bits after the last one bit: x |= (x - 1)
//Setting the last one bit to be 0: x &= (x-1)
//Test if x is a power of 2: x & (x-1) == 0
//Turns on every bit in an even position
// int x = 0;
// for (int i = 0; i < 31; i += 2){
//  x = x | (1 << i);
//  }
//Hamming distance
//Integer.bitCount(x^y)

//Exercises:
//Create two sets a = 1,3,8,11,23,27 and b = 1,2,4,11,15,27
//Compute their union, intersection and difference.
//List all possible subsets of a set 0,1,2...31
//List all possible subsets of 0,1,2...31 that has exactly 7 elements

//5. Non-Linear Data Structures
//Challenge:
//  Given N integers, find k largest ones.
//      (Best: O(n), remember: O(nlogk))
//  Given a root to binary tree, determine if it's BST
//      (Do inorder traversal and see if it's ordered)
//  Find values in range [a,b]
//      See above
//  Output leaves in ascending order
//      See above
//  Update(index, new_value) for heap
//      See above
//  Delete(index) for heap
//      See above
//  Median
//      Find the n/2-th largest element
//      or Use median of median's
//  Students club
//      The number of sets in the union set
//  Allies and enemies
//      Keep two copies of each country
//      ally(x,y):
//          If sameSet(x,y'), then conflict
//          otherwise union(x,y) and union(x',y')
//      enemy(x,y):
//          if sameSet(x,y), then conflict
//          otherwise union(x,y') and union(y',x)
//      isAlly(x,y):
//          return sameSet(x,y)
//      isEnemy(x,y):
//          return sameSet(x,y')
//  Build a maze
//      create a set of all internal walls
//      choose a wall at random
//      if cells on each side of the wall are not in the same set
//          erase the wall
//      repeat until all cells are in the same set





