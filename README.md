#  Site de promoção de hoteis usando servlets 
## Index
- Feito por:
- Informações do projeto:
- Como executar
## Feito por:
- Kenzo Inanami de Faria (790778)
-
-
## Informações do projeto
Trabalho para a disciplina de Desenvolvimento de Software para Web 1 da UFSCar 2023/1.  Atende aos seguintes requisitos:
- R1: CRUD de sites de reserva (requer login de administrador).
- R2: CRUD de hoteis (requer login de administrador).
- R3: Listagem de todos os hoteis em uma única página (não requer login).
- R4: Listagem de todos os hoteis por cidade (não requer login).
- R5: Criação de uma promoção de hotel (requer login do hotel via email + senha). Depois de fazer o login, o hotel pode cadastrar uma promoção. Para isso, deve escolher um site de reservas (escolhendo a partir de uma lista), uma data inicial/final, e um preço, e deve ser gravada a promoção na base de dados.
- R6: Listagem de todas as promoções de um hotel (requer login do hotel via email + senha). Depois de fazer login, o hotel pode visualizar todas suas promoções gravadas.
- R7: O sistema não deve permitir promoções de um mesmo hotel ou um mesmo site de reservas em uma mesma data.
- R8: Listagem de todas as promoções de um site de reservas (requer login do site de reservas via email + senha). Depois de fazer login, o site de reservas pode visualizar todas as suas promoções gravadas.
- R9: O sistema deve ser internacionalizado em pelo menos 2 idiomas: português + inglês.
O sistema também trata diversos problemas possíveis como: a não inserção de informações em um campo para cadastro ou edição de sites/hoteis/promoções, a tentativa de entrar em uma área privada sem fazer login, contas duplicadas, escrever valores de preços negativos ou nulos e datas escritas erradas.
 
## Como executar
O projeto foi feito utilizando o maven, o banco de dados do mysql e o servidor Tomcat9.0.76. Para executar, primeiro é necessário criar a database indo na pasta `db/MySQL`e executando o arquivo create.sql dentro da interface do mysql com o comando `SOURCE create.sql`.
Após isso, compile com o comando `mvn compile`e de deploy para o tomcat com o comando `mvn tomcat7:deploy` ou manualmente, gerando o arquivo .war com `mvn package`.  
