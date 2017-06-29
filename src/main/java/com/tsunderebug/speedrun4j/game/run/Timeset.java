package com.tsunderebug.speedrun4j.game.run;

import com.google.gson.annotations.SerializedName;

public class Timeset {

	private String primary;
	@SerializedName("primary_t") private double primaryT;
	private String realtime;
	@SerializedName("realtime_t") private double realtimeT;
	@SerializedName("realtime_noloads") private String realtimeNoloads;
	@SerializedName("realtime_noloads_t") private double realtimeNoloadsT;
	private String ingame;
	@SerializedName("ingame_t") private double ingameT;

	public String getPrimary() {
		return primary;
	}

	public double getPrimaryT() {
		return primaryT;
	}

	public String getRealtime() {
		return realtime;
	}

	public double getRealtimeT() {
		return realtimeT;
	}

	public String getRealtimeNoloads() {
		return realtimeNoloads;
	}

	public double getRealtimeNoloadsT() {
		return realtimeNoloadsT;
	}

	public String getIngame() {
		return ingame;
	}

	public double getIngameT() {
		return ingameT;
	}

}
