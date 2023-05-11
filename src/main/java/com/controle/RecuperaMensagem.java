package com.controle;

import com.servico.MensagemServico;
import com.servico.MensagemServicoImpl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author osmar
 */
public class RecuperaMensagem implements HttpHandler {

    @Override
    public void handle(HttpExchange request) throws IOException {

        //Instancia o serviço de mensagem
        MensagemServico mensagem = new MensagemServicoImpl();
        //Recupera a mensagem                
        String resposta = "mensagem armazenada:" + mensagem.getMensagem();

        request.sendResponseHeaders(200, resposta.length());
        OutputStream corpo = request.getResponseBody();
        corpo.write(resposta.getBytes());
        corpo.close();
    }
}
