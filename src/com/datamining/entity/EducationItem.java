package com.datamining.entity;

import java.math.BigDecimal;

import de.mrapp.apriori.Item;

public class EducationItem implements Item {
	
	private Integer angkatan;
	
	private String jenisKelamin;
	
	private String prosesMasuk;
	
	private String namaSekolah;
	
	private String kotaSekolah;
	
	private String jurusanSekolah;
	
	private String prodi;
	
	private BigDecimal lamaStudi;
	
	private BigDecimal ipk;

	public Integer getAngkatan() {
		return angkatan;
	}

	public void setAngkatan(Integer angkatan) {
		this.angkatan = angkatan;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public String getProsesMasuk() {
		return prosesMasuk;
	}

	public void setProsesMasuk(String prosesMasuk) {
		this.prosesMasuk = prosesMasuk;
	}

	public String getNamaSekolah() {
		return namaSekolah;
	}

	public void setNamaSekolah(String namaSekolah) {
		this.namaSekolah = namaSekolah;
	}

	public String getKotaSekolah() {
		return kotaSekolah;
	}

	public void setKotaSekolah(String kotaSekolah) {
		this.kotaSekolah = kotaSekolah;
	}

	public String getJurusanSekolah() {
		return jurusanSekolah;
	}

	public void setJurusanSekolah(String jurusanSekolah) {
		this.jurusanSekolah = jurusanSekolah;
	}

	public String getProdi() {
		return prodi;
	}

	public void setProdi(String prodi) {
		this.prodi = prodi;
	}

	public BigDecimal getLamaStudi() {
		return lamaStudi;
	}

	public void setLamaStudi(BigDecimal lamaStudi) {
		this.lamaStudi = lamaStudi;
	}

	public BigDecimal getIpk() {
		return ipk;
	}

	public void setIpk(BigDecimal ipk) {
		this.ipk = ipk;
	}

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
