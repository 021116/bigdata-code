import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WordCountDriver {
    // 把mapper和reducer放在一起执行
    public static void main(String[] args) throws Exception {
        // 1.你想读哪里的文件
        Configuration configuration = new Configuration();
        // 使用本地的文件系统而不是hdfs
        configuration.set("fs.defaultFS", "file:///");
        // 使用本地的资源,也可以使用yarn跑任务
        configuration.set("mapreduce.framework.name", "local");
        // 给job任务起个名字
        Job job = Job.getInstance(configuration, "wordCount单次统计");
        // 设置map是什么
        job.setMapperClass(WordCountMapper.class);
        // map进来后的输出类型(key和value)
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setReducerClass(WordCountReducer.class);

        // 设置reducer的输出
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 输出
        FileInputFormat.setInputPaths(job, "mr01/input/");
        FileOutputFormat.setOutputPath(job, new Path("mr01/output"));
        // 运行job
        boolean result = job.waitForCompletion(true);
        // 不管执行成功还是失败都退出系统
        // 反回结果为true就正常退出,反之非正常退出
        System.exit(result ? 0 : -1);

    }
}
