package com.fmv.reg.misc.constants;

public class AppConstants {
	
	private AppConstants() {}
	
	public enum Status {
		SUCCESS("SUCCESS"),
		FAILED("FAILED"),
		ERROR("ERROR");
		
		public final String value;
		
		private Status(String value) {
			this.value = value;
		}
	}
	
	public enum Message {
		SEARCH_SUCCESS_MESSAGE("Data was successfully retrieved from DB."),
		ADD_SUCCESS_MESSAGE("Activity was successfully added."),
		UPDATE_SUCCESS_MESSAGE("Activity was successfully updated."),
		DELETE_SUCCESS_MESSAGE("Activity was successfully deleted from DB."),
		FAILED("DB data retrieval has failed. "),
		ERROR("DB data retrieval resulted in error.");
		
		public final String value;
		
		private Message(String value) {
			this.value = value;
		}
	}

}
