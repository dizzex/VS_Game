package com.epam.Volodymyr_Tovazhnianskyi.java.jbehave.enums;

public enum MailData {
	maildropPath ("http://maildrop.cc/"),
	mailRuPath("https://mail.ru/"),
	
	maildropLoginFieldId("nav-inbox"),
	maildropLoginButtonXPath(".//*[@id='nav-form']/button"),
	
	mailRuLoginFieldId("mailbox__login"),
	mailRuPasswordFieldId("mailbox__password"),
	mailRuLoginButtonId("mailbox__auth__button"),
	
	mailRuUnreadMessagesXPath(".//*[@id='b-nav_folders']/div/div[1]/a/span[1]"),
	mailRuNewMessageId("g_mail_events"),
	mailRuNewMessageXPath(".//*[@id='b-toolbar__left']/div/div/div[2]/div/a"),
	mailRuAdressWhereToSendMessageXPath(".//*[@id='compose__header__content']/div[2]/div[2]/div[1]/textarea[2]"),
	mailRuThemeOfTheNewMessageId(".//*[@name='Subject']"),
	
	mailRuMessageBodyIFrameXPath(".//*[@title='{#aria.rich_text_area}']"),
	mailRuBodyOfTheNewMessageId("tinymce"),
	
	mailRuMailWasSendConfirmationXPath(".//*[@id='b-compose__sent']/div/div[1]/div"),
	
	mailRuSendNewMessageXPath(".//*[@id='b-toolbar__right']/div[3]/div/div[2]/div[1]/div"),
	mailRuLogoutButtonIntoMainAccountPageId("PH_logoutLink"),
	mailRuLogoutId("js-mailbox-exit"),
	
	mailRuMessageSentXPath(".//*[@id='b-compose__sent']/div/div[1]/div");
	
	private final String linkPath;
	
	private MailData(String path) {
		this.linkPath=path;
	}
	
	public String getPath(){
		return this.linkPath;
	}
}
