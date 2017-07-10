package com.tsunderebug.speedrun4j.game;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tsunderebug.speedrun4j.Speedrun4J;
import com.tsunderebug.speedrun4j.data.Link;
import com.tsunderebug.speedrun4j.game.run.PlacedRun;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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
	@SerializedName("video-only")
	private boolean videoOnly;
	private String timing;
	private Map<String, String> values;
	private PlacedRun[] runs;
	private Link[] links;

	public static Leaderboard forCategory(Category c) throws IOException {
		Gson g = new Gson();
		URL u = new URL(Speedrun4J.API_ROOT + "leaderboards/" + c.getGame().getId() + "/category/" + c.getId());
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setRequestProperty("User-Agent", Speedrun4J.USER_AGENT);
		InputStreamReader r = new InputStreamReader(conn.getInputStream());
		LeaderboardData l = g.fromJson(r, LeaderboardData.class);
		r.close();
		return l.data;
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

	private static class LeaderboardData {
		Leaderboard data;
	}

}
