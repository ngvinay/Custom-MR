package mapreduce.hi.api.generic.io;

import org.apache.hadoop.io.WritableComparable;

public abstract class KeyWritable<K> implements WritableComparable<K>{
	protected long bytesRead;

	public long getBytesRead() {
		return bytesRead;
	}

	public void setBytesRead(long bytesRead) {
		this.bytesRead = bytesRead;
	}
	
}
