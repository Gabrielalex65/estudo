.data
	msg1: .asciiz"\nDigite um ano para comparação\n"
	msg2: .asciiz"\nDigite outro ano\n"
	msg3: .asciiz"\nDigite um valor valido,o intervalo deve ser menor que 1000 anos\n"
.text
main:	
	
	
	inicio:
	jumpvalido:
	li $v0, 4		#Mostra mensagem
	la $a0, msg1
	syscall			

	li $v0, 5		#Recebe primeiro valor
	syscall
	add $t1, $v0, 0
	li $v0, 4		#Mostra mensagem
	la $a0, msg2
	syscall

	li $v0, 5		#Recebe segundo valor
	syscall
	add $t2, $v0, 0
	sub $t0,$t0,$t0
	sub $t5,$t5,$t5
	sub $t3,$t3,$t3
	sub $t6,$t6,$t6
	sub $t3, $t1, $t2	#Diferença entre os numeros
	beq $t3,0,anoigual
	blt $t3, 0, modulo	#Se diferença e negativa, então fazer modulo			#t3 diferenca entre anos #t1 primeiro ano #t2 segundo ano #t5 resto da divisao #t6 anos bissexto #t0 laco de repeticao
	
	modulopronto:
	
	jumpfimlaco:
	sub $t5,$t5,$t5
	bgt $t3, 1000,erro	#Comparação com diferença entre valores
	bgt $t1, $t2,t1maior		
	
	#realizar operacao t2 maior
	bgt $t0,$t3,saida       # Laço de repetição	
	rem $t5,$t1,4		#resto de divisao
	beq $t5,0, teste3	#comparacao para saber se e bissexto
	j naobissexto1

	teste3:				
	rem $t5, $t1, 100
	beq $t5, 0, quarentena1	#comparacao para saber se o resto e maior que 0
	j bissextolaco
	teste2:
	rem $t5,$t1,400
	bgt $t5,0, naobissexto1	#caso o ano nao seja bissexto
	bissextolaco:
	add $t6,$t6,1		#resultado quantidade de anos 
	naobissexto1:
	add $t1,$t1,1		#ano = ano+1 para verificar o proximo
	add $t0,$t0,1		#soma do laco
	
	j jumpfimlaco		#jump para fim de laco
	#realizar operacao t1 maior

	t1maior:
	

	saida:
	
	j valido		#jump para o fim da execucao
	
	modulo:
	mul $t3,$t3,-1		#Modulo da diferenca do
	
	j modulopronto		
	anoigual:		#caso os anos digitados sejam iguais
	rem $t5,$t1,4		#resto de divisao
	beq $t5,0, teste1	#comparacao para saber se e bissexto
	j naobissexto		#jump para ano nao bissexto

	teste1:				
	rem $t5, $t1, 100
	beq $t5, 0, quarentena	#comparacao para saber se o resto e maior que 0

	bissexto:	
		
	li $v0, 1		#mostra o resultado
	add $a0,$zero,1
	syscall 
	sub $t5,$t5,$t5
	j inicio

	quarentena:
	rem $t5,$t1,400
	bgt $t5,0, naobissexto	#caso o ano nao seja bissexto
	sub $t5,$t5,$t5
	j bissexto
	
	quarentena1:
	rem $t5,$t1,400
	bgt $t5,0, naobissexto1	#caso o ano nao seja bissexto
	sub $t5,$t5,$t5
	j bissextolaco
	
	naobissexto:
	li $v0,1		#resultado ano nao bissexto
	add $a0, $zero,0
	sub $t5,$t5,$t5
	syscall
	j inicio

	erro:			#Diferença maior que 1000	
	li $v0, 4
	la $a0, msg3
	syscall
	j jumpvalido

	valido:
	li $v0, 1
	add $a0,$t6,0
	syscall
	j inicio
