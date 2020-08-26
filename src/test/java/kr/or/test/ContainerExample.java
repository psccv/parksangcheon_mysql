package kr.or.test;

import java.util.HashMap;
import java.util.Map;

public class ContainerExample {

	public static void main(String[] args) {
		Container<String,String> containerVo1 = new Container<String,String>();
		
		containerVo1.set("name", "홍길동");
		String nameKey = containerVo1.getKey();
		String nameValue = containerVo1.getValue();
		System.out.print(nameKey+" : "+nameValue);
		
		Container<String,Integer> containerVo2 = new Container<String,Integer>();
		
		containerVo2.set("age",6);
		String ageKey = containerVo2.getKey();
		int ageValue = containerVo2.getValue();
		System.out.print("\n"+ageKey+" : "+ageValue+"세");
		
		Map<String,String> hashMap = new HashMap<>();
		
		hashMap.put("name", "파이리");
		hashMap.put("age", "3");
		
		System.out.println("\n"+hashMap);
		System.out.println(hashMap.get("name"));
		System.out.println(hashMap.get("age"));
		
	}

}

class Container<K,V> {
	private K key;
	private V value;
	
	public void set(K key, V value) {
		this.key = key;
		this.value=value;
	}
	
	public K getKey() {
		return this.key;
	}
	public V getValue() {
		return this.value;
	}
	
}