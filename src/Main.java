import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) throws Exception {

        String url = "http://localhost:8080/linguagens";
        ContentExtractor chamaExtrator = new ExtratorConteudoIMDB();
        
       // String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
       // ContentExtractor chamaExtrator = new ExtratorConteudoNasa();
        
        ClienteHttp clienteHttp = new ClienteHttp();
        String json = clienteHttp.buscaDados(url);
        
        //exibir e manipular os dados
		List <Conteudo> conteudos = chamaExtrator.extrator(json);
		
        var geradora = new StickerGenerator();
        
        for (int i = 0; i < 3; i++) {
        	       	
        	Conteudo conteudo = conteudos.get(i);
				        	
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = "saida/" + conteudo.getTituto() + ".png";
			
			geradora.create(inputStream, nomeArquivo);
			
			System.out.println(conteudo.getTituto());
			System.out.println(conteudo.getUrlImagem());
			System.out.println(i);
		}
			
		}
		
	}


