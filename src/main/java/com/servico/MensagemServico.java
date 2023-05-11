package com.servico;

/**
 *
 * @author osmar
 */
public interface MensagemServico {

    /**
     * Operação de Web service
     *
     * @return
     */
    public String getMensagem();

    /**
     * Operação de Web service
     *
     * @param mensagem
     */
    public void setMensagem(String mensagem);
}
