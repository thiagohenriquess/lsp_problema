package br.nom.marcio.belo;

import java.math.BigDecimal;

public abstract class Funcionario
{
    private String nome;
    protected BigDecimal salarioAnual;



    protected Funcionario(String nome, BigDecimal salarioAnual) {
        this.nome = nome;
        this.salarioAnual = salarioAnual;
    }

    public String getNome() {
        return nome;
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
}
