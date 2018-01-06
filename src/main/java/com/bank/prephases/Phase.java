package com.bank.prephases;

public enum Phase {
	PRE_OPENING("preopening", "opening"), OPENING("preclosing", "closing");

	private String path;
	private String operation;

	private Phase(String path, String operation) {
		this.path = path;
		this.operation = operation;
	}

	public String getPath() {
		return path;
	}

	public String getOperation() {
		return operation;
	}

}
