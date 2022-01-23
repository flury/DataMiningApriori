package com.datamining.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="dataset")
public class TblDataset {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="angkatan")
	private Integer angkatan;
	
	@Column(name="jeniskelamin")
	private String jenisKelamin;
	
	@Column(name="prosesmasuk")
	private String prosesMasuk;
	
	@Column(name="namasekolah")
	private String namaSekolah;
	
	@Column(name="kotasekolah")
	private String kotaSekolah;
	
	@Column(name="jurusansekolah")
	private String jurusanSekolah;
	
	@Column(name="prodi")
	private String prodi;
	
	@Column(name="lamastudi")
	private BigDecimal lamaStudi;
	
	@Column(name="ipk")
	private BigDecimal ipk;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="create_user")
	private String createUser;

	public TblDataset() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

}
