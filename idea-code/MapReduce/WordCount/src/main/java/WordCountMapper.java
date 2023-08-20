import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

// mapper端代码
/*
LongWritable表示这一行的偏移量
Text 表示这一行是字符串，字符串用Text
Text map输出的key值
IntWritable 表示key的次数
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    // ctrl + o 类中拿些方法可以被冲写
    // 每一个map获取的每一行数据执行一次map方法
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        // 拿到一行数据
        // hello bigdata hello 1999 hello beijing hello
        String line = value.toString();
        // 切割,变成一个数组
        String[] arr = line.split(" ");
        // 往外写
        for (String word : arr) {
            context.write(new Text(word), new IntWritable(1));
        }
    }
}