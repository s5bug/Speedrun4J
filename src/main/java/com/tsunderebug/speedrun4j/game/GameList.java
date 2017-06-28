package com.tsunderebug.speedrun4j.game;

import com.google.gson.Gson;
import com.tsunderebug.speedrun4j.Speedrun4J;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class GameList {

	private Game[] data;

	public static GameList withName(String name) throws IOException {
		Gson g = new Gson();
		InputStreamReader r = new InputStreamReader(new URL(Speedrun4J.API_ROOT + "/games?name=" + name).openStream());
		GameList l = g.fromJson(r, GameList.class);
		r.close();
		return l;
	}

	public Game[] getGames() {
		return data;
	}

}
