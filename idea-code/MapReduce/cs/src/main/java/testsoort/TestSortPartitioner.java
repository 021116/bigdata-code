package testsoort;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;
public class TestSortPartitioner extends Partitioner<TestSortWritable, NullWritable> {
    @Override
    public int getPartition(TestSortWritable testSortWritable, NullWritable nullWritable, int i) {
            //因为传过来的text中包含人名和学科和成绩，我们需要根据学科分类
            //获取学科
            String subject = testSortWritable.getSubject();
            //根据学科分区
            if (subject.equals("语文")) {
                return 0;
            } else if (subject.equals("数学")) {
                return 1;
            } else if (subject.equals("英语")) {
                return 2;
            }
            return 3;
        }
    }

