package br.nom.marcio.belo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FuncionarioTest
{

    @Test
    public void reajustarMensalistaTest()
    {
        Funcionario mensalista = new Mensalista("Marcio", new BigDecimal("120000"));
        mensalista.reajustar( new BigDecimal("5"));
        BigDecimal salarioAposReajuste = mensalista.getSalarioAnual();
        assertEquals( new BigDecimal( "126000.00"), salarioAposReajuste);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reajustarMensalistaForaFaixaTest()
    {
        Funcionario mensalista = new Mensalista("Marcio", new BigDecimal("120000.00"));
        mensalista.reajustar( new BigDecimal("15"));
    }

    @Test
    public void reajustarBonificadoTest()
    {
        Funcionario bonificado = new Bonificado("Ana", new BigDecimal("80000.00") );
        bonificado.reajustar( BigDecimal.ONE);
        BigDecimal salarioAposReajuste = bonificado.getSalarioAnual();
        assertEquals( new BigDecimal( "80800.00"), salarioAposReajuste);
    }

    @Test
    public void bonificarBonificadoTest()
    {
        Bonificado bonificado = new Bonificado("Ana", new BigDecimal("80000.00") );
        bonificado.acumularBonus( new BigDecimal("4000"));
        BigDecimal salarioAposReajuste = bonificado.getSalarioAnual();
        assertEquals( new BigDecimal( "84000.00"), salarioAposReajuste);
    }

    @Test
    public void testVoluntario()
    {
        Funcionario funcionario = new Voluntario("Leo", new BigDecimal("1000000"));
        assertEquals( new BigDecimal("0.00"), funcionario.getSalarioAnual());
    }
    
    @Test
    public void testVoluntarioisFuncionario()
    {
    	try{
    		Funcionario voluntario = new Voluntario("Sem Nome",new BigDecimal("1000.00"));
	    	voluntario.reajustar(new BigDecimal("50.00"));
    	}
    	catch(IllegalStateException e)
    	{
    		String expectedMessage = "nao implementado";
    		assertEquals(expectedMessage, e.getMessage());
    	}
    }
}
