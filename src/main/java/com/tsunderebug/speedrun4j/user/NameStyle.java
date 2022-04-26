package com.tsunderebug.speedrun4j.user;

import com.google.gson.annotations.SerializedName;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NameStyle {

	private String style;
	@SerializedName("color-from") private Map<String, String> colorFrom;
	@SerializedName("color-to") private Map<String, String> colorTo;

	public String getStyle() {
		return style;
	}

	public Map<String, String> getColorFrom() {
		return colorFrom;
	}

	public Map<String, String> getColorTo() {
		return colorTo;
	}
}
