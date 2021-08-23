package kr.or.epro.fleaewha.chat;

import java.util.Date;

public class Message {

    private String username;
    private String content;
    private Date date;

    public Message(String username, String content, Date date) {
        this.setUsername(username);
        this.setContent(content);
        this.setDate(date);
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}