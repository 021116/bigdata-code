import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.junit.Before;

public class HdfsUtils {
    private FileSystem fileSystem;
    @Before
    public void setUp() throws Exception{
        System.setProperty("HADOOP_USER_NAME","root");
        //  在每个测试方法之前执行的准备工作
        Configuration conf = new Configuration();
        //  设置  HDFS    地址
        conf.set("fs.defaultFS","hdfs:bigdata01:9820");
        fileSystem = fileSystem.get(conf);
    }
}
