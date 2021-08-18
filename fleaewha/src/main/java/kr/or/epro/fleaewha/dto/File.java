package kr.or.epro.fleaewha.dto;

public class File {
	private int fileID;
	private int productID;
	private String fileURL;
	private int type;
	public File() {}
	public File(int fileID, int productID, String fileURL, int type) {
		this.fileID = fileID;
		this.productID = productID;
		this.fileURL = fileURL;
		this.type = type;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getFileID() {
		return fileID;
	}
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
