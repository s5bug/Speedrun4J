package com.tsunderebug.speedrun4j.game.run;

import com.tsunderebug.speedrun4j.user.NameStyle;
import com.tsunderebug.speedrun4j.user.User;

public class Player {

	private String rel;
	private String id;
	private String name;
	private String uri;

	public String getName() {
		return id != null ? User.fromID(id).getNames().get("international") : name;
	}

	public NameStyle getNameStyle() {
		return id != null ? User.fromID(id).getNameStyle() : null;
	}

	public String getRel() {
		return rel;
	}

	public String getId() {
		return id;
	}

	public String getUri() {
		return uri;
	}
}
