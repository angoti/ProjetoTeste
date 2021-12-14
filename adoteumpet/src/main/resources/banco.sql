CREATE TABLE usuarios (
	id_user INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(255),
    cpf VARCHAR(255) UNIQUE,
    data_nasc VARCHAR(255),
    sexo CHAR(1) CHECK(sexo IN ("M", "F")),
    endereco VARCHAR(255),
    telefone VARCHAR(255) UNIQUE,
    email VARCHAR(255) UNIQUE,
    senha VARCHAR(255),
    papel SET ("administrador")
);

CREATE TABLE animais (
	id_pet INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(255),
    data_nasc VARCHAR(255),
    sexo CHAR(1) CHECK(sexo IN ("M", "F")),
    raca VARCHAR(255),
    porte SET ('pequeno', 'medio', 'grande'),
    data_entrada DATETIME DEFAULT now(),
    descricao VARCHAR(255),
    data_adocao VARCHAR(255),
    validacao_adocao BOOLEAN,
    id_user INT,
    FOREIGN KEY(id_user) REFERENCES usuarios(id_user)
);