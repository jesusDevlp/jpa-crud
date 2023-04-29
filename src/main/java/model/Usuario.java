package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_usuarios database table.
 * 
 */
@Entity
@Table(name="tb_usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_usua")
	private int codUsua;

	@Column(name="ape_usua")
	private String apeUsua;

	@Column(name="cla_usua")
	private String claUsua;

	@Column(name="est_usua")
	private int estUsua;

	@Column(name="fna_usua")
	private String fnaUsua;

	@Column(name="nom_usua")
	private String nomUsua;

	@Column(name="usr_usua")
	private String usrUsua;

	//bi-directional many-to-one association to CabBoleta

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="idtipo")
	private Tipo tbTipo;

	public Usuario() {
	}

	public int getCodUsua() {
		return this.codUsua;
	}

	public void setCodUsua(int codUsua) {
		this.codUsua = codUsua;
	}

	public String getApeUsua() {
		return this.apeUsua;
	}

	public void setApeUsua(String apeUsua) {
		this.apeUsua = apeUsua;
	}

	public String getClaUsua() {
		return this.claUsua;
	}

	public void setClaUsua(String claUsua) {
		this.claUsua = claUsua;
	}

	public int getEstUsua() {
		return this.estUsua;
	}

	public void setEstUsua(int estUsua) {
		this.estUsua = estUsua;
	}

	public String getFnaUsua() {
		return this.fnaUsua;
	}

	public void setFnaUsua(String fnaUsua) {
		this.fnaUsua = fnaUsua;
	}

	public String getNomUsua() {
		return this.nomUsua;
	}

	public void setNomUsua(String nomUsua) {
		this.nomUsua = nomUsua;
	}

	public String getUsrUsua() {
		return this.usrUsua;
	}

	public void setUsrUsua(String usrUsua) {
		this.usrUsua = usrUsua;
	}


	public Tipo getTbTipo() {
		return this.tbTipo;
	}

	public void setTbTipo(Tipo tbTipo) {
		this.tbTipo = tbTipo;
	}

	@Override
	public String toString() {
		return "Usuario [codUsua=" + codUsua + ", apeUsua=" + apeUsua + ", claUsua=" + claUsua + ", estUsua=" + estUsua
				+ ", fnaUsua=" + fnaUsua + ", nomUsua=" + nomUsua + ", usrUsua=" + usrUsua + ", ="
				 + ", tbTipo=" + tbTipo + "]";
	}

}