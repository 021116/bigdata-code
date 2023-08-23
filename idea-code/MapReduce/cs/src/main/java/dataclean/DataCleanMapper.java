package dataclean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
public class DataCleanMapper extends Mapper<LongWritable, Text,Text, PhoneFlowWritable1> {
    Text text=null;
    PhoneFlowWritable1 phoneFlowWritable1=null;
    @Override
    protected void setup(Mapper<LongWritable, Text, Text, PhoneFlowWritable1>.Context context) throws IOException, InterruptedException {
        text=new Text();
        phoneFlowWritable1=new PhoneFlowWritable1();
    }
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, PhoneFlowWritable1>.Context context) throws IOException, InterruptedException {
        //拿到每行数据
        String line = value.toString();
        //用多个空格进行分割
        String[] split = line.split("\\s+");
        //判断每个行中是否含有null 和不完整数据 若有则退出此行的判断，若没有则获取起其手机号和上传流量和下载流量
        if (line.contains("null") || split.length<9 ) {
            return;
        }else {
                //获取手机号
                String phone = split[1];
                //数组长度
                int len=split.length;
                //获取上传流量
                String up = split[len-3];
                int upFlow = Integer.valueOf(up);
                //获取下载流量
                String down = split[len-2];
                int downFlow = Integer.valueOf(down);
                phoneFlowWritable1.setUpFlow(upFlow);
                phoneFlowWritable1.setDownFlow(downFlow);
                text.set(phone);
                //传输
                context.write(text,phoneFlowWritable1);
            }
        }
    }

