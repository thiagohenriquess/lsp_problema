package br.nom.marcio.belo;

import java.math.BigDecimal;

public abstract class Funcionario extends SerHumano
{
    protected BigDecimal salarioAnual;

    protected Funcionario(String nome){
    	super(nome);
    }

    protected Funcionario(String nome, BigDecimal salarioAnual) {
        super(nome);
        this.salarioAnual = salarioAnual;
    }

    public BigDecimal getSalarioAnual()
    {
        return salarioAnual.setScale( 2, BigDecimal.ROUND_UP);
    }

    /**
     * Taxa percentual na qual o salário anualizado será reajustado
     * @param taxa valor maior que 0 e menor ou igual a 10.
     */
    public abstract void reajustar( BigDecimal taxa);
    
    protected abstract boolean isTaxaForaIntervalo(BigDecimal taxa);
    
    protected abstract void validarTaxa(BigDecimal taxa); 
	
}
