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

	public String getId() {
		return id;
	}

	/**
	 * Valid keys: "international", "japanese", "twitch"
	 * Names can be null
	 * @return A map of locales to game names
	 */
	public Map<String, String> getNames() {
		return names;
	}

	/**
	 * An abbreviation of the name, e.g. "smw" for Super Mario World
	 * @return An abbreviation of the name
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * The location of the game on Speedrun.com
	 * @return The url of the game page on Speedrun.com
	 */
	public String getWeblink() {
		return weblink;
	}

	/**
	 * The year the game was released. For day and month, see getReleaseDate
	 * @return The release year of the game
	 */
	public int getReleased() {
		return released;
	}

	/**
	 * @return Release date of the game in YYYY-MM-DD
	 */
	public String getReleaseDate() {
		return releaseDate;
	}

	public Ruleset getRuleset() {
		return ruleset;
	}

	/**
	 * @deprecated use getGametypes instead
	 * @return whetger the game is a romhack
	 */
	@Deprecated public boolean isRomhack() {
		return romhack;
	}

	public String[] getGametypes() {
		return gametypes;
	}

	public String[] getPlatforms() { // TODO return array of Platform objects
		return platforms;
	}

	public String[] getRegions() { // TODO return array of Region objects
		return regions;
	}

	public String[] getGenres() {
		return genres;
	}

	public String[] getEngines() {
		return engines;
	}

	public String[] getDevelopers() {
		return developers;
	}

	public String[] getPublishers() {
		return publishers;
	}

	public Map<String, String> getModerators() { // TODO return map of User to ModeratorStatus
		return moderators;
	}

	/**
	 * @return when the game page was created in YYYY-MM-DDTHH:MM:SSZ
	 */
	public String getCreated() {
		return created;
	}

	public GameAssets getAssets() {
		return assets;
	}

	public Link[] getLinks() {
		return links;
	}

}
