package testsoort;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
public class TestSortMapper extends Mapper<LongWritable, Text,TestSortWritable, NullWritable> {
    Text text=null;
    TestSortWritable testSortWritable=null;
    @Override
    protected void setup(Mapper<LongWritable, Text, TestSortWritable,NullWritable >.Context context) throws IOException, InterruptedException {
        text=new Text();
        testSortWritable=new TestSortWritable();
    }
    @Override
        protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, TestSortWritable,NullWritable >.Context context) throws IOException, InterruptedException {
            //获取每行的数据 把text类型转化为string类型
            String line = value.toString();
            //获取每行中字段
            String[] split = line.split("\\s+");
            //获取人名
            String name = split[0];
           //获取学科
            String subject = split[1];
            //获取成绩
            String sc = split[2];
            int score = Integer.valueOf(sc);
            testSortWritable.setName(name);
            testSortWritable.setScore(score);
            testSortWritable.setSubject(subject);
            //输入到分区中
            context.write(testSortWritable,NullWritable.get());
        }
}
