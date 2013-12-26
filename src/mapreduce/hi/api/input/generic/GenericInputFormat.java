package mapreduce.hi.api.input.generic;

import java.io.IOException;

import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

public abstract class GenericInputFormat<K extends KeyWritable<K>,V extends BufferedValueWritable<V>> extends FileInputFormat<K, V>{

	@Override
	public RecordReader<K, V> createRecordReader(InputSplit split,
			TaskAttemptContext context) throws IOException, InterruptedException {
		
		 String delimiter = context.getConfiguration().get( "inputformat.record.delimiter");
	    byte[] recordDelimiterBytes = null;
	    if (null != delimiter)
	      recordDelimiterBytes = delimiter.getBytes();
	    return getRecordReader(recordDelimiterBytes);
	}

	protected abstract RecordReader<K, V> getRecordReader(byte[] recordDelimiterBytes);

}
