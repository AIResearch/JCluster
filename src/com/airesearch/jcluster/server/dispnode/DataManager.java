package com.airesearch.jcluster.server.dispnode;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataManager {
	public void method() {
	}
	
	/**
	 * Test method
	 */
	public static void main(String[] args) {
		// Object to JSON
		JSONObject json_object = new JSONObject();
		json_object.append("Name", "JSON Object");
		json_object.append("Version", "1.00");
		JSONArray arr = new JSONArray();
		arr.put("One");
		arr.put("Two");
		arr.put("Three");
		json_object.append("Array of values", arr);
		int indent_factor = 4;
		System.out.println("Object to JSON:");
		System.out.println(json_object.toString(indent_factor));
		
		// JSON to object
		String json_string = "{\"Name\":[\"JSON Object\"],\"Array of values\""+
		    ":[[\"One\",\"Two\",\"Three\"]],\"Version\":[\"1.00\"]}";
		JSONObject parsed_json_obj = new JSONObject(json_string);
		System.out.println("JSON parsing, converting to string:");
		System.out.println(parsed_json_obj.toString(indent_factor));
	}
}
