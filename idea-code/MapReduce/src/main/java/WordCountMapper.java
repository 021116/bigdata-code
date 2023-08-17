public class WordCountMapper extends Mapper<LongWritable, Text,Text, IntWritable>{
    @Override
    protected void map(LongWritable key,Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] arr = line.split("\\s+");
        for (String word: arr) {
            context.write(new Text(word),new IntWritable(1));
        }
    }
}