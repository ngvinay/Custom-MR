package mapreduce.hi.api.input.custom;

import org.apache.hadoop.mapreduce.RecordReader;

import mapreduce.hi.api.input.generic.GenericInputFormat;

public class DefaultInputFormat extends GenericInputFormat<Key, Value>{

	@Override
	protected RecordReader<Key, Value> getRecordReader(
			byte[] recordDelimiterBytes) {		
		return new DefaultRecordReader(recordDelimiterBytes);
	}

}
