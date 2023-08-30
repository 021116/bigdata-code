import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

public class Capitalize_Letters extends GenericUDF {
    @Override
    public ObjectInspector initialize(ObjectInspector[] objectInspectors) throws UDFArgumentException {
        if (objectInspectors.length != 1) {
            // 说明参数的数量不对
            throw new UDFArgumentException("参数数量错误");
        }
        // 返回值类型检查
        return PrimitiveObjectInspectorFactory.javaStringObjectInspector;
    }

    // 撰写具体代码的地方
    @Override
    public Object evaluate(DeferredObject[] deferredObjects) throws HiveException {
        // 获取传入进来的参数
        String inputString = deferredObjects[0].get().toString();
        // 逻辑处理
        if (inputString == null || inputString.length() == 0){
            return "";
        }
        // abc
        return inputString.toUpperCase();
    }

    // 返回自定义函数的描述
    @Override
    public String getDisplayString(String[] strings) {
        return "该函数可以将大写的字母变为小写";
    }
}
