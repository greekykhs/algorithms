package com.algo.caching;

import java.util.*;
public class LFUCache {
	//map to get and put data O(1)
    HashMap<Integer, Integer> keyValueMap; //Key, Value
    //Map to store the counter to keep track number of times a Key has been accessed
    HashMap<Integer, Integer> keyCounterMap;//Key, Count
    //Map to store the counter and list of items
    HashMap<Integer, LinkedHashSet<Integer>> lists;//Counter and item list
    
    int capacity;
    int min = -1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyValueMap = new HashMap<>();
        keyCounterMap = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

	public int get(int key) {
		if (!keyValueMap.containsKey(key))
			return -1;
		// Get the count from counts map
		int count = keyCounterMap.get(key);
		//increment the counter
		keyCounterMap.put(key, count + 1);
		//remove the element from the counter to linkedhashset
		lists.get(count).remove(key);

		// when current min does not have any data, next one would be the min
		if (count == min && lists.get(count).size() == 0)
			min++;
		if (!lists.containsKey(count + 1))
			lists.put(count + 1, new LinkedHashSet<>());
		lists.get(count + 1).add(key);
		return keyValueMap.get(key);
	}

	public void set(int key, int value) {
		if (capacity <= 0)
			return;
		//check if key is already present
		if (keyValueMap.containsKey(key)) {
			//update the value
			keyValueMap.put(key, value);
			//get is called so that it can increment the count
			get(key);
			return;
		}
		//remove if the capacity is exceeded
		if (keyValueMap.size() >= capacity) {
			int evict = lists.get(min).iterator().next();
			lists.get(min).remove(evict);
			keyValueMap.remove(evict);
			keyCounterMap.remove(evict);
		}
		//If the key is new, insert the value, set min to 1
		keyValueMap.put(key, value);
		keyCounterMap.put(key, 1);
		min = 1;
		lists.get(1).add(key);
	}
}