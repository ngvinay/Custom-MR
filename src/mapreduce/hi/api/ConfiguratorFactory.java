package mapreduce.hi.api;

import mapreduce.hi.api.interval.custom.CustomConfigurator;
import mapreduce.hi.api.interval.SimpleConfigurator;
import mapreduce.hi.api.interval.db.DBConfigurator;

public class ConfiguratorFactory {
	
	public static Configurator get(String type) {
		Configurators conf = Configurators.valueOf(type);
		if(conf != null){
			switch(conf){
				case simple:
					return new SimpleConfigurator();
				case custom:
					return new CustomConfigurator();
				case db:
					return new DBConfigurator();
			}
		}
		
		return null;
	}
	
}
