package testsoort;
import org.apache.hadoop.io.WritableComparable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
public class TestSortWritable implements  WritableComparable<TestSortWritable> {
    private int score;
    private String subject;
    private String name;

    public TestSortWritable(int score, String value, String name) {
        this.score = score;
        this.subject = value;
        this.name = name;
    }

    public TestSortWritable() {
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return  name+" "+subject+" "+score;
    }
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(score);
        out.writeUTF(subject);
        out.writeUTF(name);
    }
    @Override
    public void readFields(DataInput in) throws IOException {
            score=in.readInt();
            subject=in.readUTF();
            name=in.readUTF();
    }
    @Override
    public int compareTo(TestSortWritable o) {
        int thisValue = this.score;
        int thatValue = o.score;
        return (thisValue>thatValue ? -1 : (thisValue==thatValue ? 0 : 1));
    }
}
