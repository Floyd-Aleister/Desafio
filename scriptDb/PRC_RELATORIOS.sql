CREATE OR REPLACE PROCEDURE PRC_RELATORIOS(P_CD_CLIENTE NUMBER, P_ID_CONTA NUMBER, P_PERIODO_DIAS NUMBER  ) IS

--CURSORES:
--Relat�rio de saldo de todos os clientes       --Cliente: X - Cliente desde: DD/MM/YYYY � Saldo em DD/MM/YYYY: 0.000,00
CURSOR cSaldoTodosClientes(P_CD_CLIENTE NUMBER, P_ID_CONTA NUMBER, P_PERIODO_DIAS NUMBER) IS
  SELECT CLI.NOME_CLIENTE, C.SALDO
  FROM CLIENTE CLI,
     CONTA   C
  WHERE CLI.CD_CLIENTE = C.CLIENTE_CD_CLIENTE
  AND CLI.CD_CLIENTE =  P_CD_CLIENTE
  AND C.ID_CONTA =  P_ID_CONTA
  AND  CLI.DH_CADASTRO  BETWEEN  ( SYSDATE - P_PERIODO_DIAS)  AND SYSDATE;      --Per�odo de dias at� a data atual
                                                                             --Exp: PERIODO_DIAS = 10;  Ent�o o per�odo ser� de 10 dias contando da data de hoje para traz.

CURSOR cRelatSaldoCliente(P_CD_CLIENTE NUMBER, P_ID_CONTA NUMBER) IS         --Inconpleto
  SELECT EN.RUA, EN.NUMERO, EN.COMPLEMENTO, EN.BAIRRO, EN.CIDADE, EN.UF, EN.CEP   --Endere�o
  ,MOV.TP_MOVIMENTACAO, MOV.VALOR                                                 --Movimenta��es
  , CONT.SALDO  SALDO_ATUAL                                                       --Conta
  FROM  CLIENTE CLI,
        CONTA CONT,
        ENDERECO EN,
        MOVIEMENTACAO MOV
  WHERE CLI.CD_CLIENTE = CONT.CLIENTE_CD_CLIENTE
  AND   CONT.ID_CONTA = MOV.ID_CONTA
  AND   CLI.CD_ENDERECO = EN.CD_ENDERECO
  AND CLI.CD_CLIENTE =  P_CD_CLIENTE
  AND CONT.ID_CONTA =  P_ID_CONTA
  AND MOV.TP_MOVIMENTACAO = 'C'    --Cr�dito
  --
  UNION ALL
  --
  SELECT EN.RUA, EN.NUMERO, EN.COMPLEMENTO, EN.BAIRRO, EN.CIDADE, EN.UF, EN.CEP   --Endere�o
  ,MOV.TP_MOVIMENTACAO, MOV.VALOR                                                 --Movimenta��es
  ,CONT.SALDO  SALDO_ATUAL                                                       --Conta
  FROM  CLIENTE CLI,
        CONTA CONT,
        ENDERECO EN,
        MOVIEMENTACAO MOV
  WHERE CLI.CD_CLIENTE = CONT.CLIENTE_CD_CLIENTE
  AND   CONT.ID_CONTA = MOV.ID_CONTA
  AND   CLI.CD_ENDERECO = EN.CD_ENDERECO
  AND CLI.CD_CLIENTE =  P_CD_CLIENTE
  AND CONT.ID_CONTA =  P_ID_CONTA
  AND MOV.TP_MOVIMENTACAO = 'D';     --D�bito

 --VAriaveis:
 rRelatSaldoCliente      cRelatSaldoCliente%ROWTYPE;
 rSaldoTodosClientes     cSaldoTodosClientes%ROWTYPE;


BEGIN
  --
  IF P_CD_CLIENTE IS NULL THEN
    Raise_Application_Error(-20999,'C�digo do cliente � obrigat�rio!');
  END IF;
  --
  IF P_ID_CONTA IS NULL THEN
    Raise_Application_Error(-20999,'C�digo da conta � obrigat�rio!');
  END IF;
  --
  IF P_PERIODO_DIAS IS NULL THEN
    Raise_Application_Error(-20999,'� preciso especificar o per�odo do relat�rio!');
  END IF;


 FOR rRelatSaldoCliente  IN cRelatSaldoCliente(P_CD_CLIENTE, P_ID_CONTA)  LOOP
  Dbms_Output.Put_Line('Rua: ' || rRelatSaldoCliente.RUA
                     || ' - Numero: ' || rRelatSaldoCliente.NUMERO
                     || ' - Complemento: ' || rRelatSaldoCliente.COMPLEMENTO
                     || ' - Bairro: ' || rRelatSaldoCliente.BAIRRO
                     || ' - Cidade: ' || rRelatSaldoCliente.CIDADE
                     || ' - Uf: ' || rRelatSaldoCliente.UF
                     || ' - Cep: ' || rRelatSaldoCliente.CEP
                     || ' - Tipo Movimenta��o: ' || rRelatSaldoCliente.TP_MOVIMENTACAO
                     || ' - Valor movimentado: ' || rRelatSaldoCliente.VALOR
                     || ' - Saldo atual: ' || rRelatSaldoCliente.SALDO_ATUAL);
 END LOOP;
 --
 FOR rSaldoTodosClientes  IN cSaldoTodosClientes(P_CD_CLIENTE, P_ID_CONTA, P_PERIODO_DIAS )  LOOP
  Dbms_Output.Put_Line('Cliente: ' || rSaldoTodosClientes.NOME_CLIENTE
                     || ' - Saldo: ' || rSaldoTodosClientes.SALDO);

 END LOOP;


EXCEPTION
  WHEN Others THEN
    Raise_Application_Error(-20999,'Erro ao exibir relat�rio! ' || SQLERRM );
END; --PRC_RELATORIOS
/



