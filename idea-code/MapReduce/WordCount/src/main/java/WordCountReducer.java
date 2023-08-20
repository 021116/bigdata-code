import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/*
    reduce是用来合并的,也是四个泛型,并且两个与map一致
    后两个为reduce的输出类型
        hello   5
        world   2
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        // 拿到的数据    hello[1, 1, 1, 1, 1]    world[1, 1]
        int count = 0;
        for (IntWritable num : values){
            // 把num变成int
            int i = num.get();
            // 把值加在一起(把里面的次数累加)
            count = count + i;
        }
        // 输出key
        context.write(key, new IntWritable(count));
    }
}
