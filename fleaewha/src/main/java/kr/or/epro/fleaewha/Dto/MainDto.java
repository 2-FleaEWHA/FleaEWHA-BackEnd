package kr.or.epro.fleaewha.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class MainDto {

	private String title;
	private int price;
	private String fileID;
	
	@JsonFormat(shape = Shape.STRING)
	private Date createTime;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFileID() {
		return fileID;
	}
	public void setFileID(String fileID) {
		this.fileID = fileID;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "MainDto [title=" + title + ", price=" + price + ", fileID=" + fileID + ", createTime=" + createTime
				+ "]";
	}
	
	
	
}
