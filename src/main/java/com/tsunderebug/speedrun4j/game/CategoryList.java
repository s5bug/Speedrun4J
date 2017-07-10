package com.tsunderebug.speedrun4j.game;

import com.google.gson.Gson;
import com.tsunderebug.speedrun4j.Speedrun4J;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CategoryList {

	private Category[] data;

	public static CategoryList forGame(Game g) throws IOException {
		Gson gson = new Gson();
		URL u = new URL(Speedrun4J.API_ROOT + "games/" + g.getId() + "/categories");
		HttpURLConnection c = (HttpURLConnection) u.openConnection();
		c.setRequestProperty("User-Agent", Speedrun4J.USER_AGENT);
		InputStreamReader r = new InputStreamReader(c.getInputStream());
		CategoryList cl = gson.fromJson(r, CategoryList.class);
		r.close();
		return cl;
	}

	public Category[] getCategories() {
		return data;
	}

}
