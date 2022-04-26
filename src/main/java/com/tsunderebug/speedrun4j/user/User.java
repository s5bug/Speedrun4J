package com.tsunderebug.speedrun4j.user;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tsunderebug.speedrun4j.Speedrun4J;
import com.tsunderebug.speedrun4j.data.Link;
import com.tsunderebug.speedrun4j.data.Resource;
import com.tsunderebug.speedrun4j.exception.SpeedrunJsonException;
import com.tsunderebug.speedrun4j.exception.SpeedrunUrlException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class User {

	private String id;
	private Map<String, String> names;
	private boolean supporterAnimation;
	private String pronouns;
	private String weblink;
	@SerializedName("name-style") private NameStyle nameStyle;
	private String role;
	private String signup;
	private Location location;
	private Resource twitch;
	private Resource hitbox;
	private Resource youtube;
	private Resource twitter;
	private Resource speedrunslive;
	private Link[] links;
	private UserAssets assets;

	/**
	 * Get user from ID or Username
	 * @param id ID or username
	 * @return speedrun.com User
	 */
	public static User fromID(String id) {

		Gson g = new Gson();
		URL u;

		try {
			u = new URL(Speedrun4J.API_ROOT + "users/" + id);
		} catch (MalformedURLException e) {
			throw new SpeedrunUrlException("Could not get URL from ID.");
		}

		HttpURLConnection c;

		try {
			c = (HttpURLConnection) u.openConnection();
		} catch (IOException e) {
			throw new SpeedrunUrlException("Could not connect to URL from ID.");
		}

		c.addRequestProperty("User-Agent", Speedrun4J.USER_AGENT);
		InputStreamReader r;

		try {
			r = new InputStreamReader(c.getInputStream());
		} catch (IOException e) {
			throw new SpeedrunJsonException("Could not read input from input stream.");
		}

		UserData d = g.fromJson(r, UserData.class);

		try {
			r.close();
		} catch (IOException e) {
			throw new SpeedrunJsonException("Could not close input stream.");
		}

		return d.data;

	}

	/**
	 * Get user from API Key
	 * @see <a href="https://github.com/speedruncomorg/api/blob/master/authentication.md">Authentication Documentation</a>
	 * @param key API key from speedrun.com
	 * @return User from API Key
	 */
	public static User fromApiKey(String key) {

		Gson g = new Gson();
		URL u;

		try {
			u = new URL(Speedrun4J.API_ROOT + "profile");
		} catch (MalformedURLException e) {
			throw new SpeedrunUrlException("Could not get URL from API Key.");
		}

		HttpURLConnection c;

		try {
			c = (HttpURLConnection) u.openConnection();
		} catch (IOException e) {
			throw new SpeedrunUrlException("Could not open URL from API Key.");
		}

		c.addRequestProperty("User-Agent", Speedrun4J.USER_AGENT);
		c.addRequestProperty("X-Api-Key", key);
		InputStreamReader r;

		try {
			r = new InputStreamReader(c.getInputStream());
		} catch (IOException e) {
			throw new SpeedrunJsonException("Could not read input from input stream.");
		}

		UserData d = g.fromJson(r, UserData.class);

		try {
			r.close();
		} catch (IOException e) {
			throw new SpeedrunJsonException("Could not close input stream.");
		}

		return d.data;

	}

	public static class UserAssets {

		private String supporterIcon;
		private Resource icon;
		private Resource image;

		public String getSupporterIcon() {
			return supporterIcon;
		}

		public Resource getIcon() {
			return icon;
		}

		public Resource getImage() {
			return image;
		}
	}

	/**
	 * Returns internal ID from user
	 * @return ID from User
	 */
	public String getId() {
		return id;
	}

	/**
	 * Valid keys: "international", "japanese"
	 * Names can be null
	 * @return A map of locales to user names
	 */
	public Map<String, String> getNames() {
		return names;
	}

	public String getWeblink() {
		return weblink;
	}

	public NameStyle getNameStyle() {
		return nameStyle;
	}

	public String getRole() {
		return role;
	}

	public String getSignup() {
		return signup;
	}

	public Location getLocation() {
		return location;
	}

	public Resource getTwitch() {
		return twitch;
	}

	public Resource getHitbox() {
		return hitbox;
	}

	public Resource getYoutube() {
		return youtube;
	}

	public Resource getTwitter() {
		return twitter;
	}

	public Resource getSpeedrunslive() {
		return speedrunslive;
	}

	public Link[] getLinks() {
		return links;
	}

	public String getPronouns() {
		return pronouns;
	}

	public boolean hasSupporterAnimation() {
		return supporterAnimation;
	}

	public PersonalBests getPBs() {
		return PersonalBests.forUser(this);
	}

	public UserAssets getAssets() {
		return assets;
	}

	private static class UserData{User data;}

}
