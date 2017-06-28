package com.tsunderebug.speedrun4j.game.run;

import com.google.gson.annotations.SerializedName;

public class Status {

	private String status;
	private String examiner;
	private String reason;
	@SerializedName("verify-date") private String verifyDate;

}
