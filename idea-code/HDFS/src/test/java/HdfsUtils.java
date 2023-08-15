import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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
    @After
    public void tearDown() throws Exception {
        //  在每个测试方法之后执行的清理工作
        fileSystem.close();
    }
    @Test
    public void testUploadDile() throws Exception{
        String localFilePath = "C:\\Users\\mortal\\Desktop\\edip";
        String hdfsFilePath = "/";
        fileSystem.copyFromLocalFile(new Path(localFilePath),new Path(hdfsFilePath));
    }
    @Test
    public void testCreateFile() throws IOException {
        String hdfsFilePath = "/newfile.txt";
        fileSystem.createNewFile(new Path(hdfsFilePath));
    }
    @Test
    public void testDownloadFile() throws IOException {
        String hdfsFilePath = "/newfile.txt";
        String localFilePath = "C:\\Users\\mortal\\Desktop\\file.txt";
        fileSystem.copyToLocalFile(new Path(hdfsFilePath), new Path(localFilePath));
    }
    @Test
    public void testDeleteFile() throws IOException {
        String hdfsFilePath = "/newfile.txt";
        fileSystem.delete(new Path(hdfsFilePath), false);
    }
    @Test
    public void testMkDir() throws IOException {
        fileSystem.mkdirs(new Path("/input"));
        System.out.println("创建文件夹成功");
    }
}
