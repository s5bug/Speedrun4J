package com.tsunderebug.speedrun4j.game.run;

import com.google.gson.annotations.SerializedName;
import com.tsunderebug.speedrun4j.user.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Status {

	private String status;
	private String examiner;
	private String reason;
	@SerializedName("verify-date") private String verifyDate;

	public String getStatus() {
		return status;
	}

	public User getExaminer() throws IOException {
		return User.fromID(examiner);
	}

	public String getReason() {
		return reason;
	}

	public Date getVerifyDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.parse(verifyDate);
	}
}
