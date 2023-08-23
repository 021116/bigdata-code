package testsoort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class TestSortDriver {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        //使用本地的文件系统，而不是hdfs
        configuration.set("fs.defaultFS","file:///");
        // 使用本地的资源（CPU,内存等）, 也可以使用yarn平台跑任务
        configuration.set("mapreduce.framework.name","local");
        Job job = Job.getInstance(configuration, "学科分区");
        //map 任务执行
        job.setMapperClass(TestSortMapper.class);
        job.setMapOutputKeyClass(TestSortWritable.class);
        job.setMapOutputValueClass(NullWritable.class);
        //分区任务执行
        // 指定分区的类是哪一个
        job.setPartitionerClass(TestSortPartitioner.class);
        // 还要执行 reduce的数量  因为一个reduce 就会产生一个结果文件
        job.setNumReduceTasks(3);
        // 设置要统计的数据的路径，结果输出路径
        FileInputFormat.setInputPaths(job,new Path("C:\\Users\\mortal\\Desktop\\code\\bigdata-code\\idea-code\\MapReduce\\cs\\mr06\\input"));
        // ouput文件夹一定不要出现，否则会报错
        FileOutputFormat.setOutputPath(job,new Path("C:\\Users\\mortal\\Desktop\\code\\bigdata-code\\idea-code\\MapReduce\\cs\\mr06\\output"));
        // 等待任务执行结束
        boolean b = job.waitForCompletion(true);
        // 此处是一定要退出虚拟机的
        System.exit(b ? 0:-1);


    }
}
