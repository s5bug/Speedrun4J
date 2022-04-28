package com.tsunderebug.speedrun4j.user;

import com.google.gson.Gson;
import com.tsunderebug.speedrun4j.Speedrun4J;
import com.tsunderebug.speedrun4j.exception.SpeedrunJsonException;
import com.tsunderebug.speedrun4j.exception.SpeedrunUrlException;
import com.tsunderebug.speedrun4j.game.run.PlacedRun;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PersonalBests {

	private PlacedRun[] data;

	public PlacedRun[] getData() {
		return data;
	}

	public static PersonalBests forUser(User user) {

		Gson g = new Gson();
		URL u;

		try {
			u = new URL(Speedrun4J.API_ROOT + "users/" + user.getId() + "/personal-bests");
		} catch (MalformedURLException e) {
			throw new SpeedrunUrlException("Could not get URL from API Key.");
		}

		HttpURLConnection c;

		try {
			c = (HttpURLConnection) u.openConnection();
		} catch (IOException e) {
			throw new SpeedrunUrlException("Could not open URL from API Key.");
		}

		c.setRequestProperty("User-Agent", Speedrun4J.USER_AGENT);
		InputStreamReader r;

		try {
			r = new InputStreamReader(c.getInputStream());
		} catch (IOException e) {
			throw new SpeedrunJsonException("Could not read input from input stream.");
		}

		PersonalBests pb = g.fromJson(r, PersonalBests.class);

		try {
			r.close();
		} catch (IOException e) {
			throw new SpeedrunJsonException("Could not close input stream.");
		}

		return pb;
	}
}
