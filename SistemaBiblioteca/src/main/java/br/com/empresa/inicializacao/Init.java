package br.com.empresa.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.empresa.entity.Aluno;
import br.com.empresa.entity.AlunoDisciplina;
import br.com.empresa.entity.Avaliacao;
import br.com.empresa.entity.Disciplina;
import br.com.empresa.entity.Turma;
import br.com.empresa.repository.AlunoRepository;
import br.com.empresa.repository.DisciplinaRepository;
import br.com.empresa.repository.TurmaRepository;
import br.com.empresa.service.AlunoService;
import br.com.empresa.service.AvaliacaoService;
import br.com.empresa.service.DisciplinaService;
import br.com.empresa.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	//AlunoRepository alunoRepo;
	AlunoService alunoService;
	
	@Autowired
	//DisciplinaRepository disciplinaRepo;
	DisciplinaService disciplinaService;
	
	@Autowired
	//TurmaRepository turmaRepo;
	TurmaService turmaService;
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Pedro");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Carlos");
		
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Linux");
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setNome("Python");
		
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setNome("AWS");
		
		disciplinaService.salvar(disciplina1);
		disciplinaService.salvar(disciplina2);
		disciplinaService.salvar(disciplina3);
		//disciplinaRepo.saveAll(Arrays.asList(disciplina1,disciplina2,disciplina3));
		
		Turma turma1 = new Turma();
		turma1.setNome("Back-End");
		
		Turma turma2 = new Turma();
		turma2.setNome("Sysops");
		
		Turma turma3 = new Turma();
		turma3.setNome("Front End");
		
		turmaService.salvar(turma1);
		turmaService.salvar(turma2);
		turmaService.salvar(turma3);
		//turmaRepo.saveAll(Arrays.asList(turma1,turma2,turma3));
		
		aluno1.setTurma(turma3);
		aluno2.setTurma(turma2);
		aluno3.setTurma(turma1);
		
		aluno1.setDisciplinas(Arrays.asList(disciplina1,disciplina2));
		aluno2.setDisciplinas(Arrays.asList(disciplina3,disciplina1));
		aluno3.setDisciplinas(Arrays.asList(disciplina2,disciplina3));
		
		alunoService.salvar(aluno1);
		alunoService.salvar(aluno2);
		alunoService.salvar(aluno3);
		//alunoRepo.saveAll(Arrays.asList(aluno1,aluno2,aluno3));
		
		Avaliacao avaliacaoAluno1 = new Avaliacao();
		
		AlunoDisciplina alunoDisciplina = new AlunoDisciplina();
		alunoDisciplina.setAluno(aluno1);
		alunoDisciplina.setDisciplina(disciplina1);
		
		avaliacaoAluno1.setAlunoDisciplina(alunoDisciplina);
		avaliacaoAluno1.setConceito("A");
		
		avaliacaoService.salvar(avaliacaoAluno1);
		
		Avaliacao avaliacaoAluno2 = new Avaliacao();
		AlunoDisciplina alunoDisciplina2 = new AlunoDisciplina();
		alunoDisciplina2.setAluno(aluno2);
		alunoDisciplina2.setDisciplina(disciplina2);
		
		avaliacaoAluno2.setAlunoDisciplina(alunoDisciplina2);
		avaliacaoAluno2.setConceito("C");
		
		avaliacaoService.salvar(avaliacaoAluno2);
		
		Avaliacao avaliacaoAluno3 = new Avaliacao();
		AlunoDisciplina alunoDisciplina3 = new AlunoDisciplina();
		alunoDisciplina3.setAluno(aluno3);
		alunoDisciplina3.setDisciplina(disciplina3);
		
		avaliacaoAluno3.setAlunoDisciplina(alunoDisciplina3);
		avaliacaoAluno3.setConceito("B");
		
		avaliacaoService.salvar(avaliacaoAluno3);
		
		
		
	}

}
