package easyRouteWS;

import java.io.FileInputStream;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Point {	
	
	private int id;
	private double latitude;
	private double longitude;
	private int accessType;
	private String pointTitle;
	private FileInputStream IMAGEM;
	
	public Point() {
		
	}
	
	public Point(int id, double latitude, double longitude, int accessType, String pointTitle) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.accessType = accessType;
		this.pointTitle = pointTitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getAccessType() {
		return accessType;
	}

	public void setAccessType(int accessType) {
		this.accessType = accessType;
	}
	
	public String getPointTitle() {
		return pointTitle;
	}

	public void setPointTitle(String pointTitle) {
		this.pointTitle = pointTitle;
	}
	
	public FileInputStream getIMAGEM() {
        return IMAGEM;
    }

    public void setIMAGEM(FileInputStream IMAGEM) {
        this.IMAGEM = IMAGEM;
    }	
}
