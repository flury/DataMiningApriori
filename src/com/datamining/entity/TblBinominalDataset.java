package com.datamining.entity;

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
@Table(name="binominaldataset")
public class TblBinominalDataset {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="binominal_id")
	private String binominalId;
	
	@Column(name="execute_user")
	private String executeUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="execute_date")
	private Date executeDate;
	
	@Column(name="angkatan_13")
	private String angkatan13;
	
	@Column(name="angkatan_14")
	private String angkatan14;
	
	@Column(name="angkatan_15")
	private String angkatan15;
	
	@Column(name="angkatan_16")
	private String angkatan16;
	
	@Column(name="pria")
	private String pria;
	
	@Column(name="wanita")
	private String wanita;
	
	@Column(name="beasiswa")
	private String beasiswa;
	
	@Column(name="nilai_rapor_down7")
	private String nilaiRaporDown7;
	
	@Column(name="nilai_rapor_up7")
	private String nilaiRaporUp7;
	
	@Column(name="sma")
	private String sma;
	
	@Column(name="smk")
	private String smk;
	
	@Column(name="jakarta")
	private String jakarta;
	
	@Column(name="tangerang")
	private String tangerang;
	
	@Column(name="luar_kota")
	private String luarKota;
	
	@Column(name="teknik_informatika")
	private String teknikInformatika;
	
	@Column(name="non_teknik_informatika")
	private String nonTeknikInformatika;
	
	@Column(name="ipk_memuaskan")
	private String ipkMemuaskan;
	
	@Column(name="ipk_cumlaude")
	private String ipkCumlaude;
	
	@Column(name="lama_studi_cepat")
	private String lamaStudiCepat;
	
	@Column(name="lama_studi_standar")
	private String lamaStudiStandar;
	
	@Column(name="prodi_ti")
	private String prodiTi;
	
	@Column(name="prodi_si")
	private String prodiSi;
	
	public TblBinominalDataset() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBinominalId() {
		return binominalId;
	}

	public void setBinominalId(String binominalId) {
		this.binominalId = binominalId;
	}

	public String getExecuteUser() {
		return executeUser;
	}

	public void setExecuteUser(String executeUser) {
		this.executeUser = executeUser;
	}

	public Date getExecuteDate() {
		return executeDate;
	}

	public void setExecuteDate(Date executeDate) {
		this.executeDate = executeDate;
	}

	public String getAngkatan13() {
		return angkatan13;
	}

	public void setAngkatan13(String angkatan13) {
		this.angkatan13 = angkatan13;
	}

	public String getAngkatan14() {
		return angkatan14;
	}

	public void setAngkatan14(String angkatan14) {
		this.angkatan14 = angkatan14;
	}

	public String getAngkatan15() {
		return angkatan15;
	}

	public void setAngkatan15(String angkatan15) {
		this.angkatan15 = angkatan15;
	}

	public String getAngkatan16() {
		return angkatan16;
	}

	public void setAngkatan16(String angkatan16) {
		this.angkatan16 = angkatan16;
	}

	public String getPria() {
		return pria;
	}

	public void setPria(String pria) {
		this.pria = pria;
	}

	public String getWanita() {
		return wanita;
	}

	public void setWanita(String wanita) {
		this.wanita = wanita;
	}

	public String getBeasiswa() {
		return beasiswa;
	}

	public void setBeasiswa(String beasiswa) {
		this.beasiswa = beasiswa;
	}

	public String getNilaiRaporDown7() {
		return nilaiRaporDown7;
	}

	public void setNilaiRaporDown7(String nilaiRaporDown7) {
		this.nilaiRaporDown7 = nilaiRaporDown7;
	}

	public String getNilaiRaporUp7() {
		return nilaiRaporUp7;
	}

	public void setNilaiRaporUp7(String nilaiRaporUp7) {
		this.nilaiRaporUp7 = nilaiRaporUp7;
	}

	public String getSma() {
		return sma;
	}

	public void setSma(String sma) {
		this.sma = sma;
	}

	public String getSmk() {
		return smk;
	}

	public void setSmk(String smk) {
		this.smk = smk;
	}

	public String getJakarta() {
		return jakarta;
	}

	public void setJakarta(String jakarta) {
		this.jakarta = jakarta;
	}

	public String getTangerang() {
		return tangerang;
	}

	public void setTangerang(String tangerang) {
		this.tangerang = tangerang;
	}

	public String getLuarKota() {
		return luarKota;
	}

	public void setLuarKota(String luarKota) {
		this.luarKota = luarKota;
	}

	public String getTeknikInformatika() {
		return teknikInformatika;
	}

	public void setTeknikInformatika(String teknikInformatika) {
		this.teknikInformatika = teknikInformatika;
	}

	public String getNonTeknikInformatika() {
		return nonTeknikInformatika;
	}

	public void setNonTeknikInformatika(String nonTeknikInformatika) {
		this.nonTeknikInformatika = nonTeknikInformatika;
	}

	public String getIpkMemuaskan() {
		return ipkMemuaskan;
	}

	public void setIpkMemuaskan(String ipkMemuaskan) {
		this.ipkMemuaskan = ipkMemuaskan;
	}

	public String getIpkCumlaude() {
		return ipkCumlaude;
	}

	public void setIpkCumlaude(String ipkCumlaude) {
		this.ipkCumlaude = ipkCumlaude;
	}

	public String getLamaStudiCepat() {
		return lamaStudiCepat;
	}

	public void setLamaStudiCepat(String lamaStudiCepat) {
		this.lamaStudiCepat = lamaStudiCepat;
	}

	public String getLamaStudiStandar() {
		return lamaStudiStandar;
	}

	public void setLamaStudiStandar(String lamaStudiStandar) {
		this.lamaStudiStandar = lamaStudiStandar;
	}

	public String getProdiTi() {
		return prodiTi;
	}

	public void setProdiTi(String prodiTi) {
		this.prodiTi = prodiTi;
	}

	public String getProdiSi() {
		return prodiSi;
	}

	public void setProdiSi(String prodiSi) {
		this.prodiSi = prodiSi;
	}

}
