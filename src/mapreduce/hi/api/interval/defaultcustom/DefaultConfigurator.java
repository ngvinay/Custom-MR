package mapreduce.hi.api.interval.defaultcustom;

import java.io.IOException;
import java.util.ArrayList;

import mapreduce.hi.HIKey;
import mapreduce.hi.api.ChainConfigurator;
import mapreduce.hi.api.Configurator;
import mapreduce.hi.api.input.CustomInputFormat;
import mapreduce.hi.api.input.defaultcustom.DefaultInputFormat;
import mapreduce.hi.api.input.defaultcustom.Value;
import mapreduce.hi.api.output.CustomOutputFormat;
import mapreduce.hi.api.output.defaultcustom.DefaultOutputFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.LazyOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.NullOutputFormat;

import com.radiant.cisms.hdfs.seq.HInfoWritable;

public class DefaultConfigurator implements Configurator {

	@Override
	public Job getJob(Configuration conf) throws IOException {
		Job job = new Job(conf, "INTERVAL_LEVEL");
		job.setJarByClass(ChainConfigurator.class);
		job.setInputFormatClass(DefaultInputFormat.class);
		job.setMapperClass(DefaultMapper.class);
		job.setCombinerClass(DefaultCombiner.class);
		job.setReducerClass(DefaultReducer.class);
		job.setOutputKeyClass(HIKey.class);
		job.setOutputValueClass(Value.class);
		job.setOutputFormatClass(NullOutputFormat.class);
		return job;
	}

	@Override
	public Job getJob(Configuration conf, String[] otherArgs) throws IOException {
		
		if (otherArgs.length != 2) {
			System.err
					.println("Usage: Comment <in1 path> <out1 path>");
			System.exit(2);
		}
		
		ChainConfigurator.delete(otherArgs[1], conf);
		
		Job job = getJob(conf);
		// CombineInputFormat.addInputPath(job, new Path(otherArgs[0]));
		CustomInputFormat.setInputPaths(job, otherArgs[0]);
		LazyOutputFormat.setOutputFormatClass(job, DefaultOutputFormat.class);
		CustomOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		//FileOutputFormat.setOutputPath(valueJob, new Path(otherArgs[3]));
		return job;
	}

}
