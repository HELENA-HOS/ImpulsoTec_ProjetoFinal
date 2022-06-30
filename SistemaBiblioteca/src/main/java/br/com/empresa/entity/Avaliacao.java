package br.com.empresa.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {
	
	
	@EmbeddedId 
	//Anotação que junta o idAluno e idDisciplina em chave primária composta.
	//Criado dessa forma porque essa classe além da PK composta, também tem atributo.
	//Caso não tivesse atributo. Criar com o Many to Many conforme "matricula" na classe Aluno.
	private AlunoDisciplina alunoDisciplina;
	
	private String conceito;
	

	public AlunoDisciplina getAlunoDisciplina() {
		return alunoDisciplina;
	}

	public void setAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
		this.alunoDisciplina = alunoDisciplina;
	}

	public String getConceito() {
		return conceito;
	}

	public void setConceito(String conceito) {
		this.conceito = conceito;
	}
	
	
	
	
	
	
	

}
