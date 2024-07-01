
---

# Projeto de Avaliação Substitutiva - Comparação de Performance com Threads

Este projeto tem como objetivo realizar uma comparação experimental de desempenho entre diferentes números de threads para processamento de dados climáticos das capitais brasileiras.

## Descrição

O projeto consiste em quatro versões do experimento, cada uma utilizando um número diferente de threads para fazer requisições HTTP às APIs de dados climáticos, processar esses dados para calcular temperaturas média, mínima e máxima por dia para cada capital brasileira, e calcular o tempo de execução médio ao longo de 10 rodadas.

### Versões do Experimento

- **Experimento1Thread**: Utiliza apenas a thread principal (sem threads adicionais).
- **Experimento3Threads**: Divide o trabalho entre 3 threads.
- **Experimento9Threads**: Divide o trabalho entre 9 threads.
- **Experimento27Threads**: Divide o trabalho entre 27 threads.

## Funcionalidades Implementadas

- **Fazer Requisições HTTP**: Implementação utilizando o Apache HttpClient para fazer requisições às APIs de dados climáticos.
- **Processamento de Dados**: Cálculo das temperaturas média, mínima e máxima por dia para cada capital.
- **Armazenamento dos Dados**: Utilização de estruturas de dados como Mapas para armazenar os dados processados em memória.
- **Exibição dos Dados**: Saída dos resultados no console.
- **Cálculo do Tempo de Execução**: Medição do tempo de execução de cada rodada e cálculo do tempo médio ao final das 10 rodadas.

## Configuração do Ambiente

1. **Pré-requisitos**:
   - Java JDK 8 ou superior.
   - Eclipse IDE (ou outra IDE de sua escolha) configurada para desenvolvimento Java.

2. **Importação do Projeto**:
   - Clone o repositório para sua máquina local.
   - Abra o Eclipse e importe o projeto como um projeto Maven existente.

3. **Configuração das Capitais**:
   - As informações de latitude e longitude das capitais brasileiras estão no arquivo `DadosCapitais.java`. Certifique-se de que essas informações estejam corretas para o funcionamento correto do experimento.

## Execução do Projeto

1. **Execução das Classes de Experimento**:
   - Abra cada classe de experimento (`Experimento1Thread.java`, `Experimento3Threads.java`, etc.) dentro do Eclipse.
   - Execute cada classe como uma aplicação Java para iniciar os experimentos.
   - Os resultados serão exibidos no console do Eclipse.

2. **Análise dos Resultados**:
   - Ao final da execução de cada experimento, será exibido o tempo médio de execução das 10 rodadas.
   - Compare os tempos de execução entre as diferentes versões do experimento para avaliar o impacto do número de threads na performance.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues relatando problemas ou sugerindo melhorias. Pull requests também são apreciados.

## Autores

- Seu Nome

## Licença

Este projeto é licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT) - veja o arquivo [LICENSE.md](LICENSE.md) para mais detalhes.

---

Certifique-se de adaptar as seções conforme necessário para refletir precisamente o seu projeto, seus requisitos específicos e as configurações do ambiente de desenvolvimento.
