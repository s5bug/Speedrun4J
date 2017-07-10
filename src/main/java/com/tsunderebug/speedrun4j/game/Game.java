package com.tsunderebug.speedrun4j.game;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tsunderebug.speedrun4j.Speedrun4J;
import com.tsunderebug.speedrun4j.data.Link;
import com.tsunderebug.speedrun4j.game.run.Ruleset;
import com.tsunderebug.speedrun4j.user.ModeratorType;
import com.tsunderebug.speedrun4j.user.User;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Game {

	private String id;
	private Map<String, String> names;
	private String abbreviation;
	private String weblink;
	private int released;
	@SerializedName("release-date")
	private String releaseDate;
	private Ruleset ruleset;
	@Deprecated
	private boolean romhack;
	private String[] gametypes;
	private String[] platforms;
	private String[] regions;
	private String[] genres;
	private String[] engines;
	private String[] developers;
	private String[] publishers;
	private Map<String, String> moderators;
	private String created;
	private GameAssets assets;
	private Link[] links;

	public static Game fromID(String id) throws IOException {
		Gson g = new Gson();
		URL u = new URL(Speedrun4J.API_ROOT + "games/" + id);
		HttpURLConnection c = (HttpURLConnection) u.openConnection();
		c.setRequestProperty("User-Agent", Speedrun4J.USER_AGENT);
		InputStreamReader r = new InputStreamReader(c.getInputStream());
		GameData game = g.fromJson(r, GameData.class);
		r.close();
		return game.data;
	}

	public String getId() {
		return id;
	}

	/**
	 * Valid keys: "international", "japanese", "twitch"
	 * Names can be null
	 *
	 * @return A map of locales to game names
	 */
	public Map<String, String> getNames() {
		return names;
	}

	/**
	 * An abbreviation of the name, e.g. "smw" for Super Mario World
	 *
	 * @return An abbreviation of the name
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * The location of the game on Speedrun.com
	 *
	 * @return The url of the game page on Speedrun.com
	 */
	public String getWeblink() {
		return weblink;
	}

	/**
	 * The year the game was released. For day and month, see getReleaseDate
	 *
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
	 * @return whetger the game is a romhack
	 * @deprecated use getGametypes instead
	 */
	@Deprecated
	public boolean isRomhack() {
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

	public Map<User, ModeratorType> getModerators() throws IOException {
		Map<User, ModeratorType> modMap = new HashMap<>();
		for (Map.Entry<String, String> e : moderators.entrySet()) {
			User u = User.fromID(e.getKey());
			ModeratorType m = null;
			String modType = e.getValue();
			if (modType.equals("moderator")) {
				m = ModeratorType.MODERATOR;
			} else if (modType.equals("super-moderator")) {
				m = ModeratorType.SUPER_MODERATOR;

			}
			modMap.put(u, m);
		}
		return modMap;
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

	public CategoryList getCategories() throws IOException {
		return CategoryList.forGame(this);
	}

	private static class GameData {
		Game data;
	}

}
