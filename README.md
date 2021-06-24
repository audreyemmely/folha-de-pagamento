# Sitema de Folha de Pagamento

## :dart: Objetivo 
O objetivo do projeto é construir um sistema de folha de pagamento. O sistema consiste do gerenciamento de pagamentos dos empregados de uma empresa. Além disso, o sistema deve
gerenciar os dados destes empregados, a exemplo os cartões de pontos. Empregados devem receber o salário no momento correto, usando o método que eles preferem, obedecendo várias taxas e impostos deduzidos do salário.

## 👩‍💻 Funções 
|  Título        | Descrição | Progresso atual | Finalizado | 
|----------------|---------------|----------------|-----------|
| Adição de um empregado  | Um novo empregado é adicionado ao sistema. Os seguintes atributos são fornecidos: nome, endereço, tipo (hourly, salaried, commissioned) e os atributos associados (salário horário, salário mensal, comissão). Um número de empregado (único) deve ser escolhido automaticamente pelo sistema. | Em andamento... | <ul><li>[ ] ok</li></ul>
| Remoção de um empregado | Um empregado é removido do sistema. | A fazer | <ul><li>[ ] ok</li></ul>
| Lançar um Cartão de Ponto | O sistema anotará a informação do cartão de ponto e a associará ao empregado correto. | A fazer | <ul><li>[ ] ok</li></ul>
| Lançar um Resultado Venda | O sistema anotará a informação do resultado da venda e a associará ao empregado correto. | A fazer | <ul><li>[ ] ok</li></ul>
| Lançar uma taxa de serviço | O sistema anotará a informação da taxa de serviço e a associará ao empregado correto. | A fazer | <ul><li>[ ] ok</li></ul>
| Alterar detalhes de um empregado | Os seguintes atributos de um empregado podem ser alterados: nome, endereço, tipo (hourly,salaried,commisioned), método de pagamento, se pertence ao sindicato ou não, identificação no sindicato, taxa sindical. | A fazer | <ul><li>[ ] ok</li></ul>
| Rodar a folha de pagamento para hoje | O sistema deve achar todos os empregados que devem ser pagos no dia indicado, deve calcular o valor do salário e deve providenciar o pagamento de acordo com o método escolhido pelo empregado. | A fazer | <ul><li>[ ] ok</li></ul>
| Undo/redo | Qualquer transação associada as funcionalidades 1 a 7 deve ser desfeita (undo) ou refeita (redo). | A fazer | <ul><li>[ ] ok</li></ul>
| Agenda de Pagamento | Cada empregado é pago de acordo com uma "agenda de pagamento". Empregados podem selecionar a agenda de pagamento que desejam. Por default, as agendas "semanalmente", "mensalmente" e "bi-semanalmente" são usadas, como explicado na descricao  geral. Posteriormente, um empregado pode pedir para ser pago de acordo com qualquer uma dessas agendas. | A fazer | <ul><li>[ ] ok</li></ul>
| Criação de Novas Agendas de Pagamento | A direção da empresa pode criar uma nova agenda de pagamento e disponibilizá-la para os empregados escolherem, se assim desejarem. Uma agenda é especificada através de um string. Alguns exemplos mostram as possibilidades: "mensal 1": dia 1 de todo mês "mensal 7": dia 7 de todo mês "mensal $": último dia útil de todo mês "semanal 1 segunda": toda semana às segundas-feiras "semanal 1 sexta": toda semana às sextas-feiras "semanal 2 segunda": a cada 2 semanas às segundas-feiras | A fazer | <ul><li>[ ] ok</li></ul>

## 🛠️ Tecnologias utilizadas
- Java JDK 16.0.1

- Eclipse IDE for Enterprise Java and Web Developers 2021-06
