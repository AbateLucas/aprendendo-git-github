# Sistema de Gestão de Estoque e Medicamentos (UBS)

Este sistema foi concebido para gerir o inventário, a distribuição, as movimentações de medicamentos e o controlo de alertas de validade e stock nas **Unidades Básicas de Saúde (UBS)**.

---

## 🏛️ Arquitetura do Sistema

O projeto está estruturado com base em **Programação Orientada a Objetos (POO)**, utilizando conceitos de herança, interfaces e encapsulamento para garantir a integridade dos dados e a segregação de responsabilidades.

---

## 👥 Módulo de Pessoas e Acessos

### 1. `Pessoa` (Classe Abstrata)
* **Atributos:** `id`, `nome`, `cpf`, `contacto`
* **Descrição:** Classe base para representação de indivíduos no sistema.

### 2. `Paciente` *(subclasse de Pessoa)*
* **Atributos:** `cartaoSUS`
* **Descrição:** Representa o utente que recebe a medicação dispensada.

### 3. `Funcionario` *(subclasse abstrata de Pessoa)*
* **Atributos:** `matricula`, `lotacao` *(UnidadeBasicaSaude)*
* **Métodos:**
  * `podeAutorizar(m: Movimentacao): boolean`: Define se o funcionário possui privilégios para aprovar a operação.
  * `enderecoContato(): String`: Retorna os dados de contacto do funcionário.

#### Subclasses de `Funcionario`:
* **`Farmaceutico`**
  * **Atributos:** `CRF`
  * **Responsabilidade:** Validação técnica de medicamentos e receitas de controlo especial.
* **`TecnicoAlmoxarifado`**
  * **Responsabilidade:** Operação física do stock e execução de entradas/saídas.
* **`Gestor`**
  * **Atributos:** `regiao`
  * **Métodos:** `aprovarTransferencia(t: Transferencia): void`
  * **Responsabilidade:** Controlo e autorização da distribuição de medicamentos entre diferentes unidades.

---

## 📦 Módulo de Inventário e Medicamentos

* **`Estoque`**: Gestão geral do inventário da unidade.
* **`ItemEstoque`**: Representação de um item específico no inventário.
* **`Lote`**: Registo com código de lote, data de fabrico e validade.
* **`Medicamento`**:
  * **Atributos:** `id`, `nome`, `principioAtivo`, `unidadeMedida`
  * **Métodos:** `exigeControleEspecial()`, `exigeCadeiaDeFrio()`, `transportePor(m: Meio)`
* **Interfaces Implementadas:**
  * `exigeControleEspecial`: Regras de segurança para psicotrópicos e controlados.
  * `exigeRefrigeracao`: Validação da cadeia de frio durante a armazenagem e transporte.

---

## 🔄 Módulo de Movimentações

Toda alteração no inventário herda da classe abstrata **`Movimentacao`**:

* **Atributos:** `id`, `dataHora`, `quantidade`, `justificativa`, `responsavel` *(Funcionario)*, `item` *(ItemEstoque)*, `aplicada`
* **Métodos Principais:** `verificaPossibilidade()`, `aplicar()`, `estornar()`, `descrever()`

### Tipos de Movimentação:
1. **`Entrada`**: Recebimento de insumos associado a uma `notaFiscal`.
2. **`Saida`**: Dispensação ao `paciente` via `numeroReceita`.
3. **`Baixa`**: Eliminação de itens por extravio ou perda por validade.
4. **`Transferencia`**: Envio de medicamentos entre uma `ubsOrigem` e uma `ubsDestino`.
5. **`Ajuste`**: Correção de discrepâncias entre o `saldoSistema` e o `saldoFisico`.

---

## ⚠️ Módulo de Alertas

Classe base **`Alerta`**:
* **Atributos:** `id`, `UBS`, `criadoEm`, `resolvido`
* **Métodos:** `resolver()`, `isResolvido()`, `deveDisparar()`, `mensagem()`

### Tipos de Alerta:
* **`AlertaValidadeProxima`**: Notifica a proximidade da expiração de um `lote`.
* **`AlertaEstoqueBaixo`**: Avisa quando a quantidade de um item atinge o nível crítico.
* **`AlertaExcessoEstoque`**: Identifica excesso de stock para evitar desperdícios.

---

## 🏥 Módulo de Unidade Básica de Saúde

**`UnidadeBasicaSaude`**:
* **Atributos:** `nome`, `codigoCNES`, `endereco`
* **Métodos:**
  * `saldoMedicamentos(m: Medicamento): int`
  * `enderecoContato(): String`
  * `aceitaAlerta(a: Alerta): boolean`