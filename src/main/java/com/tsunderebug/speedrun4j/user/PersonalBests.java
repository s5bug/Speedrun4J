package com.tsunderebug.speedrun4j.user;

import com.google.gson.Gson;
import com.tsunderebug.speedrun4j.Speedrun4J;
import com.tsunderebug.speedrun4j.game.run.PlacedRun;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PersonalBests {

	private PlacedRun[] data;

	public PlacedRun[] getData() {
		return data;
	}

	public static PersonalBests forUser(User user) throws IOException {
		Gson g = new Gson();
		InputStreamReader r = new InputStreamReader(new URL(Speedrun4J.API_ROOT + "users/" + user.getId() + "/personal-bests").openStream());
		PersonalBests pb = g.fromJson(r, PersonalBests.class);
		r.close();
		return pb;
	}
}
