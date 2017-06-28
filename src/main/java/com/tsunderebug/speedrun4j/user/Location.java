package com.tsunderebug.speedrun4j.user;

import java.util.Map;

public class Location {

	private SubLocation country;
	private SubLocation region;

	private static class SubLocation {

		private String code;
		private Map<String, String> names;

	}
}
