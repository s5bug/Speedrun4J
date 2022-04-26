package com.tsunderebug.speedrun4j.user;

import java.util.Map;

public class Location {

	private SubLocation country;
	private SubLocation region;

	public SubLocation getCountry() {
		return country;
	}

	public SubLocation getRegion() {
		return region;
	}

	public static class SubLocation {

		private String code;
		private Map<String, String> names;

		public String getCode() {
			return code;
		}

		public Map<String, String> getNames() {
			return names;
		}

	}

}
