package kr.or.epro.fleaewha.dto;

public class ChatMessageDTO {
	private String roodId;
	private String writer;
	private String message;
	
	public String getRoodId() {
		return roodId;
	}
	public void setRoodId(String roodId) {
		this.roodId = roodId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
