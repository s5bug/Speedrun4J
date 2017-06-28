package com.tsunderebug.speedrun4j.game;

import com.google.gson.annotations.SerializedName;
import com.tsunderebug.speedrun4j.data.Link;

import java.util.Map;

public class Game {

	private String id;
	private Map<String, String> names;
	private String abbreviation;
	private String weblink;
	private int released;
	@SerializedName("release-date") private String releaseDate;
	private Ruleset ruleset;
	@Deprecated private boolean romhack;
	private String[] gametypes;
	private String[] platforms;
	private String[] regions;
	private String[] genres;
	private String[] engines;
	private String[] developers;
	private String[] publishers;
	private Map<String, String> moderators;
	private String created; // TODO is this a string?
	private GameAssets assets;
	private Link[] links;

}
