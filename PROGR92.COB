       IDENTIFICATION DIVISION.
       PROGRAM-ID. PROGR92.
      *AUTHOR. GABRIEL ALEX MARTINS FERREIRA.
      **************************************
      * CADASTRO DE VEÍCULOS   *
      **************************************
      *----------------------------------------------------------------
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       SPECIAL-NAMES.
             DECIMAL-POINT IS COMMA.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
       SELECT CADVEIC ASSIGN TO DISK
                    ORGANIZATION IS INDEXED
                    ACCESS MODE  IS DYNAMIC
                    RECORD KEY   IS PLACA
                    ALTERNATE RECORD KEY IS PROPRIETARIO WITH DUPLICATES
                    FILE STATUS  IS ST-ERRO.
      *
      *-----------------------------------------------------------------
       DATA DIVISION.
       FILE SECTION.
       FD CADVEIC
               LABEL RECORD IS STANDARD
               VALUE OF FILE-ID IS "REGVEIC.DAT". 
       01 REGVEIC.
          03 PROPRIETARIO       PIC X(30).
          03 PLACA.
          	05 LETRAP PIC X(03).
          	05 NUMEROP PIC 9(04).
          03 MODELO              PIC X(20).
          03 MARCA               PIC 9(02).
          03 COR       		 PIC X(01).
          03 ANOFABRICACAO       PIC 9(04).
      *
      *-----------------------------------------------------------------
       WORKING-STORAGE SECTION.
       77 W-CONT        PIC 9(06) VALUE ZEROS.
       77 W-OPCAO       PIC X(01) VALUE SPACES.
       77 W-ACT         PIC 9(02) VALUE ZEROS.
       77 MENS          PIC X(50) VALUE SPACES.
       77 LIMPA         PIC X(50) VALUE SPACES. 
       01 ST-ERRO       PIC X(02) VALUE "00".
       01 TXTTPAMIGO    PIC X(10) VALUE SPACES.
       01 IND           PIC 9(02) VALUE ZEROS.
       01 TEXSEXO       PIC X(12) VALUE SPACES.

       01 TBMARCA.
          03 TABMARCA    PIC X(20) OCCURS 9 TIMES.

       01 TXTMARCA PIC 9(02).

       01 TABCORX.
	  03 FILLER     PIC X(15) VALUE "PPRETO".
	  03 FILLER     PIC X(15) VALUE "BBRANCO".
	  03 FILLER     PIC X(15) VALUE "AAZUL".
	  03 FILLER     PIC X(15) VALUE "VVERMELHO".
	  03 FILLER     PIC X(15) VALUE "RROSA".
	  03 FILLER     PIC X(15) VALUE "CCINZA".
       01 TABCOR REDEFINES TABCORX.
          03 TBCOR   PIC X(15) OCCURS 6 TIMES.
       01 TXTCOR.
          03 TXTCOR1 PIC X(01) VALUE SPACES.
          03 TXTCOR2 PIC X(14) VALUE SPACES. 

      *-----------------------------------------------------------------
       SCREEN SECTION.
       
       01  TELATXT.
           05  LINE 03  COLUMN 01 
               VALUE  "                    Cadastro de propriet".
           05  LINE 03  COLUMN 41 
               VALUE  "ario e Veiculo".
           05  LINE 07  COLUMN 01 
               VALUE  "                   Placa:".
           05  LINE 08  COLUMN 01 
               VALUE  "                   Nome do proprietario:".
           05  LINE 09  COLUMN 01 
               VALUE  "                   Marca:".
           05  LINE 10  COLUMN 01 
               VALUE  "                   Modelo:".
           05  LINE 11  COLUMN 01 
               VALUE  "                   Cor:".
           05  LINE 12  COLUMN 01 
               VALUE  "                   Ano de fabricacao:".
           05  DISPLAYLETRAPLACA
               LINE 07  COLUMN 26  PIC X(03)
               USING  LETRAP.
           05  DISPLAYNUMEROPLACA
               LINE 07  COLUMN 29  PIC 9(04)
               USING  NUMEROP.
           05  DISPLAYPROPRIETARIO
               LINE 08  COLUMN 41  PIC X(30)
               USING  PROPRIETARIO.
           05  DISPLAYMARCA
               LINE 09  COLUMN 26  PIC 9(02)
               USING  TXTMARCA.
           05  DISPLAYMODELO
               LINE 10  COLUMN 27  PIC X(20)
               USING  MODELO.
           05  DISPLAYCOR
               LINE 11  COLUMN 24  PIC X(01)
               USING  COR.
           05  DISPLAYANO
               LINE 12  COLUMN 38  PIC 9(04)
               USING  ANOFABRICACAO.

      *-----------------------------------------------------------------
       PROCEDURE DIVISION.
       INICIO.
           MOVE "VOLKSWAGEN"   TO TABMARCA(1)
           MOVE "FORD"         TO TABMARCA(2)
           MOVE "RENAULT"      TO TABMARCA(3)
           MOVE "CHEVROLET"    TO TABMARCA(4)
           MOVE "TOYOTA"       TO TABMARCA(5)
           MOVE "NISSAN"       TO TABMARCA(6)
           MOVE "JAC"          TO TABMARCA(7)
           MOVE "LAND ROVER"   TO TABMARCA(8)
           MOVE "BMW"          TO TABMARCA(9).
       
       R0.
           OPEN I-O CADVEIC
           IF ST-ERRO NOT = "00"  
              IF ST-ERRO = "30"
                 OPEN OUTPUT CADVEIC
                 CLOSE CADVEIC
                 MOVE "*** ARQUIVO CADVEIC FOI CRIADO **" TO MENS
                 PERFORM ROT-MENS THRU ROT-MENS-FIM
                 GO TO R0
              ELSE
                 MOVE "ERRO NA ABERTURA DO ARQUIVO CADVEIC" TO MENS
                 PERFORM ROT-MENS THRU ROT-MENS-FIM
                 GO TO ROT-FIM
           ELSE
                 NEXT SENTENCE.


      *                

       R1.
           MOVE SPACES TO PROPRIETARIO MODELO COR 
	   MOVE SPACES TO LETRAP
	   MOVE ZEROS TO TXTMARCA ANOFABRICACAO NUMEROP
           DISPLAY TELATXT.
           ACCEPT DISPLAYLETRAPLACA.
           ACCEPT DISPLAYNUMEROPLACA.
           ACCEPT DISPLAYPROPRIETARIO.
	      

       R7.
           ACCEPT DISPLAYMARCA.
           ACCEPT DISPLAYMODELO.
           IF TXTMARCA = 0 
                 MOVE "*** DIGITE APENAS DE 1 ATE 9 ***" TO MENS
                 PERFORM ROT-MENS THRU ROT-MENS-FIM
                 GO TO R7.

       R6.
           MOVE 1 TO IND
           ACCEPT DISPLAYCOR.
       R6A.
           MOVE TBCOR(IND) TO TXTCOR
           IF TXTCOR1 NOT = COR
              ADD 1 TO IND
              IF IND < 10
                 GO TO R6A
              ELSE
                 MOVE "*** COR INCORRETA ***" TO MENS
                 PERFORM ROT-MENS THRU ROT-MENS-FIM
                 GO TO R6.
			ACCEPT DISPLAYANO.
       R99.
           DISPLAY (23, 20) "DADOS OK :"
           ACCEPT (23, 33) W-OPCAO
           IF W-OPCAO ="S"
              WRITE REGVEIC
              GO TO R1
           ELSE
              IF W-OPCAO NOT = "N"
                   MOVE "* DIGITE S=SIM   N=NAO *" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO R99
               ELSE 
                   GO TO R1.
			

       ROT-FIM.
           CLOSE CADVEIC.
           STOP RUN.

      *---------[ ROTINA DE MENSAGEM ]---------------------
       ROT-MENS.
                MOVE ZEROS TO W-CONT.
       ROT-MENS1.
               DISPLAY (23, 12) MENS.
       ROT-MENS2.
                ADD 1 TO W-CONT
                IF W-CONT < 3000
                   GO TO ROT-MENS2
                ELSE
                   MOVE SPACES TO MENS
                   DISPLAY (23, 12) MENS.
       ROT-MENS-FIM.
                EXIT.
       FIM-ROT-TEMPO.

      *    FILE STATUS
      *    00 = OPERAÇÃO REALIZADO COM SUCESSO
      *    30 = ARQUIVO NÃO ENCONTRADO
      

