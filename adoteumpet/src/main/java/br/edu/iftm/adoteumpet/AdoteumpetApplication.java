package br.edu.iftm.adoteumpet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class AdoteumpetApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AdoteumpetApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;


	@Override
	public void run(String... args) throws Exception {
			
		jdbcTemplate.execute("CREATE TABLE usuario(id SERIAL, nome VARCHAR(255), cpf VARCHAR(255), email varchar(255), endereco varchar(255), telefone varchar(255), data_nasc varchar(255), sexo varchar(255), senha varchar(255), PRIMARY KEY (id))");	
		jdbcTemplate.update("INSERT INTO usuario(nome, cpf, email, endereco, telefone, data_nasc, sexo, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", "Edson Angoti Júnior", "11122233344", "edson@gmail.com", "rua fulano", "998724532", "04-10-1980", "Masculino", "123456");

		jdbcTemplate.update("INSERT INTO usuario(nome, cpf, email, endereco, telefone, data_nasc, sexo, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", "Clarimundo Machado", "55566677788", "clarimundo@gmail.com", "rua maria jose", "995764562","04-10-1980", "Masculino", "147934");

		jdbcTemplate.execute("CREATE TABLE animal(id SERIAL, nome VARCHAR(255), data_nasc VARCHAR(255), sexo char, raca VARCHAR(255), porte char, data_entrada VARCHAR(255), descricao VARCHAR(255), data_adocao VARCHAR(255), validacao_adocao boolean, id_user int, PRIMARY KEY (id))");		

		jdbcTemplate.update("INSERT INTO animal (nome, data_nasc, sexo, raca, porte, data_entrada, descricao, data_adocao, validacao_adocao, id_user) Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "Mel", "10-01-2010", "f", "p", "pinscher", "07-12-2021", "castrada", null, null, 1);

		jdbcTemplate.update("INSERT INTO animal (nome, data_nasc, sexo, raca, porte, data_entrada, descricao, data_adocao, validacao_adocao, id_user) Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "Leo", "10-01-2011", "m", "p", "pinscher", "07-12-2021", "castrada", null, null, 1);
		
	}
}
