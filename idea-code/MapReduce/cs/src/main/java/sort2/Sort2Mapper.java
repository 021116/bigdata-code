package sort2;



import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class Sort2Mapper extends Mapper<LongWritable, Text, Sort2Writable, NullWritable> {
    Sort2Writable sort2Writable=null;
    @Override
    protected void setup(Mapper<LongWritable, Text, Sort2Writable, NullWritable>.Context context) throws IOException, InterruptedException {
        sort2Writable=new Sort2Writable();
    }
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Sort2Writable, NullWritable>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split("\\s+");
        //获取观众人数
        int v= Integer.valueOf(split[1]);
        //获取主播名字
        String name = split[0];
        //获取直播时长
        int time= Integer.valueOf(split[2]);
        sort2Writable.setName(name);
        sort2Writable.setV(v);
        sort2Writable.setTime(time);
        //输出
        context.write(sort2Writable,NullWritable.get());
    }
}
