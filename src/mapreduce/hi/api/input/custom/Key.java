package mapreduce.hi.api.input.custom;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import mapreduce.hi.api.input.generic.KeyWritable;

public class Key extends KeyWritable<Key>{

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Key o) {
		// TODO Auto-generated method stub
		return this.bytesRead > o.bytesRead ?1:(this.bytesRead == o.bytesRead ? 0:-1);
	}

}
