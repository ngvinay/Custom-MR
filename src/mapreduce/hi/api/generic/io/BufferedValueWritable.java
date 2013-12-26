package mapreduce.hi.api.generic.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import org.apache.hadoop.io.WritableComparable;

public abstract class BufferedValueWritable<V> implements WritableComparable<V>{
	protected ByteBuffer buff;
	public BufferedValueWritable(){
		
	}
	public BufferedValueWritable(int defaultBufferSize) {
		buff = ByteBuffer.allocate(defaultBufferSize);
	}
	public void put(byte buffer[], int startPosn, int appendLength){
		buff.put(buffer, startPosn, appendLength);
	}
	public void read() throws IOException {
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(this.buff.array(),0,this.buff.position()));
		readFields(in);
		in.close();
	}
	public void read(int start,int end) throws IOException{
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(this.buff.array(),start,end));
		readFields(in);
		in.close();
	}
	public void clear() {
		if(this.buff != null){
			this.buff.clear();
		}
		
	}
	public ByteBuffer getBuff() {
		return buff;
	}
	
}
