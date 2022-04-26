package com.tsunderebug.speedrun4j.game.run;

import com.tsunderebug.speedrun4j.user.NameStyle;
import com.tsunderebug.speedrun4j.user.User;

import java.awt.*;
import java.io.IOException;

public class Player {

	private String rel;
	private String id;
	private String name;
	private String uri;

	public String getName() {
		if (id != null) {
			return User.fromID(id).getNames().get("international");
		} else {
			return name;
		}
	}

	public NameStyle getNameStyle() {
		if (id != null) {
			return User.fromID(id).getNameStyle();
		} else {
			return null;
		}
	}

}
