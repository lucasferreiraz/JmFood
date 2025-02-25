package com.nesrux.jmfood.api.exceptionHandler;

import lombok.Getter;

@Getter
public enum TipoProblema {
    MENSAGEM_INCOMPREENSIVEL("mensagem-incompreensivel", "Mensagem nao compreendida"),
    RECURSO_NAO_ENCONTRADO("recurso-nao-encontrado", "recurso não encontrado"),
    ENTIDADE_EM_USO("entidade-em-uso", "Entidade esta em uso"),
    ERRO_DE_NEGOCIO("violacao-negocio", "violação das regras de negócio"),
    ERRO_DE_SISTEMA("erro-sistema", "Ocorreu um erro durante o funcionamento da aplicação"),
    DADOS_INVALIDOS("dados-invalidos", "os dados estão invalidos"),
    PARAMETRO_INVALIDO("parametro-invalido", "O parametro da URL esta incorreto");

    private String titulo;
    private String uri;
    private TipoProblema(String caminho, String titulo) {
	this.uri = "https://jmfood.com.br/" + caminho;
	this.titulo = titulo;

    }

    /*
     * Enum que ajuda no builder de ErroAPI, para facilitar a escrita de novos
     * códigos e na manutenção do mesmo.
     */
}
