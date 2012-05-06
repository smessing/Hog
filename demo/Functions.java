import java.io.IOException;
import java.util.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
public class Hog {
    public static class Functions {
        public static int fib(int n) {
            if (n == 0) {
                return 1;
            }
             else if (n == 1) {
                return 1;
            }
             else {
                return Functions.fib(n - 1) + Functions.fib(n - 2);
            }
         }
        public static int factorial(int n) {
            if (n == 1) {
                return 1;
            }
             else {
                return n * Functions.factorial(n - 1);
            }
         }
        public static List<Integer> reverseList(List<Integer> oldList) {
            List<Integer> newList = new ArrayList<Integer>();
            for (int i = oldList.size() - 1; i >= 0; i--) {
                newList.add(oldList.get(i));
             }
            return newList;
         }
    }
    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, IntWritable, Text> {
        public void map(LongWritable lineNum, Text value,  OutputCollector<IntWritable, Text> output, Reporter reporter) throws IOException {
            String line = value.toString();
            output.collect(new IntWritable(1), new Text("foo"));
        }
    }
    public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text word, Iterator<IntWritable> values,  OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            output.collect(new Text("foo"), new IntWritable(1));
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println(Integer.toString(Functions.factorial(5)));
        System.out.println(Integer.toString(Functions.fib(7)));
        List<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            myList.add(i);
         }
        myList = Functions.reverseList(myList);
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println(Integer.toString(myList.get(i)));
             }
         }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("we caught an exception");
         }
    }
}
