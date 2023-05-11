package com.controle;

import com.servico.MensagemServico;
import com.servico.MensagemServicoImpl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author osmar
 */
public class ModificaMensagem implements HttpHandler {

    @Override
    public void handle(HttpExchange request) throws IOException {

        //Recupera os parâmetros
        Map<String, String> parametros = consultaParaMapa(request.getRequestURI().getQuery());
        String parMensagem = parametros.get("mensagem");

        //Instancia o serviço de mensagem
        MensagemServico mensagem = new MensagemServicoImpl();
        //Modifica a mensagem
        mensagem.setMensagem(parMensagem);
        String resposta = "mensagem recebida:" + parMensagem;

        request.sendResponseHeaders(200, resposta.length());
        OutputStream corpo = request.getResponseBody();
        corpo.write(resposta.getBytes());
        corpo.close();
    }

    /**
     *
     * Retorna os parâmetros da URL em um map.
     *
     * @param consulta Consulta com os parâmetros a serem colocados em um map.
     *
     * @return map Mapa com os parâmetros.
     *
     */
    public static Map<String, String> consultaParaMapa(String consulta) {
        Map<String, String> resultado = new HashMap<>();
        for (String parametro : consulta.split("&")) {
            String[] parParametro = parametro.split("=");
            if (parParametro.length > 1) {
                resultado.put(parParametro[0], parParametro[1]);
            } else {
                resultado.put(parParametro[0], "");
            }
        }
        return resultado;
    }
}
