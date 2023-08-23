package dataclean;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PhoneFlowWritable1 implements Writable {
    private  int upFlow;
    private  int downFlow;
    public PhoneFlowWritable1(int upFlow, int downFlow) {
        this.upFlow = upFlow;
        this.downFlow = downFlow;
    }
    @Override
    public String toString() {
        return "上传流量为："+upFlow+"  下载流量为"+downFlow;
    }
    public PhoneFlowWritable1() {
    }
    public int getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(int upFlow) {
        this.upFlow = upFlow;
    }
    public int getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(int downFlow) {
        this.downFlow = downFlow;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(upFlow);
        out.writeInt(downFlow);
    }
    @Override
    public void readFields(DataInput in) throws IOException {
      upFlow=in.readInt();
      downFlow=in.readInt();
    }
}
