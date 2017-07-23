package com.tsunderebug.speedrun4j.user;

import com.google.gson.Gson;
import com.tsunderebug.speedrun4j.Speedrun4J;
import com.tsunderebug.speedrun4j.game.run.PlacedRun;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PersonalBests {

	private PlacedRun[] data;

	public PlacedRun[] getData() {
		return data;
	}

	public static PersonalBests forUser(User user) throws IOException {
		Gson g = new Gson();
		URL u = new URL(Speedrun4J.API_ROOT + "users/" + user.getId() + "/personal-bests");
		HttpURLConnection c = (HttpURLConnection) u.openConnection();
		c.setRequestProperty("User-Agent", Speedrun4J.USER_AGENT);
		InputStreamReader r = new InputStreamReader(c.getInputStream());
		PersonalBests pb = g.fromJson(r, PersonalBests.class);
		r.close();
		return pb;
	}
}
