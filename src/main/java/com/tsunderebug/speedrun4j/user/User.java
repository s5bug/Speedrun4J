package com.tsunderebug.speedrun4j.user;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tsunderebug.speedrun4j.Speedrun4J;
import com.tsunderebug.speedrun4j.data.Link;
import com.tsunderebug.speedrun4j.data.Resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

public class User {

	private String id;
	private Map<String, String> names;
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

	public static User fromID(String id) throws IOException {
		Gson g = new Gson();
		InputStreamReader r = new InputStreamReader(new URL(Speedrun4J.API_ROOT + "users/" + id).openStream());
		UserData d = g.fromJson(r, UserData.class);
		r.close();
		return d.data;
	}

	private static class UserData{User data;}

}
