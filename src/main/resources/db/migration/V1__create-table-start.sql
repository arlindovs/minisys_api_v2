CREATE TABLE `integrante_grupo` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` BIGINT(20) NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE INDEX `DESCRICAO_UNIQUE` (`DESCRICAO` ASC));



CREATE TABLE `integrante` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` BIGINT(20) NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `TIPO` VARCHAR(255) NOT NULL,
  `GRUPO_INTEGRANTE` BIGINT(20) NULL DEFAULT NULL,
  `NOME` VARCHAR(255) NULL DEFAULT NULL,
  `SEGUNDO_NOME` VARCHAR(255) NULL DEFAULT NULL,
  `TELEFONE` VARCHAR(255) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(255) NULL DEFAULT NULL,
  `DOCUMENTO` VARCHAR(255) NULL DEFAULT NULL,
  `TIPO_DOCUMENTO` VARCHAR(255) NULL DEFAULT NULL,
  `DATA_CRIACAO` TIMESTAMP(6) NULL DEFAULT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `GRUPO_idx` (`GRUPO_INTEGRANTE` ASC) VISIBLE,
  UNIQUE INDEX `DOCUMENTO_UNIQUE` (`DOCUMENTO` ASC),
  CONSTRAINT `GRUPO`
    FOREIGN KEY (`GRUPO_INTEGRANTE`)
    REFERENCES `integrante_grupo` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE `integrante_endereco` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `INTEGRANTE` BIGINT(20) NOT NULL,
  `TIPO` VARCHAR(255) NULL DEFAULT NULL,
  `INSCRICAO_ESTADUAL` VARCHAR(255) NULL DEFAULT NULL,
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
    INDEX `INTEGRANTE_idx` (`INTEGRANTE` ASC) VISIBLE,
    CONSTRAINT `INTEGRANTE`
      FOREIGN KEY (`INTEGRANTE`)
      REFERENCES `integrante` (`CODIGO`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


CREATE TABLE `usuario_grupo` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` BIGINT(20) NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `PERFIL` VARCHAR(255) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`CODIGO`),
    UNIQUE INDEX `DESCRICAO_UNIQUE` (`DESCRICAO` ASC));


CREATE TABLE `usuario` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` BIGINT(20) NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `GRUPO_USUARIO` BIGINT(20) NOT NULL,
  `FUNCIONARIO` BIGINT(20) NOT NULL,
  `LOGIN` VARCHAR(255) NOT NULL,
  `SENHA` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `GRUPO_idx` (`GRUPO_USUARIO` ASC) VISIBLE,
  UNIQUE INDEX `LOGIN_UNIQUE` (`LOGIN` ASC),
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



INSERT INTO `integrante` (`CODIGO`, `TIPO`, `NOME`, `SEGUNDO_NOME`, `DATA_CRIACAO`, `STATUS`, `EMPRESA`, `VERSAO`)
VALUES (1, 'FUNCIONARIO','MINISYS', 'MINISYS', now(), 'ATIVO', '1', now());
INSERT INTO `usuario_grupo` (`CODIGO`, `PERFIL`, `DESCRICAO`, `STATUS`, `EMPRESA`, `VERSAO`)
VALUES (1, 'SUPER', 'MINISYS', 'ATIVO', '1', now());
INSERT INTO `usuario` (`CODIGO`, `GRUPO_USUARIO`, `FUNCIONARIO`, `LOGIN`, `SENHA`, `STATUS`, `EMPRESA`, `VERSAO`)
VALUES (1, '1', '1', 'MINISYS', '$2a$10$ty2n7RzZiS1QhohkZO704eTbgJmk9upeXIadnyZ3z6ZWtOlWoYsFu', 'ATIVO', '1', now());



CREATE TABLE `item_grupo` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` BIGINT(20) NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE INDEX `DESCRICAO_UNIQUE` (`DESCRICAO` ASC) VISIBLE);



CREATE TABLE `unidade_medida` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` BIGINT(20) NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `SIMBOLO` VARCHAR(255) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE INDEX `SIMBOLO_UNIQUE` (`SIMBOLO` ASC) VISIBLE,
  UNIQUE INDEX `DESCRICAO_UNIQUE` (`DESCRICAO` ASC) VISIBLE);



CREATE TABLE `perfil_fiscal` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` INT NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE INDEX `DESCRICAO_UNIQUE` (`DESCRICAO` ASC) VISIBLE);


CREATE TABLE `fabricante` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` INT NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE INDEX `DESCRICAO_UNIQUE` (`DESCRICAO` ASC) VISIBLE);



CREATE TABLE `item` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` INT NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `DATA_CADASTRO` TIMESTAMP(6) NOT NULL,
  `TIPO` VARCHAR(255) NOT NULL,
  `PERFIL_FISCAL` BIGINT(20) NOT NULL,
  `GRUPO_ITEM` BIGINT(20) NULL DEFAULT NULL,
  `DESCRICAO` VARCHAR(255) NULL DEFAULT NULL,
  `OBSERVACAO` LONGTEXT NULL DEFAULT NULL,
  `UNIDADE_VENDA` BIGINT(20) NOT NULL,
  `UNIDADE_COMPRA` BIGINT(20) NOT NULL,
  `UNIDADE_COMPRA_FATOR` DECIMAL(18,6) NULL DEFAULT NULL,
  `FABRICANTE` BIGINT(20) NULL DEFAULT NULL,
  `ORIGEM` VARCHAR(255) NULL DEFAULT NULL,
  `NCM` VARCHAR(255) NULL DEFAULT NULL,
  `CEST` VARCHAR(255) NULL DEFAULT NULL,
  `CODIGO_BARRAS` VARCHAR(255) NULL,
  `CODIGO_ORIGINAL` VARCHAR(255) NULL,
  `TIPO_MOVIMENTACAO` VARCHAR(255) NOT NULL,
  `PRECO_CUSTO` DECIMAL(18,6) NULL DEFAULT NULL,
  `PRECO_VENDA` DECIMAL(18,6) NULL DEFAULT NULL,
  `MARGEM_LUCRO` DECIMAL(18,6) NULL DEFAULT NULL,
  `PRECO_MINIMO` DECIMAL(18,6) NULL DEFAULT NULL,
  `ESTOQUE_DISPONIVEL` DECIMAL(18,6) NULL DEFAULT NULL,
  `ESTOQUE_FISICO` DECIMAL(18,6) NULL DEFAULT NULL,
  `CONTROLA_ESTOQUE` TINYINT NOT NULL,
  `PODE_ALTERAR_DESCRICAO` TINYINT NOT NULL,
  `PODE_ALTERAR_PRECO` TINYINT NOT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE INDEX `DESCRICAO_UNIQUE` (`DESCRICAO` ASC) VISIBLE,
  UNIQUE INDEX `CODIGO_BARRAS_UNIQUE` (`CODIGO_BARRAS` ASC) VISIBLE,
  UNIQUE INDEX `CODIGO_ORIGINAL_UNIQUE` (`CODIGO_ORIGINAL` ASC) VISIBLE,
  INDEX `PERFIL_FISCAL_idx` (`PERFIL_FISCAL` ASC) VISIBLE,
  INDEX `GRUPO_ITEM_idx` (`GRUPO_ITEM` ASC) VISIBLE,
  INDEX `UNIDADE_VENDA_idx` (`UNIDADE_VENDA` ASC) VISIBLE,
  INDEX `UNIDADE_COMPRA_idx` (`UNIDADE_COMPRA` ASC) VISIBLE,
  INDEX `FABRICANTE_idx` (`FABRICANTE` ASC) VISIBLE,
  CONSTRAINT `PERFIL_FISCAL`
    FOREIGN KEY (`PERFIL_FISCAL`)
    REFERENCES `perfil_fiscal` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `GRUPO_ITEM`
    FOREIGN KEY (`GRUPO_ITEM`)
    REFERENCES `item_grupo` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `UNIDADE_VENDA`
    FOREIGN KEY (`UNIDADE_VENDA`)
    REFERENCES `unidade_medida` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `UNIDADE_COMPRA`
    FOREIGN KEY (`UNIDADE_COMPRA`)
    REFERENCES `unidade_medida` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FABRICANTE`
    FOREIGN KEY (`FABRICANTE`)
    REFERENCES `fabricante` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE `pedido` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` INT NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `TIPO` VARCHAR(255) NOT NULL,
  `TIPO_MOVIMENTACAO` VARCHAR(255) NOT NULL,
  `FINALIDADE` VARCHAR(255) NOT NULL,
  `STATUS_PEDIDO` VARCHAR(255) NOT NULL,
  `NUMERO` INT NOT NULL,
  `CONTROLE` VARCHAR(255) NULL DEFAULT NULL,
  `DATA_EMISSAO` TIMESTAMP(6) NOT NULL,
  `DATA_ENTREGA` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_FATURA` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_VALIDADE` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_PREVISAO` TIMESTAMP(6) NULL DEFAULT NULL,
  `INTEGRANTE` BIGINT(20) NOT NULL,
  `TOTAL_PRODUTO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL_DESCONTO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL_ACRESCIMO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL` DECIMAL(18,6) NULL DEFAULT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE INDEX `NUMERO_UNIQUE` (`NUMERO` ASC) VISIBLE,
  INDEX `INTEGRANTE_idx` (`INTEGRANTE` ASC) VISIBLE,
  CONSTRAINT `INTEGRANTE_PEDIDO`
    FOREIGN KEY (`INTEGRANTE`)
    REFERENCES `integrante` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `pedido_detalhe` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `CANCELADO` TINYINT NOT NULL,
  `ORDEM` INT NOT NULL,
  `PEDIDO` BIGINT(20) NOT NULL,
  `ITEM` BIGINT(20) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  `UNIDADE_MEDIDA` BIGINT(20) NOT NULL,
  `QUANTIDADE` DECIMAL(18,6) NOT NULL,
  `QUANTIDADE_DEVOLVIDA` DECIMAL(18,6) NULL DEFAULT NULL,
  `QUANTIDADE_FATURADA` DECIMAL(18,6) NULL DEFAULT NULL,
  `QUANTIDADE_ENTREGUE` DECIMAL(18,6) NULL DEFAULT NULL,
  `VALOR_UNITARIO` DECIMAL(18,6) NOT NULL,
  `VALOR_DESCONTO` DECIMAL(18,6) NULL DEFAULT NULL,
  `VALOR_ACRESCIMO` DECIMAL(18,6) NULL DEFAULT NULL,
  `VALOR_TOTAL` DECIMAL(18,6) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `PEDIDO_idx` (`PEDIDO` ASC) VISIBLE,
  INDEX `ITEM_PEDIDO_idx` (`ITEM` ASC) VISIBLE,
  INDEX `UNIDADE_PEDIDO_idx` (`UNIDADE_MEDIDA` ASC) VISIBLE,
  CONSTRAINT `PEDIDO`
    FOREIGN KEY (`PEDIDO`)
    REFERENCES `pedido` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ITEM_PEDIDO`
    FOREIGN KEY (`ITEM`)
    REFERENCES `item` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `UNIDADE_PEDIDO`
    FOREIGN KEY (`UNIDADE_MEDIDA`)
    REFERENCES `unidade_medida` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `ordem_servico` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` INT NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `TIPO_MOVIMENTACAO` VARCHAR(255) NOT NULL,
  `FINALIDADE` VARCHAR(255) NOT NULL,
  `STATUS_ORDEM` VARCHAR(255) NOT NULL,
  `NUMERO` INT NOT NULL,
  `CONTROLE` VARCHAR(255) NULL DEFAULT NULL,
  `DATA_EMISSAO` TIMESTAMP(6) NOT NULL,
  `DATA_ENTREGA` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_FATURA` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_VALIDADE` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_PREVISAO` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_SERVICO_INICIO` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_SERVICO_FIM` TIMESTAMP(6) NULL DEFAULT NULL,
  `INTEGRANTE` BIGINT(20) NOT NULL,
  `TOTAL_PRODUTO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL_SERVICO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL_DESCONTO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL_ACRESCIMO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL` DECIMAL(18,6) NULL DEFAULT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE INDEX `NUMERO_UNIQUE` (`NUMERO` ASC) VISIBLE,
  INDEX `INTEGRANTE_idx` (`INTEGRANTE` ASC) VISIBLE,
  CONSTRAINT `INTEGRANTE_ORDEM`
    FOREIGN KEY (`INTEGRANTE`)
    REFERENCES `integrante` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `ordem_servico_detalhe` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `CANCELADO` TINYINT NOT NULL,
  `ORDEM` INT NOT NULL,
  `ORDEM_SERVICO` BIGINT(20) NOT NULL,
  `TIPO_ITEM` VARCHAR(255) NOT NULL,
  `ITEM` BIGINT(20) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  `UNIDADE_MEDIDA` BIGINT(20) NOT NULL,
  `QUANTIDADE` DECIMAL(18,6) NOT NULL,
  `QUANTIDADE_DEVOLVIDA` DECIMAL(18,6) NULL DEFAULT NULL,
  `QUANTIDADE_FATURADA` DECIMAL(18,6) NULL DEFAULT NULL,
  `VALOR_UNITARIO` DECIMAL(18,6) NOT NULL,
  `VALOR_DESCONTO` DECIMAL(18,6) NULL DEFAULT NULL,
  `VALOR_ACRESCIMO` DECIMAL(18,6) NULL DEFAULT NULL,
  `VALOR_TOTAL` DECIMAL(18,6) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `ORDEM_SERVICO_idx` (`ORDEM_SERVICO` ASC) VISIBLE,
  INDEX `ITEM_ORDEM_idx` (`ITEM` ASC) VISIBLE,
  INDEX `UNIDADE_ORDEM_idx` (`UNIDADE_MEDIDA` ASC) VISIBLE,
  CONSTRAINT `ORDEM_SERVICO`
    FOREIGN KEY (`ORDEM_SERVICO`)
    REFERENCES `ordem_servico` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ITEM_ORDEM`
    FOREIGN KEY (`ITEM`)
    REFERENCES `item` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `UNIDADE_ORDEM`
    FOREIGN KEY (`UNIDADE_MEDIDA`)
    REFERENCES `unidade_medida` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE `ordem_servico_equipamento` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `ORDEM_SERVICO` BIGINT(20) NOT NULL,
  `TIPO_ITEM` VARCHAR(255) NOT NULL,
  `ITEM` BIGINT(20) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  `OBSERVACAO` VARCHAR(255) NOT NULL,
  `NUMERO_SERIE` VARCHAR(255) NOT NULL,
  `QUANTIDADE` DECIMAL(18,6) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `ORDEM_SERVICO_idx` (`ORDEM_SERVICO` ASC) VISIBLE,
  INDEX `ITEM_ORDEM_idx` (`ITEM` ASC) VISIBLE,
  CONSTRAINT `ORDEM_SERVICO_EQUIPAMENTO`
    FOREIGN KEY (`ORDEM_SERVICO`)
    REFERENCES `ordem_servico` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ITEM_EQUIPAMENTO`
    FOREIGN KEY (`ITEM`)
    REFERENCES `item` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE `nota_fiscal` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` INT NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `TIPO` VARCHAR(255) NOT NULL,
  `FINALIDADE` VARCHAR(255) NOT NULL,
  `NUMERO` INT NOT NULL,
  `RDS` INT NULL DEFAULT NULL,
  `CHAVE_ACESSO` VARCHAR(255) NOT NULL,
  `DATA_EMISSAO` TIMESTAMP(6) NOT NULL,
  `DATA_ENTRADA_SAIDA` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_FATURA` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_REFERENCIA_FISCAL` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_ENVIO` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_CONFIRMACAO` TIMESTAMP(6) NULL DEFAULT NULL,
  `INTEGRANTE` BIGINT(20) NOT NULL,
  `TOTAL_PRODUTO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL_SERVICO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL_DESCONTO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL_ACRESCIMO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL` DECIMAL(18,6) NULL DEFAULT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE INDEX `NUMERO_UNIQUE` (`NUMERO` ASC) VISIBLE,
  INDEX `INTEGRANTE_idx` (`INTEGRANTE` ASC) VISIBLE,
  CONSTRAINT `INTEGRANTE_NOTA`
    FOREIGN KEY (`INTEGRANTE`)
    REFERENCES `integrante` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `nota_fiscal_detalhe` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `CANCELADO` TINYINT NOT NULL,
  `ORDEM` INT NOT NULL,
  `NOTA_FISCAL` BIGINT(20) NOT NULL,
  `PERFIL_FISCAL` BIGINT(20) NOT NULL,
  `TIPO_ITEM` VARCHAR(255) NOT NULL,
  `ITEM` BIGINT(20) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  `UNIDADE_MEDIDA` BIGINT(20) NOT NULL,
  `NCM` VARCHAR(255) NULL DEFAULT NULL,
  `CEST` VARCHAR(255) NULL DEFAULT NULL,
  `QUANTIDADE` DECIMAL(18,6) NOT NULL,
  `QUANTIDADE_DEVOLVIDA` DECIMAL(18,6) NULL DEFAULT NULL,
  `VALOR_UNITARIO` DECIMAL(18,6) NOT NULL,
  `VALOR_DESCONTO` DECIMAL(18,6) NULL DEFAULT NULL,
  `VALOR_ACRESCIMO` DECIMAL(18,6) NULL DEFAULT NULL,
  `VALOR_TOTAL` DECIMAL(18,6) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `NOTA_FISCAL_idx` (`NOTA_FISCAL` ASC) VISIBLE,
  INDEX `ITEM_NOTA_idx` (`ITEM` ASC) VISIBLE,
  INDEX `UNIDADE_NOTA_idx` (`UNIDADE_MEDIDA` ASC) VISIBLE,
  CONSTRAINT `NOTA_FISCAL`
    FOREIGN KEY (`NOTA_FISCAL`)
    REFERENCES `nota_fiscal` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `PERFIL_FISCAL_NOTA`
    FOREIGN KEY (`PERFIL_FISCAL`)
    REFERENCES `perfil_fiscal` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ITEM_NOTA`
    FOREIGN KEY (`ITEM`)
    REFERENCES `item` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `UNIDADE_NOTA`
    FOREIGN KEY (`UNIDADE_MEDIDA`)
    REFERENCES `unidade_medida` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);




CREATE TABLE `origem_nota_fatura` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `DATA_CRIACAO` TIMESTAMP(6) NOT NULL,
  `PEDIDO_DETALHE` BIGINT(20) NOT NULL,
  `ORDEM_SERVICO_DETALHE` BIGINT(20) NOT NULL,
  `NOTA_FISCAL_DETALHE` BIGINT(20) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `PEDIDO_DETALHE_idx` (`PEDIDO_DETALHE` ASC) VISIBLE,
  INDEX `ORDEM_SERVICO_DETALHE_idx` (`ORDEM_SERVICO_DETALHE` ASC) VISIBLE,
  INDEX `NOTA_FISCAL_DETALHE_idx` (`NOTA_FISCAL_DETALHE` ASC) VISIBLE,
  CONSTRAINT `PEDIDO_DETALHE`
    FOREIGN KEY (`PEDIDO_DETALHE`)
    REFERENCES `pedido_detalhe` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ORDEM_SERVICO_DETALHE`
    FOREIGN KEY (`ORDEM_SERVICO_DETALHE`)
    REFERENCES `ordem_servico_detalhe` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `NOTA_FISCAL_DETALHE`
    FOREIGN KEY (`NOTA_FISCAL_DETALHE`)
    REFERENCES `nota_fiscal_detalhe` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);




CREATE TABLE `estoque` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `TIPO` VARCHAR(255) NOT NULL,
  `DATA_OPERACAO` TIMESTAMP(6) NOT NULL,
  `RESERVADO` TINYINT NOT NULL,
  `ITEM` BIGINT(20) NOT NULL,
  `UNIDADE_MEDIDA` BIGINT(20) NOT NULL,
  `QUANTIDADE` DECIMAL(18,6) NOT NULL,
  `VALOR_UNITARIO` DECIMAL(18,6) NOT NULL,
  `VALOR_TOTAL` DECIMAL(18,6) NOT NULL,
  `LOTE` VARCHAR(255) NULL DEFAULT NULL,
  `NUMERO_SERIE` VARCHAR(255) NULL DEFAULT NULL,
  `DATA_VALIDADE` TIMESTAMP(6) NULL DEFAULT NULL,
  `DATA_FABRICACAO` TIMESTAMP(6) NULL DEFAULT NULL,
  `FUNCIONARIO` BIGINT(20) NOT NULL,
  `OBSERVACAO` LONGTEXT NULL DEFAULT NULL,
  `MOTIVO_ACERTO` VARCHAR(255) NULL DEFAULT NULL,
  `PEDIDO_DETALHE` BIGINT(20) NULL DEFAULT NULL,
  `ORDEM_SERVICO_DETALHE` BIGINT(20) NULL DEFAULT NULL,
  `NOTA_FISCAL_DETALHE` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `ITEM_ESTOQUE_idx` (`ITEM` ASC) VISIBLE,
  INDEX `UNIDADE_ESTOQUE_idx` (`UNIDADE_MEDIDA` ASC) VISIBLE,
  INDEX `FUNCIONARIO_idx` (`FUNCIONARIO` ASC) VISIBLE,
  INDEX `PEDIDO_DETALHE_ESTOQUE_idx` (`PEDIDO_DETALHE` ASC) VISIBLE,
  INDEX `ORDEM_DETALHE_ESTOQUE_idx` (`ORDEM_SERVICO_DETALHE` ASC) VISIBLE,
  INDEX `NOTA_DETALHE_ESTOQUE_idx` (`NOTA_FISCAL_DETALHE` ASC) VISIBLE,
  CONSTRAINT `ITEM_ESTOQUE`
    FOREIGN KEY (`ITEM`)
    REFERENCES `item` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `UNIDADE_ESTOQUE`
    FOREIGN KEY (`UNIDADE_MEDIDA`)
    REFERENCES `unidade_medida` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FUNCIONARIO_ESTOQUE`
    FOREIGN KEY (`FUNCIONARIO`)
    REFERENCES `integrante` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `PEDIDO_DETALHE_ESTOQUE`
    FOREIGN KEY (`PEDIDO_DETALHE`)
    REFERENCES `pedido_detalhe` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ORDEM_DETALHE_ESTOQUE`
    FOREIGN KEY (`ORDEM_SERVICO_DETALHE`)
    REFERENCES `ordem_servico_detalhe` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `NOTA_DETALHE_ESTOQUE`
    FOREIGN KEY (`NOTA_FISCAL_DETALHE`)
    REFERENCES `nota_fiscal_detalhe` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE `titulo` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` INT NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `STATUS_TITULO` VARCHAR(255) NOT NULL,
  `TIPO` VARCHAR(255) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  `OBSERVACAO` LONGTEXT NULL DEFAULT NULL,
  `INTEGRANTE` BIGINT(20) NULL DEFAULT NULL,
  `FUNCIONARIO` BIGINT(20) NOT NULL,
  `DATA_LANCAMENTO` TIMESTAMP(6) NOT NULL,
  `DATA_VENCIMENTO` TIMESTAMP(6) NOT NULL,
  `DATA_ULTIMO_PAGAMENTO` TIMESTAMP(6) NULL DEFAULT NULL,
  `VALOR` DECIMAL(18,6) NOT NULL,
  `VALOR_DESCONTO` DECIMAL(18,6) NULL DEFAULT NULL,
  `VALOR_ACRESCIMO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL` DECIMAL(18,6) NOT NULL,
  `TOTAL_EM_ABERTO` DECIMAL(18,6) NULL DEFAULT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `INTEGRANTE_TITULO_idx` (`INTEGRANTE` ASC) VISIBLE,
  INDEX `FUNCIONARIO_TITULO_idx` (`FUNCIONARIO` ASC) VISIBLE,
  CONSTRAINT `INTEGRANTE_TITULO`
    FOREIGN KEY (`INTEGRANTE`)
    REFERENCES `integrante` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FUNCIONARIO_TITULO`
    FOREIGN KEY (`FUNCIONARIO`)
    REFERENCES `integrante` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE `forma_pagamento` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` INT NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `TIPO` VARCHAR(45) NOT NULL,
  `DESCRICAO` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CODIGO`));



CREATE TABLE `movimentacao` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `VERSAO` TIMESTAMP(6) NOT NULL,
  `EMPRESA` INT NOT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `STATUS_MOVIMENTACAO` VARCHAR(255) NOT NULL,
  `TIPO` VARCHAR(255) NOT NULL,
  `TIPO_MOVIMENTACAO` VARCHAR(255) NOT NULL,
  `TITULO` BIGINT(20) NOT NULL,
  `DESCRICAO` VARCHAR(255) NOT NULL,
  `OBSERVACAO` LONGTEXT NULL DEFAULT NULL,
  `INTEGRANTE` BIGINT(20) NULL DEFAULT NULL,
  `FUNCIONARIO` BIGINT(20) NOT NULL,
  `FORMA_PAGAMENTO` BIGINT(20) NOT NULL,
  `DATA_LANCAMENTO` TIMESTAMP(6) NOT NULL,
  `DATA_VENCIMENTO` TIMESTAMP(6) NOT NULL,
  `DATA_COMPENCACAO` TIMESTAMP(6) NULL DEFAULT NULL,
  `VALOR` DECIMAL(18,6) NOT NULL,
  `VALOR_DESCONTO` DECIMAL(18,6) NULL DEFAULT NULL,
  `VALOR_ACRESCIMO` DECIMAL(18,6) NULL DEFAULT NULL,
  `TOTAL` DECIMAL(18,6) NOT NULL,
  `TOTAL_EM_ABERTO` DECIMAL(18,6) NULL DEFAULT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `TITULO_MOVIMENTACAO_idx` (`TITULO` ASC) VISIBLE,
  INDEX `INTEGRANTE_MOVIMENTACAO_idx` (`INTEGRANTE` ASC) VISIBLE,
  INDEX `FUNCIONARIO_MOVIMENTACAO_idx` (`FUNCIONARIO` ASC) VISIBLE,
  INDEX `FORMA_PAGAMENTO_idx` (`FORMA_PAGAMENTO` ASC) VISIBLE,
  CONSTRAINT `TITULO_MOVIMENTACAO`
    FOREIGN KEY (`TITULO`)
    REFERENCES `titulo` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `INTEGRANTE_MOVIMENTACAO`
    FOREIGN KEY (`INTEGRANTE`)
    REFERENCES `integrante` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FUNCIONARIO_MOVIMENTACAO`
    FOREIGN KEY (`FUNCIONARIO`)
    REFERENCES `integrante` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FORMA_PAGAMENTO`
    FOREIGN KEY (`FORMA_PAGAMENTO`)
    REFERENCES `forma_pagamento` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE `origem_titulo_fatura` (
  `CODIGO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `DATA_CRIACAO` TIMESTAMP(6) NOT NULL,
  `PEDIDO` BIGINT(20) NOT NULL,
  `ORDEM_SERVICO` BIGINT(20) NOT NULL,
  `NOTA_FISCAL` BIGINT(20) NOT NULL,
  `TITULO` BIGINT(20) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `PEDIDO_TITULO_idx` (`PEDIDO` ASC) VISIBLE,
  INDEX `ORDEM_TITULO_idx` (`ORDEM_SERVICO` ASC) VISIBLE,
  INDEX `NOTA_TITULO_idx` (`NOTA_FISCAL` ASC) VISIBLE,
  INDEX `TITULO_TITULO_idx` (`TITULO` ASC) VISIBLE,
  CONSTRAINT `PEDIDO_TITULO`
    FOREIGN KEY (`PEDIDO`)
    REFERENCES `pedido` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ORDEM_TITULO`
    FOREIGN KEY (`ORDEM_SERVICO`)
    REFERENCES `ordem_servico` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `NOTA_TITULO`
    FOREIGN KEY (`NOTA_FISCAL`)
    REFERENCES `nota_fiscal` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `TITULO_TITULO`
    FOREIGN KEY (`TITULO`)
    REFERENCES `titulo` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
