package br.com.rogerbraz.consumodeapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
	
	
	// fazer uma conexão HTTP e buscar os top 250 filmes
    //String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
    String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
    URI endereco = URI.create(url);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    String body = response.body();

}
