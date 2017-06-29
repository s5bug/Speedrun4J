package com.tsunderebug.speedrun4j.user;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class NameStyle {

	private String style;
	private Map<String, String> color;
	@SerializedName("color-from") private Map<String, String> colorFrom;
	@SerializedName("color-to") private Map<String, String> colorTo;

}
