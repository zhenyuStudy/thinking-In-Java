/**
 * 
 */
package structure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author lumia
 *
 */
public class TraverseMap {
	
	public void forEachEntries(){
		Map<Integer,Integer> maps = new HashMap<Integer, Integer>();
		for(Map.Entry<Integer, Integer> entry : maps.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
	}
	
	public void forEachKeyValues() {
		Map<Integer,Integer> maps = new HashMap<Integer, Integer>();
		for(Integer key: maps.keySet()) {
			System.out.println("key = "+key);
		}
		for(Integer value: maps.values()) {
			System.out.println(maps.values());
		}
	}
	
	public void useGenerics() {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
		while(entries.hasNext()) {
			System.out.println("key = " + entries.next().getKey() + ", value = " + entries.next().getValue());
		}
	}
	
	public void noUseGenerics() {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		Iterator entries = map.entrySet().iterator();
		while(entries.hasNext()) {
			Map.Entry entry = (Entry) entries.next();
			Integer key = (Integer) entry.getKey();
			Integer value = (Integer) entry.getValue();
			System.out.println("Key = " + key + ", Value = " + value);
		}
	}

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
