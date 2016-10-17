package br.nom.marcio.belo;

import java.math.BigDecimal;

public class Bonificado extends Funcionario
{
    public static final BigDecimal CINCO = new BigDecimal("5.00");
    private BigDecimal bonus = BigDecimal.ZERO;

    protected Bonificado(String nome, BigDecimal salarioAnual) {
        super(nome, salarioAnual);
    }

    @Override
    public void reajustar(BigDecimal taxa)
    {
        validarTaxa( taxa);
        this.salarioAnual = this.salarioAnual.multiply( taxa.divide( new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)
                .add( BigDecimal.ONE) );
    }

    protected void validarTaxa(BigDecimal taxa)
    {
        if (isTaxaForaIntervalo(taxa)) {
            throw new IllegalArgumentException("Taxa deve estar no limite entre 0 e 5");
        }
    }

    @Override
	protected boolean isTaxaForaIntervalo(BigDecimal taxa)
    {
        return taxa.compareTo( BigDecimal.ZERO) <= 0 || taxa.compareTo(CINCO) > 0;
    }

    public void acumularBonus(BigDecimal acrescimoBonus)
    {
        bonus = bonus.add( acrescimoBonus);
    }

    @Override
    public BigDecimal getSalarioAnual() {
        return salarioAnual.add( bonus).setScale( 2, BigDecimal.ROUND_UP);
    }
}
