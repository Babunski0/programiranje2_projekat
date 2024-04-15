package me.fit.enums;

public enum ClanStatus {
	EXISTS("Clan vec postoji");
	
	private String label;

	private ClanStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
