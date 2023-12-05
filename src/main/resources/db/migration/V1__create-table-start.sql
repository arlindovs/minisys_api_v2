CREATE TABLE `integrante_grupo` (
  `CODIGO` BIGINT(20) NOT NULL,
  `GUID` VARCHAR(512) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `EMPRESA` INT NOT NULL,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  PRIMARY KEY (`CODIGO`));



CREATE TABLE `integrante` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `GUID` VARCHAR(512) NOT NULL,
  `GRUPO_INTEGRANTE` BIGINT(20) NULL DEFAULT NULL,
  `NOME` VARCHAR(255) NULL DEFAULT NULL,
  `SEGUNDO_NOME` VARCHAR(255) NULL DEFAULT NULL,
  `TELEFONE` VARCHAR(255) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(255) NULL DEFAULT NULL,
  `DOCUMENTO` VARCHAR(255) NULL DEFAULT NULL,
  `TIPO_DOCUMENTO` VARCHAR(255) NULL DEFAULT NULL,
  `DATA_CRIACAO` TIMESTAMP(6) NULL DEFAULT NULL,
  `STATUS` VARCHAR(255) NULL DEFAULT NULL,
  `EMPRESA` BIGINT(20) NOT NULL,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `GUID_IDX` (`GUID` ASC) INVISIBLE,
  INDEX `GRUPO_idx` (`GRUPO_INTEGRANTE` ASC) VISIBLE,
  CONSTRAINT `GRUPO`
    FOREIGN KEY (`GRUPO_INTEGRANTE`)
    REFERENCES `integrante_grupo` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE `integrante_endereco` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `GUID` VARCHAR(512) NOT NULL,
  `INTEGRANTE` BIGINT(20) NOT NULL,
  `TIPO` VARCHAR(255) NULL DEFAULT NULL,
  `INSCRICAO_ESTATUAL` VARCHAR(255) NULL DEFAULT NULL,
  `CEP` VARCHAR(255) NULL DEFAULT NULL,
  `TIPO_LOGRADOURO` VARCHAR(255) NULL DEFAULT NULL,
  `LOGRADOURO` VARCHAR(255) NULL DEFAULT NULL,
  `NUMERO` INT NULL DEFAULT NULL,
  `BAIRRO` VARCHAR(255) NULL DEFAULT NULL,
  `MUNICIPIO` VARCHAR(255) NULL DEFAULT NULL,
  `UF` VARCHAR(255) NULL DEFAULT NULL,
  `COMPLEMENTO` VARCHAR(255) NULL DEFAULT NULL,
  `VERSAO` TIMESTAMP(6) NULL DEFAULT NULL,
  PRIMARY KEY (`CODIGO`),
    INDEX `GUID_IDX` (`GUID` ASC) INVISIBLE,
    INDEX `INTEGRANTE_idx` (`INTEGRANTE` ASC) VISIBLE,
    CONSTRAINT `INTEGRANTE`
      FOREIGN KEY (`INTEGRANTE`)
      REFERENCES `integrante` (`CODIGO`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE TABLE `usuario_grupo` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `GUID` VARCHAR(512) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `EMPRESA` BIGINT(20) NOT NULL,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  PRIMARY KEY (`CODIGO`),
    INDEX `GUID_IDX` (`GUID` ASC) VISIBLE);


CREATE TABLE `usuario` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `GUID` VARCHAR(512) NOT NULL,
  `GRUPO_USUARIO` BIGINT(20) NOT NULL,
  `FUNCIONARIO` BIGINT(20) NOT NULL,
  `LOGIN` VARCHAR(255) NOT NULL,
  `SENHA` VARCHAR(255) NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `EMRPESA` BIGINT(20) NOT NULL,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `GUID_IDX` (`GUID` ASC) INVISIBLE,
  INDEX `GRUPO_idx` (`GRUPO_USUARIO` ASC) VISIBLE,
  CONSTRAINT `GRUPO_USUARIO`
    FOREIGN KEY (`GRUPO_USUARIO`)
    REFERENCES `usuario_grupo` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FUNCIONARIO`
    FOREIGN KEY (`FUNCIONARIO`)
    REFERENCES `integrante` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

