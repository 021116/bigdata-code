import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.junit.Test;

import java.io.IOException;

public class Demo01 {
    @Test
    public void test01() throws IOException {
        // 配置的意思
        Configuration configuration = new Configuration();
        // HDFS的连接地址
        configuration.set("fs.defaultFS","hdfs://bigdata01:9820");
        FileSystem fileSystem = FileSystem.get(configuration);
    }

}
