# POO - Agência de turismo

## Nota: 11,7

## Comentários:  -1 ponto
	- modularidade
		3x a mesma chamada de comprarBilhete no main
		Lógica complicada e pouco legível em muitos momentos, usando get de posição de estrutura. Tudo poderia ser reduzido com streams (e sem get de get, que fere o encapsulamento)
	- não consigo comprar bilhete (exceção de voo nulo): -0,5
	- não posso cadastrar preço de trecho (achei enterrado em um submenu. Por que não na hora de criar o voo? Muda todos os voos??)
	- cadastro de voo com exceção não tratada. Entrada antinatural, com dia, mes, ano separados.
	
## Correção

### Modelagem: 1,8/2
	- Acelerador não precisava de herança
	
### Documentação e aderência ao modelo: 0,4/2
	- Arquivo de testes: não tem. Teste do main não funciona (procura arquivo "names" inexistente)
	- Pouquíssima documentação. 
	
### Requisitos Cliente: 5/10 
	- Bilhete com vários voos	0/3 (só consegui colocar um. Dá exceção ao selecionar trecho 0)
	- Preço/pontuação/aceleração de bilhetes	3/4 (exceções não tratadas se comprar sem criar voo antes)
	- Verificação de fidelidade	2/3 (sem conseguir cadastrar 10000 pontos, só por inspeção)
		
	
### Requisitos Empresa: 4,5/8
	- Dados de cliente	2/2
	- Cliente com mais pontos	0/2 - só pega o primeiro?
	- Voo cidade/data/100 reservas	1/2 (sem conseguir testar. E não faz sentido pedir a cidade pelo nome, ou vai precisar validar nomes diferentes dos trechos)
	- Total arrecadado / filtro mês	1,5/2 (sem mês)
	
### Apresentação e aderência ao SOLID (peso entre 0 e 1)
	- peso 1
	
