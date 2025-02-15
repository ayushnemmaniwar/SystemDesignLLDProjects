//If we call run method directly then it will be under main thread
//class MyRunnable implements Runnable {
//    @Override
//    public void run() {
//        System.out.println("Running in thread: " + Thread.currentThread().getName());
//    }
//}
//
//public class Test {
//    public static void main(String[] args) {
//        MyRunnable runnable = new MyRunnable();
//        runnable.run();  // Direct call to run(), executes in main thread
//    }
//}

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


class Test {
    public static int testExceptionDivide(int a, int b) throws ArithmeticException{
        if(a == 0 || b == 0)
            throw new ArithmeticException();
        return a/b;
    }
    public static void main(String args[]) {
        //testExceptionDivide(10, 0);
        try{
            testExceptionDivide(10, 0);
        }
        catch(ArithmeticException e){
            //Handle the exception
        }
    }
}