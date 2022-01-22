package com.datamining.util;

public enum EnumConfig {
	
	PASSWORD_REPEAT("ZPasswordRepeat"),
	PASSWORD_EXPIRED_DAYS("ZPasswordExpiredDays"),
	SMTP_SERVER("ZSMTPServer"),
	SMTP_PORT("ZSMTPPort"),
	SMTP_ACCOUNT("ZSMTPAccount"),
	SMTP_PASSWORD("ZSMTPPassword"),
	SMTP_REPLY_TO("ZSMTPReplyTo"),
	MAIL_DOMAIN("ZMailDomain"),
	WRONG_PASSWORD_LOCK("ZWrongPasswordLock"),
	DATA_RETENTION_DAYS("DataRetentionDays"),
	LOG_LIST("LogList"),
	LOG_CREATE("LogCreate"),
	LOG_UPDATE("LogUpdate"),
	LOG_DELETE("LogDelete"),
	PENDING_REQUEST_DAYS("PendingRequestDays"),
	UPLOAD_LOG_INQ_DATE_TIME_FORMATTER("UploadLogInqDateTimeFormatter"),
	INTERVAL_HOURS_GROUPING_INQUIRY_LOG("IntervalHoursGroupingInquiryLog"),
	DIRECTORS_NAME("DirectorsName"),
	RUN_PROCESS_LOG_INQUIRY("RunProcessLogInquiry"),
	RUN_PROCESS_LOG_ALERT_CSV("RunProcessLogAlertCsv"),
	RUN_PROCESS_LOG_ALERT_ZIP("RunProcessLogAlertZip"),
	;
	
	private String configName;
	
	EnumConfig(String configName){
		this.configName=configName;
	}

	public String getConfigName() {
		return configName;
	}	
}
