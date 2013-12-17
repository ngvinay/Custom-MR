import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Scope ID: RIMS_05.02_ENH_02
public class PatternMatcher {
	
	public static void main(String a[]){
		Pattern pattern=Pattern.compile("(\\d+/\\d+\\d+-\\d+:\\d+\\:\\d+)\\.\\d+");
		//Pattern pattern=Pattern.compile("(((\\d+/\\d+-\\d+\\:\\d+\\:\\d+\\.\\d+)[\\s+]))");
		Matcher matcher=pattern.matcher("2/12/13-06:41:00.153676   [**] [1:407:4] ICMP Destination Unreachable (Undefined Code!) [**] [Classification: Misc activity] [Priority: 3] {ICMP} 192.168.1.110 -> 192.168.1.24 Sent at 4:48 PM on Friday");
		while(matcher.find()){
			System.out.println(matcher.group(1));
		}
	}
}
