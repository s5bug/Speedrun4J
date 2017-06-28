package com.tsunderebug.speedrun4j.game.run;

import com.google.gson.annotations.SerializedName;

public class Ruleset {

	@SerializedName("show-milliseconds") private boolean showMilliseconds;
	@SerializedName("require-verification") private boolean requireVerification;
	@SerializedName("require-video") private boolean requireVideo;
	@SerializedName("run-times") private String[] runTimes;
	@SerializedName("default-time") private String defaultTime;
	@SerializedName("emulators-allowed") private boolean emulatorsAllowed;

}
