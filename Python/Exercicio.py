import math


def exercicio1():
  quadrado = float(input("Digite o valor da medida"))
  print(quadrado**2)

def exercicio2():
  salario = float(input("Digite o valor do salario"))
  print("O salario ajustado é de",(salario*0.15)+salario)

def exercicio3():
  base = float(input("Digite o valor da base"))
  altura = float(input("Digite o valor da altura"))
  print("A area é de",(base*altura)/2)

def exercicio4():
  celsius = float(input("Digite o valor da temperatura em celsius"))
  print((9 * celsius + 160) / 5)

def exercicio5():
  a = float(input("Digite o valor de a")); b = float(input("Digite o valor de b")); c = float(input("Digite o valor de c"))
  print((-b + math.sqrt(b ** 2 - 4 * a * c)) / 2 * a)
  print((-b - math.sqrt(b ** 2 - 4 * a * c)) / 2 * a)

def exercicio6():
  x = 77; y = 13; aux = 0
  aux = x
  x = y
  y = aux

def exercicio7():
  comprimento = float(input("Digite o comprimento")); largura = float(input("Digite a largura")); altura = float(input("Digite o comprimento"))
  print(comprimento * largura * altura)

def exercicio8():
  valorPoup = float(input("Digite o valor de deposito"))
  print((valorPoup*0.013) + valorPoup)

def exercicio9():
  valor1 = int(input("Digite o primeiro valor")); valor2 = int(input("Digite o segundo valor"))
  print((valor1**2) + (valor2**2))

def exercicio10():
  valor1 = float(input("Digite o valor do primeiro numero")); valor2 = float(input("Digite o valor do segundo numero"))
  if valor1 > valor2:
    print(valor1 - valor2)
  elif valor2 > valor1:
    print(valor2 - valor1)
  else:
    print("Valores são iguais")
    
def exercicio11():
  raio = float(input("Digite o valor do raio"))
  print(raio*math.pi*2)

def exercicio12():
  anoNascimento = int(input("Digite o ano ")); anoAtual = int(input("Digite o ano atual"))
  print((anoAtual+anoNascimento)+17)

def exercicio13():
  kilosAlimento = float(input("Digite a quantidade de alimentos em kilos"));
  print("Dias",kilosAlimento/0.5)

def exercicio14():
  angulo1 = float(input("Digite o angulo a")); angulo2 = float(input("Digite o angulo b"))
  print(180-(angulo1+angulo2))

def exercicio15():
  cateto1 = float(input("Digite o valor do cateto")); cateto2 = float(input("Digite o valor do cateto"))
  print(math.sqrt((cateto1**2)+cateto2**2))

def exercicio16():
  horasTrabalhadas = int(input("Digite a quantidade de horas trabalhadas"))
  valorHora = float(input("Digite o valor da hora trabalhada"))
  desconto = float(input("Digite a porcentagem do desconto")); desconto = desconto/100
  dependentes = int(input("Digite a quantidade de dependentes"))
  #salario liquido + acrescimento dependentes
  print(((horasTrabalhadas*valorHora)-(horasTrabalhadas*valorHora*(desconto)))+(dependentes*100))
   
def exercicio17():
  tempoPercurso = int(input("Digite o tempo de percurso"))
  velocidadeMedia = int(input("Digite a velocidade media"))
  print((velocidadeMedia*tempoPercurso)/12)
def exercicio18():
  valor1 = int(input("Digite o valor do primeiro numero")); valor2 = int(input("Digite o valor do segundo numero"))
  if valor1 > valor2:
    print(valor1 - valor2)
  elif valor2 > valor1:
    print(valor2 - valor1)
  else:
    print("Valores são iguais")

def exercicio19():
  valor1 = int(input("Digite o valor do primeiro numero")); valor2 = int(input("Digite o valor do segundo numero"))
  if valor1 > valor2:
    print(valor1)
  elif valor2 > valor1:
    print(valor2)
  else:
    print("Valores são iguais")

def exercicio20():
  a = float(input("Digite o valor de A")); b = float(input("Digite o valor de b")); c = float(input("Digite o valor de c"))
  if(b ** 2 -4 * a * c) < 0:
    print("Sem raiz")
  elif (b ** 2 -4 * a * c) == 0:
    print(-b -(math.sqrt(b ** 2 -4 * a * c))/(2 * a))
  else:
    print((-b + math.sqrt(b ** 2 - 4 * a * c)) / 2 * a)
    print((-b - math.sqrt(b ** 2 - 4 * a * c)) / 2 * a)

def exercicio21():
  contador = 0; nota = 0
  while(contador < 4):
    nota = nota + int(input("Digite o valor da nota do aluno"))
    contador = contador + 1
  if(nota/4 >= 6.0):
    print("Aprovado")
  elif nota >= 3.0 and nota < 6.0:
    print("Exame")
  else:
    print("Retido")

def exercicio22():
  valor1 = int(input("Digite um valor"))
  valor2 = int(input("Digite outro valor diferente"))
  if(valor1 != valor2):
    if(valor1 > valor2):
      print(valor2,valor1)
    else:
      print(valor1,valor2)
  else:
    print("Valores digitados são iguais")

def exercicio23():
  valida = False
  while valida == False:
    valor1 = int(input("Digite o primeiro valor")); valor2 = int(input("Digite o segundo valor")); valor3 = int(input("Digite o terceiro valor"));
    if valor1 < valor2 and valor2 < valor3:  
      valor4 = int(input("Digite o quarto valor"))
    else:
      print("Valores não estão em ordem crescente"); break
      if valor4 > valor3:
        print(valor1,valor2,valor3,valor4)
        valida = True
      else:
        valida = False

def exercicio24():
  valor = int(input("Digite o numero"))
  if(valor % 2 == 0 and valor % 3 == 0):
    print("Valor é divisivel por 2 e 3")

def exercicio25():
  horaInicio = int(input("Digite a hora do inicio do jogo"))
  minutoInicio = int(input("Digite o inicio do jogo"))
  horaFinal = int(input("Digite a hora final do jogo"))
  minutoFinal = int(input("Digite o minuto final"))
  if horaInicio < horaFinal:
    if minutoInicio < minutoFinal:

def exercicio26():
  valor1 = int(input("Digite o valor")); valor2 = int(input("Digite o segundo valor"))
  if valor1 > valor2:
    if valor1 % valor2 == 0:
      print("O valor é multiplo de",valor1)
  elif valor2 > valor1:
    if valor2 % valor1 == 0:
      print("O valor é multiplo de",valor2)
  else:
    print("Valores são iguais")    

def exercicio27():
  voltas = int(input("Digite a quantidade de voltas"))
  extensao = float(input("Digite a extensao do trajeto em metros"))
  duracao = int(input("Digite o tempo em minutos"))

  print("km/h",((voltas*extensao)/(duracao))/16.6667)

def exercicio28():
  precoAtual = float(input("Digite o preço atual"))
  mediaMensal = float(input("Digite a media mensal"))
  if mediaMensal < 500 or precoAtual < 30:
    print("Novo preco",(precoAtual*0.1)+precoAtual)
  elif mediaMensal >= 500 and mediaMensal < 1000 or precoAtual >= 30 and precoAtual < 80:
    print((precoAtual*0.15)+precoAtual)
  else:
    print((precoAtual*0.05)+precoAtual)

def exercicio29():
  tipoInvestimento = int(input("1-poupança 2-renda fixa"))
  if tipoInvestimento == 1:
    valor = float(input("Digite o valor do investimento"))
    print((valor*0.03)+valor)
  elif tipoInvestimento == 2:
    valor = float(input("Digite o valor do investimento"))
    print((valor*0.05)+valor)
  else:
    print("Opção invalida")

def exercicio30():
  anoNascimento = int(input("Digite o ano de nascimento"))
  mesNascimento = int(input("Digite o mes de nascimento"))
  diaNascimento = int(input("Digite o dia de nascimento"))
  anoAtual = int(input("Digite o ano atual"))
  mesAtual = int(input("Digite o mes atual"))
  diaAtual = int(input("Digite o dia atual"))
  contador = anoNascimento
  idade = 0
  bissexto = 0
  while contador < anoAtual:
    if contador % 4 == 0:
      if contador % 100 != 0:
        bissexto = bissexto + 1
      elif contador % 400 == 0:
        bissexto = bissexto + 1
    idade = idade + 1
    contador = contador + 1

  if mesAtual < mesNascimento:
    idade = idade - 1
  elif mesAtual == mesNascimento:
    if diaAtual < diaNascimento:
      idade = idade - 1
  print(idade," Anos",abs(mesAtual-mesNascimento+12),"Meses",abs(diaAtual-diaNascimento+bissexto+30)," Dias")

def exercicio31():
  contador = 10
  while contador <= 150:
    print(contador**2)
    contador = contador + 1

def exercicio32(n):
  
  if n == 1:
    return 1
  else:
    return n * exercicio32(n-1)

def exercicio33():
  repeticoes = int(input("Digite o numero de repeticoes"))
  contador = 1; soma = 0.0
  while contador < repeticoes:
    soma = soma + (1/contador)
    contador = contador + 1

def exercicio34():
  multiplica = int(input("Digite o numero para multiplicar"))
  contador = 0
  while contador <= 10:
    print(contador*multiplica)

def exercicio35():
  valor1 = int(input("Digite o primeiro valor"))
  valor2 = int(input("Digite o valor do segundo"))
  aux1 , aux2 = valor1 , valor2
  soma = 0
  if valor1 < valor2:
    print(valor2," é maior")
    while aux1 < aux2:
      if aux1 % 2 != 0:
        soma = soma + aux1
    aux1 = aux1 + 1
  elif valor1 > valor2:
    print(valor1," é maior")
    while aux2 < aux1:
      if aux2 % 2 != 0:
        soma = soma + aux2
  aux2 = aux2 + 1

def exercicio36():
  somatoria = 0
  valor = int(input("Digite o valor para fatorial"))
  fatorial = 1
  while valor > 1:
    fatorial = fatorial * valor
    valor = valor - 1
    somatoria = somatoria + (1/fatorial)   
  print(somatoria)

def exercicio37():
  final = int(input("Digite até onde deseja calcular fibonacci"))
  fibo = 1; ant1 = 0; ant2 = 0
  contador = 0
  while contador < final:
    if contador == 0:
      print(1)
    ant1 = fibo
    fibo = ant1 + ant2
    ant2 = ant1
    print(fibo)
    contador = contador + 1

def exercicio38():
  contador = 0; maior = 0; menor = 0
  while contador < 4:
    valor = float(input("Digite um valor"))
    if contador == 0:
      menor = valor
    if valor < menor:
      menor = valor
    elif valor > maior:
      maior = valor
    contador = contador + 1
  print("Menor",menor)
  print("Maior",maior)
    
def exercicio39():
  contador = 1
  while contador < 64:
    print(2**contador)

def exercicio40():
  valor1 = int(input("Verificar numeros primos ate: "))
  valor2 = int(input("Verificar numeros primos ate: "))
  aux1,aux2 = valor1, valor2
  if valor1 > valor2:
    while aux1 > aux2:
      moduloPrimo(aux2)
      aux2 += 1
  elif valor2 > valor1:
    while aux2 > aux1:
      moduloPrimo(aux1)
      aux1 += 1

def moduloPrimo(n):
    mult = 0
    for count in range(0,13):
      if (n % count == 0):
        mult += 1
    if(mult<=2):
      print(n,"É primo")

def exercicio41():
  dado1,dado2 =1,6;fim = 0
  while fim != 3:
    if dado1+dado2 == 7:
      print(dado1,dado2)
      print(dado2,dado1)
    dado1 = dado1 + 1
    dado2 = dado2 - 1
    fim = fim + 1

def exercicio42():
  contador = contador2 = 1
  somatoria = 0
  while contador <= 50:
    if contador == 1:
      somatoria = somatoria + (contador/contador)
      contador2 = contador2 + 2
    else:
      somatoria = somatoria + (contador/contador2)
    contador = contador + 1
    contador2 = contador2 + 2
  print(somatoria)

def exercicio43():
  ana = 1.1
  maria = 1.5
  contador = 0
  while ana > maria:
    ana = ana + 0.03
    maria = maria + 0.02
    contador = contador + 1
  print(contador)

def exercicio44():
  base = int(input("Digite o valor da base"))
  expoente = int(input("Digite o valor do expoente"))
  print(base ** expoente)

def exercicio45():
  contador = 1; somatoria = 0
  while contador < 15:
    if contador % 2 == 0:
      somatoria = (somatoria + (contador / contador ** 2)) * -1
    else:
      somatoria = somatoria + (contador / contador ** 2)
  print(somatoria)

def exercicio46():
  