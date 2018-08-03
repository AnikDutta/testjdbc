package com.rci.cat.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class BaseJsonDto implements Serializable {
	
	public abstract JSONObject getJson();
	
	public String toString() {
		return getJson().toString();
	}
	
	public String toString(int type) {
		return getJson().toString(type);
	}
	
	public void putINL(JSONObject json, String key, String data) {
		if(data != null && !data.isEmpty()) {
			json.put(key, data);
		}
	}	
	public void putINL(JSONObject json, String key, String[] data) {
		if(data != null && data.length > 0) {
			json.put(key, data);
		}
	}
		
	public void putINL(JSONObject json, String key, Boolean data) {
		if(data != null ) {
			json.put(key, data);
		}
	}
	public void putINL(JSONObject json, String key, Boolean[] data) {
		if(data != null && data.length > 0) {
			json.put(key, data);
		}
	}
	
	
	public void putINL(JSONObject json, String key, Integer data) {
		if(data != null) {
			json.put(key, data);
		}
	}
	public void putINL(JSONObject json, String key, Integer[] data) {
		if(data != null && data.length > 0) {
			json.put(key, data);
		}
	}
	
	
	public void putINL(JSONObject json, String key, Long data) {
		if(data != null) {
			json.put(key, data);
		}
	}
	public void putINL(JSONObject json, String key, Long[] data) {
		if(data != null && data.length > 0) {
			json.put(key, data);
		}
	}
	
	public void putINL(JSONObject json, String key, Double data) {
		if(data != null) {
			json.put(key, data);
		}
	}
	public void putINL(JSONObject json, String key, Double[] data) {
		if(data != null && data.length > 0) {
			json.put(key, data);
		}
	}
	
	public void putINL(JSONObject json, String key, List<?> data) {
		if(data != null && !data.isEmpty()) {
			json.put(key, data);
		}
	}
	
	public void putINL(JSONObject json, String key, Map<?,?> data) {
		if(data != null && !data.isEmpty()) {			
			json.put(key, data);
		}
	}
	
	public void putINL(JSONObject json, String key, JSONObject data) {
		if(data != null && !data.keySet().isEmpty()) {			
			json.put(key, data);
		}
	}
	
	public void putINL(JSONObject json, String key, BaseJsonDto data) {
		JSONObject dataJson = null;
		if(data != null) {
			dataJson = data.getJson();
			if(dataJson != null && !dataJson.keySet().isEmpty()) {			
				json.put(key, dataJson);
			}
		}		
	}
	
	public void putINL(JSONObject json, String key, JSONArray data) {
		if(data != null && data.length() > 0) {			
			json.put(key, data);
		}
	}
	
	public static List<String> getStringList(JSONArray data) {
		List<String> list = new ArrayList<String>(2);
		data.forEach(item -> {
			list.add( (String)item );
		});
		return list;
	}
	
	public static List<Long> getLongList(JSONArray data) {
		List<Long> list = new ArrayList<Long>(2);
		data.forEach(item -> {
			list.add( (Long)item );
		});
		return list;
	}
	
	public static List<Double> getDoubleList(JSONArray data) {
		List<Double> list = new ArrayList<Double>(2);
		data.forEach(item -> {
			list.add( (Double)item );
		});
		return list;
	}
	
	public static List<Integer> getIntegerList(JSONArray data) {
		List<Integer> list = new ArrayList<Integer>(2);
		data.forEach(item -> {
			list.add( (Integer)item );
		});
		return list;
	}
	
	public static List<Boolean> getBooleanList(JSONArray data) {
		List<Boolean> list = new ArrayList<Boolean>(2);
		data.forEach(item -> {
			list.add( (Boolean)item );
		});
		return list;
	}
	
	public static Map<String, Object> getMap(JSONObject data) {
		Map<String, Object> map = new HashMap<String, Object>(2);
		data.keySet().forEach(keyObj -> {
			map.put(keyObj, data.get(keyObj));
		});
		
		return map;
	}
	
	public static JSONArray getJSONArray(List<? extends BaseJsonDto> list) {
		JSONArray array = new JSONArray();
		if(list != null) {
			for(BaseJsonDto item: list) {
				array.put(item.getJson());
			}
		}
				
		return array;
	}
	

}
