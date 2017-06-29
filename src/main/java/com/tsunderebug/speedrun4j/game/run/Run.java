package com.tsunderebug.speedrun4j.game.run;

import com.tsunderebug.speedrun4j.data.Link;
import com.tsunderebug.speedrun4j.data.Videos;
import com.tsunderebug.speedrun4j.platform.System;

import java.util.Map;

public class Run {

	private String id;
	private String weblink;
	private String game;
	private String level;
	private String category;
	private Videos videos;
	private String comment;
	private Status status;
	private Player[] players;
	private String date;
	private String submitted;
	private Map<String, String> times;
	private System system;
	private Link splits;
	private Map<String, String> values;

	public String getId() {
		return id;
	}

	public String getWeblink() {
		return weblink;
	}

	public Videos getVideos() {
		return videos;
	}

	public String getComment() {
		return comment;
	}

	public Status getStatus() {
		return status;
	}

	public Player[] getPlayers() {
		return players;
	}

	public String getDate() {
		return date;
	}

	public String getSubmitted() {
		return submitted;
	}

	public Map<String, String> getTimes() {
		return times;
	}

	public System getSystem() {
		return system;
	}

	public Link getSplits() {
		return splits;
	}

	public Link[] getLinks() {
		return links;
	}

	private Link[] links;

}
