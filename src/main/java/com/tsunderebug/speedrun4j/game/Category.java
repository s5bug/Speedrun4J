package com.tsunderebug.speedrun4j.game;

import com.tsunderebug.speedrun4j.data.Link;
import com.tsunderebug.speedrun4j.game.run.Playtype;

import java.io.IOException;
import java.util.Arrays;

public class Category {

	private String id;
	private String name;
	private String weblink;
	private String type;
	private String rules;
	private Playtype players;
	private boolean miscellaneous;
	private Link[] links;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getWeblink() {
		return weblink;
	}

	public String getType() {
		return type;
	}

	public String getRules() {
		return rules;
	}

	public Playtype getPlayers() {
		return players;
	}

	public boolean isMiscellaneous() {
		return miscellaneous;
	}

	public Link[] getLinks() {
		return links;
	}

	public Game getGame() throws IOException {
		String uri = Arrays.stream(links).filter((Link l) -> "game".equals(l.getRel())).findFirst().get().getUri();
		return Game.fromID(uri.substring(uri.lastIndexOf('/') + 1));
	}

}
