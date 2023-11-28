--
-- Banco de dados: `advocacia_beckhauser`
--
CREATE DATABASE IF NOT EXISTS `advocacia_beckhauser` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `advocacia_beckhauser`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `advogado`
--

CREATE TABLE `advogado` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `profissao` varchar(255) NOT NULL,
  `rg` varchar(255) NOT NULL,
  `oab` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `advogado`
--

INSERT INTO `advogado` (`id`, `email`, `endereco`, `nome`, `telefone`, `cpf`, `data_nascimento`, `profissao`, `rg`, `oab`) VALUES
(1, 'fulano@example.com', 'Rua Exemplo, 123', 'Fulano de Tal', '123456789', '12345678901', '1990-01-01', 'Advogado', '1234567', 'OAB123456'),
(2, 'fulano@example.com', 'Rua Exemplo, 123', 'Fulano de Tal', '123456782', '12345678902', '1990-01-01', 'Advogado', '1234564', 'OAB123453');

-- --------------------------------------------------------

--
-- Estrutura para tabela `agenda`
--

CREATE TABLE `agenda` (
  `id` bigint(20) NOT NULL,
  `data_fatal` date NOT NULL,
  `data_inicial` date NOT NULL,
  `data_ocorrencia` date NOT NULL,
  `fase` varchar(255) NOT NULL,
  `local` varchar(255) NOT NULL,
  `prazo` int(11) NOT NULL,
  `situacao` varchar(255) NOT NULL,
  `tipo_prazo` varchar(255) NOT NULL,
  `processo_id` bigint(20) DEFAULT NULL,
  `advogado_responsavel_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `anexo`
--

CREATE TABLE `anexo` (
  `id` bigint(20) NOT NULL,
  `dados` longblob NOT NULL,
  `nome` varchar(255) NOT NULL,
  `nome_arquivo_original` varchar(255) NOT NULL,
  `tipo_conteudo` varchar(255) NOT NULL,
  `processo_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `anexo`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `profissao` varchar(255) NOT NULL,
  `rg` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`id`, `email`, `endereco`, `nome`, `telefone`, `cpf`, `data_nascimento`, `profissao`, `rg`) VALUES
(5, 'fulano@example.com', 'Rua Exemplo, 123', 'Fulano de Tal', '123456782', '12345678902', '1990-01-01', 'Advogado', '1234564');

-- --------------------------------------------------------

--
-- Estrutura para tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(15);

-- --------------------------------------------------------

--
-- Estrutura para tabela `modelo`
--

CREATE TABLE `modelo` (
  `id` bigint(20) NOT NULL,
  `dados` longblob NOT NULL,
  `nome` varchar(255) NOT NULL,
  `nome_arquivo_original` varchar(255) NOT NULL,
  `tipo_conteudo` varchar(255) NOT NULL,
  `processo_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `modelo`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `pessoa_juridica`
--

CREATE TABLE `pessoa_juridica` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `razao_social` varchar(255) DEFAULT NULL,
  `tipo_empresa` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `processo`
--

CREATE TABLE `processo` (
  `id` bigint(20) NOT NULL,
  `numero_processo` varchar(255) DEFAULT NULL,
  `advogado_ataque_id` bigint(20) DEFAULT NULL,
  `advogado_defesa_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `processo`
--

INSERT INTO `processo` (`id`, `numero_processo`, `advogado_ataque_id`, `advogado_defesa_id`) VALUES
(4, '121121', 2, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `advogado`
--
ALTER TABLE `advogado`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqmsq7v8u56c9nhf00rg2xdejy` (`processo_id`),
  ADD KEY `FKo4c8olmmo9ts8tk82klid2ke5` (`advogado_responsavel_id`);

--
-- Índices de tabela `anexo`
--
ALTER TABLE `anexo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKis0mvb49jjavx4l8kxb0iamlu` (`processo_id`);

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `modelo`
--
ALTER TABLE `modelo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf6w50k5eh2y2iod1pcys0fstl` (`processo_id`);

--
-- Índices de tabela `pessoa_juridica`
--
ALTER TABLE `pessoa_juridica`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `processo`
--
ALTER TABLE `processo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKim7w93a0rrqiq7nbsw3cay0ii` (`advogado_ataque_id`),
  ADD KEY `FKqbjql94l5qujbnqqqjf86c3jb` (`advogado_defesa_id`);

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `agenda`
--
ALTER TABLE `agenda`
  ADD CONSTRAINT `FKo4c8olmmo9ts8tk82klid2ke5` FOREIGN KEY (`advogado_responsavel_id`) REFERENCES `advogado` (`id`),
  ADD CONSTRAINT `FKqmsq7v8u56c9nhf00rg2xdejy` FOREIGN KEY (`processo_id`) REFERENCES `processo` (`id`);

--
-- Restrições para tabelas `anexo`
--
ALTER TABLE `anexo`
  ADD CONSTRAINT `FKis0mvb49jjavx4l8kxb0iamlu` FOREIGN KEY (`processo_id`) REFERENCES `processo` (`id`);

--
-- Restrições para tabelas `modelo`
--
ALTER TABLE `modelo`
  ADD CONSTRAINT `FKf6w50k5eh2y2iod1pcys0fstl` FOREIGN KEY (`processo_id`) REFERENCES `processo` (`id`);

--
-- Restrições para tabelas `processo`
--
ALTER TABLE `processo`
  ADD CONSTRAINT `FKim7w93a0rrqiq7nbsw3cay0ii` FOREIGN KEY (`advogado_ataque_id`) REFERENCES `advogado` (`id`),
  ADD CONSTRAINT `FKqbjql94l5qujbnqqqjf86c3jb` FOREIGN KEY (`advogado_defesa_id`) REFERENCES `advogado` (`id`);
COMMIT;
