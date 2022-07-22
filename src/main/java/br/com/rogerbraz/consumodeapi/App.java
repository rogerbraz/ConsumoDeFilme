package br.com.rogerbraz.consumodeapi;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		
		ClienteHttp body = new ClienteHttp();

        // extrair só os dados que interessam (titulo, poster, classificação)
		JsonParser parser = new JsonParser();
        List<Map<String, String>> conteudo = parser.parse(body);

        // exibir e manipular os dados 
        var geradora = new GeradoraDeFigurinhas();
        
        for (int i=0 ; i<3 ; i++) {
        	 Map<String,String> filme =  conteudo.get(i);

             	
                 String urlImagem = filme.get("image");
                 String titulo = filme.get("title");

                 InputStream inputStream = new URL(urlImagem).openStream();
                 String nomeArquivo = "saida/" + filme.get("rank") +" - " + titulo.replaceAll(
                         "[\\/|\\\\|\\*|\\:|\\||\"|\'|\\<|\\>|\\{|\\}|\\?|\\%|,]",
                         "") + ".png";

                 geradora.cria(inputStream, nomeArquivo);

                 System.out.println(titulo);
                 System.out.println();
        
       
        }
    }
}