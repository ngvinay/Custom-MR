package mapreduce.hi.api.input.custom;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import mapreduce.hi.api.input.generic.BufferedValueWritable;

public class Value extends BufferedValueWritable<Value>{

	public Value(int defaultBufferSize) {
		super(defaultBufferSize);
	}

	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Value o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
