import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception{
		
		// fazer a conexão Http e buscar os 250 filmes
		
		String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
		URI endereco = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		// Get do Objeto (titulo, foto, nota)
		var parse = new JasonParser();
		List<Map<String, String>> listaDeFilmes = parse.parse(body);
		
		// Exibir e manipular as informações
		
		for (Map<String, String> filme : listaDeFilmes) {
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
			System.out.println("Classificacao do Filme: " + filme.get("imDbRating"));
			System.out.println();
			
		}
	}

}
