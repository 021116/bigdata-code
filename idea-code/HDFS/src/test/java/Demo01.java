import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

//  使用java代码连接hdfs
public class Demo01 {
    @Test
    public void test01() throws IOException {
        // 配置的意思
        Configuration configuration = new Configuration();
        // HDFS的连接地址
        configuration.set("fs.defaultFS","hdfs://bigdata01:9820");
        FileSystem fileSystem = FileSystem.get(configuration);
    }
    @Test
    public void test02() throws Exception {
        //  URL 和   URL
        //  URL =   中华人民共和国
        //  指的是互联网上比较具体的第一个内容,地址
        //  URI =   共和国 员工的编号9527
        //  cookie  session
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://bigdata01:9820"), new Configuration());
        System.out.println(fileSystem);
    }
    @Test
    public void test03() throws Exception{
        // 配置的意思
        Configuration configuration = new Configuration();
        //  hdfs的连接地址
        configuration.set("fs.defaultFS","hdfs://bigdata01:9820");
        FileSystem fileSystem = FileSystem.newInstance(configuration);
        System.out.println(fileSystem);
    }
    @Test
    public void test04() throws Exception {
        // 配置的意思
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.newInstance(new URI("hdfs://bigdata01:9820"), configuration);
        System.out.println(fileSystem);
    }
}
