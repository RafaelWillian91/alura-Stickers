import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {

	    void create(InputStream inputStream, String nomeArquivo) throws Exception {
		// leitura de imagem

		// InputStream ioEntrada = new FileInputStream("entrada/OPoderosoChefao.jpg");
		// InputStream ioUrl = new
		// URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_2.jpg").openStream();
		BufferedImage imgOriginal = ImageIO.read(inputStream);

		// cria nova imagem em memoria com transparencia e com tamanho novo
		int width = imgOriginal.getWidth();
		int height = imgOriginal.getHeight();
		int newheight = height + 700;
		BufferedImage newOriginal = new BufferedImage(width, newheight, BufferedImage.TRANSLUCENT);

		// copiar a imagem original para nova aimagem (em memoria)
		Graphics2D graphics2d = (Graphics2D) newOriginal.getGraphics();
		graphics2d.drawImage(imgOriginal, 0, 0, null);

		// Configurar a fonte
		graphics2d.setFont(new Font ("Comic Sans MS", Font.BOLD, 152));
		graphics2d.setColor(Color.GRAY);

		// escrever uma frase na nova imagem
		graphics2d.drawString("Lua", 0, newheight - 100);
		
		
		// escrever a nova imagem em um arquivo
		ImageIO.write(newOriginal, "png", new File(nomeArquivo));

	}

}
