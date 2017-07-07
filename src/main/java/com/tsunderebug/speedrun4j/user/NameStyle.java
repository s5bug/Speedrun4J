package com.tsunderebug.speedrun4j.user;

import com.google.gson.annotations.SerializedName;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NameStyle {

	private String style;
	private Map<String, String> color;
	@SerializedName("color-from") private Map<String, String> colorFrom;
	@SerializedName("color-to") private Map<String, String> colorTo;

	public Color getColor() {
		List<Color> c = color.values().stream().map(s -> new Color(Integer.parseInt(s.substring(1), 16))).collect(Collectors.toList());
		List<Color> cf = colorFrom.values().stream().map(s -> new Color(Integer.parseInt(s.substring(1), 16))).collect(Collectors.toList());
		List<Color> ct = colorTo.values().stream().map(s -> new Color(Integer.parseInt(s.substring(1), 16))).collect(Collectors.toList());
		List<Color> all = new ArrayList<>();
		all.addAll(c);
		all.addAll(cf);
		all.addAll(ct);
		int r = 0;
		int g = 0;
		int b = 0;
		for(Color col : all) {
			r += col.getRed();
			g += col.getGreen();
			b += col.getBlue();
		}
		return new Color(r / all.size(), g / all.size(), b / all.size());
	}

}
