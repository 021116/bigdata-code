package sort2;
import org.apache.hadoop.io.WritableComparable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
public class Sort2Writable implements  WritableComparable<Sort2Writable>  {
    private int v;
    private String name;
    private int time;
    public Sort2Writable(int v, String name,int time) {
        this.v = v;
        this.name = name;
        this.time=time;
    }
    public Sort2Writable() {
    }
    public int getV() {
        return v;
    }
    public void setV(int v) {
        this.v = v;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    @Override
    public void readFields(DataInput in) throws IOException {
        v = in.readInt();
        name = in.readUTF();
        time=in.readInt();
    }
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(v);
        out.writeUTF(name);
        out.writeInt(time);
    }
    @Override
    public String toString() {
        return  name+" "+v+" "+time;
    }
//按照观众人数降序排序，如果观众人数相同，按照直播时长降序
    @Override
    public int compareTo(Sort2Writable o) {
        int thisValue = this.v;
        int thatValue = o.v;
// 根据观看人数降序排序
        if (thisValue > thatValue) {
            return -1;
        } else if (thisValue < thatValue) {
            return 1;
        } else {// 如果观众人数相同，则根据直播时长降序排序
            int thisTime = this.time;
            int thatTime = o.time;
            if (thisTime > thatTime) {
                return -1;
            } else if (thisTime < thatTime) {
                return 1;
            } else{
                // 观看人数和直播时长都相同，返回0
                return 0;
            }
        }
    }
}

