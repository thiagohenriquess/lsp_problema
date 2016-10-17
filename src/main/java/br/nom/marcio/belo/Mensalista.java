package br.nom.marcio.belo;

import java.math.BigDecimal;

public class Mensalista extends Funcionario
{
    public Mensalista(String nome, BigDecimal salarioAnual)
    {
        super( nome, salarioAnual);
    }

    @Override
    public void reajustar(BigDecimal taxa)
    {
        validarTaxa( taxa);
        this.salarioAnual = this.salarioAnual.multiply( taxa.divide( new BigDecimal("100")
                , 2, BigDecimal.ROUND_HALF_UP).add( BigDecimal.ONE) );
    }

    @Override
    protected void validarTaxa(BigDecimal taxa)
    {
        if( isTaxaForaIntervalo(taxa) )
        {
            throw new IllegalArgumentException("Taxa deve estar no limite entre 0 e 10");
        }
    }

    @Override
    protected boolean isTaxaForaIntervalo(BigDecimal taxa) {
        return taxa.compareTo( BigDecimal.ZERO) <= 0 || taxa.compareTo( BigDecimal.TEN) > 0;
    }

}
