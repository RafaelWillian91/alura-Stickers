import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoIMDB implements ContentExtractor{
	
	public List<Conteudo> extrator(String json){
		
		JsonParser parser = new JsonParser(); 
        List<Map<String, String>> listAtributos = parser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();
        
        //popular a lista de conteudos
        for (Map<String, String> atributos : listAtributos) {
        	String titulo = atributos.get("title");
        	String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");;
			Conteudo conteudo = new Conteudo(titulo, urlImagem);
			conteudos.add(conteudo);
		}
        
        return conteudos;
	}
		
	
	
}
