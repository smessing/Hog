import java.io.IOException;
import java.util.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
public class Hog {
    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
        public void map(LongWritable lineNum, Text value,  OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            String line = value.toString();
            for (String word : line.split(" ")) {
                output.collect(new Text(word), new IntWritable(1));
             }
        }
    }
    public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text word, Iterator<IntWritable> values,  OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            int count = 0;
            while (values.hasNext()) {
                count = count + values.next().get();
             }
            output.collect(new Text(word), new IntWritable(count));
        }
    }
    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(Hog.class);
        conf.setJobName("hog");
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);
        conf.setMapperClass(Map.class);
        conf.setCombinerClass(Reduce.class);
        conf.setReducerClass(Reduce.class);
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
        JobClient.runJob(conf);
    }
}
