package br.com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.entity.AlunoDisciplina;
import br.com.empresa.entity.Avaliacao;
import br.com.empresa.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {
	
	
	@Autowired
	AvaliacaoRepository avaliacaoRepo;
	
	
	public Avaliacao salvar(Avaliacao avaliacao) {
		return avaliacaoRepo.save(avaliacao);		
	}
	
	public List<Avaliacao> listarTodasAvaliacoes() {
		return avaliacaoRepo.findAll();	
	}
	
	public Avaliacao buscarNotaAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
		return avaliacaoRepo.findByAlunoDisciplina(alunoDisciplina);
	}

}
