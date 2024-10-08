package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stok_dosya")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StokDosya {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id ; 
	@Column(name = "dosya_adi")
	private String dosya_adi;
	@Column(name = "olusturma_zamani")
	private Timestamp olusturma_zamani ;

}
