package br.com.alura.jpa.modelo;

public class MediaComData {

	private Double media;
	private Integer data;
	private Integer mes;

	public MediaComData(Double media, Integer data, Integer mes) {
		this.media = media;
		this.data = data;
		this.mes = mes;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

}