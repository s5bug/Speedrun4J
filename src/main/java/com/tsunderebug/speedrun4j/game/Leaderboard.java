package com.tsunderebug.speedrun4j.game;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tsunderebug.speedrun4j.Speedrun4J;
import com.tsunderebug.speedrun4j.data.Link;
import com.tsunderebug.speedrun4j.game.run.PlacedRun;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

public class Leaderboard {

	private String weblink;
	private String game;
	private String category;

	private String level;
	private String platform;
	private String region;
	private boolean emulators;
	@SerializedName("video-only") private boolean videoOnly;
	private String timing;
	private Map<String, String> values;
	private PlacedRun[] runs;
	private Link[] links;

	public static Leaderboard forCategory(Category c) throws IOException {
		Gson g = new Gson();
		InputStreamReader r = new InputStreamReader(new URL(Speedrun4J.API_ROOT + "leaderboards/" + c.getGame().getId() + "/category/" + c.getId()).openStream());
		Leaderboard l = g.fromJson(r, Leaderboard.class);
		r.close();
		return l;
	}

	public String getLevel() {
		return level;
	}

	public boolean isEmulators() {
		return emulators;
	}

	public boolean isVideoOnly() {
		return videoOnly;
	}

	public String getTiming() {
		return timing;
	}

	public PlacedRun[] getRuns() {
		return runs;
	}

	public Link[] getLinks() {
		return links;
	}

}
