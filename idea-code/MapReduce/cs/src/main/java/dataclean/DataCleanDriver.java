package dataclean;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

import static org.apache.hadoop.mapreduce.Job.getInstance;

public class DataCleanDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration configuration = new Configuration();
        // 使用本地的文件系统，而不是hdfs
        configuration.set("fs.defaultFS","file:///");
        // 使用本地的资源（CPU,内存等）, 也可以使用yarn平台跑任务
        configuration.set("mapreduce.framework.name","local");
        Job job = getInstance(configuration, "手机流量");
        // map任务的设置
        job.setMapperClass(DataCleanMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(PhoneFlowWritable1.class);
        // 设置要统计的数据的路径，结果输出路径
        FileInputFormat.setInputPaths(job,new Path("C:\\Users\\mortal\\Desktop\\code\\bigdata-code\\idea-code\\MapReduce\\cs\\mr05\\input"));
        // ouput文件夹一定不要出现，否则会报错
        FileOutputFormat.setOutputPath(job,new Path("C:\\Users\\mortal\\Desktop\\code\\bigdata-code\\idea-code\\MapReduce\\cs\\mr05\\output"));
        // 等待任务执行结束
        boolean b = job.waitForCompletion(true);
        // 此处是一定要退出虚拟机的
        System.exit(b ? 0:-1);
    }

}

