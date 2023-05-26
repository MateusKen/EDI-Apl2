//******************** ATENÇÃO! *********************
// O conteúdo deste arquivo não deve ser modificado!
//******************** ATENÇÃO! *********************
// arquivo: src/apl2/Data.java

package apl2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Data {
	
	/**
	 * Cria uma string com o conteúdo do arquivo texto passado no parâmetro {@code filename}. 
	 * 
	 * @param filename Nome do arquivo texto a ser lido pelo método.
	 * @return {@code String} contendo todo o conteúdo do arquivo texto.
	 * @throws FileNotFoundException Arquivo passado no parâmetro {@code filename} não existe (exceção do {@code FileInputStream}).
	 * @throws IOException Problema ao ler conteúdo do arquivo texto (exceção do {@code BufferedReader}).
	 */
    public static String loadTextFileToString(String filename) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        StringBuilder sb = new StringBuilder();
		while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            sb.append(line).append('\n');
        }
		
		is.close();
		
        return sb.toString();
    }

    /**
     * Salva o conteúdo da {@code String} passada no parâmetro {@code contents} no arquivo texto passado no parâmetro {@code filename}.
     *  
     * @param filename Nome do arquivo texto para salvar o conteúdo da {@code String} {@code contents}.
     * @param contents {@code String} com o conteúdo a ser salvo no arquivo texto {@code filename}.
     * @throws FileNotFoundException Arquivo passado no parâmetro {@code filename} não existe (exceção do {@code FileOutputStream}).
     * @throws IOException Problema ao escrever conteúdo no arquivo texto (exceção do {@code BufferedWriter}).
     */
    public static void saveStringToTextFile(String filename, String contents) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream(filename);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write(contents);
        bw.flush();
        
        os.close();
    }

}
