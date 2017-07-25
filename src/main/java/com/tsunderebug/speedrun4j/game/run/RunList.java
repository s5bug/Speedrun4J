package com.tsunderebug.speedrun4j.game.run;

import com.google.gson.Gson;
import com.tsunderebug.speedrun4j.Speedrun4J;
import com.tsunderebug.speedrun4j.game.Category;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RunList {

	private Run[] data;

	public static RunList forStatus(Category cat, String status) throws IOException {
		Gson g = new Gson();
		URL u = new URL(Speedrun4J.API_ROOT + "runs?category=" + cat.getId() + "&status=" + status);
		HttpURLConnection c = (HttpURLConnection) u.openConnection();
		c.addRequestProperty("User-Agent", Speedrun4J.USER_AGENT);
		InputStreamReader r = new InputStreamReader(c.getInputStream());
		RunList l = g.fromJson(r, RunList.class);
		r.close();
		return l;
	}

	public Run[] getRuns() {
		return data;
	}

}
