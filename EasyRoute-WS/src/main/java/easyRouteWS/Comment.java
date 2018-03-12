package easyRouteWS;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	
	private String comment;
	private int idPoint;
	
	public Comment(){
		
	}
	
	public Comment(int id, String comment){
		this.idPoint = id;
		this.comment = comment;
	}
	
	public String getComment() {
		return comment.toString();
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getIdPoint() {
		return idPoint;
	}
	public void setIdPoint(int idPoint) {
		this.idPoint = idPoint;
	}
}
