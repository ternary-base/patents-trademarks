package br.gov.inpi;

import br.gov.inpi.service.RevistaService;
import br.gov.inpi.domain.Revista;
import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Parser {

    private static XStream getXtream() {

        XStream stream = new XStream();

        stream.autodetectAnnotations(true);
        stream.alias("revista", Revista.class);

        return stream;
    }

    public static void main(String args[]) {


        if (args == null || args.length == 0) {

            System.out.println("Informe o nome do arquivo XML. Exemplo: /path/2332.xml");
            return;
        }

        if (args[0].toLowerCase().contains("xml")) {
           XStream stream = getXtream();

            Revista revista = null;
            try {
                revista = (Revista) stream.fromXML(new FileInputStream(args[0]));
            } catch (FileNotFoundException e) {
                System.err.println("Não foi possível processar o arquivo: ".concat(args[0]));
                System.err.println("\n\n\n");
                e.printStackTrace();
            }

            RevistaService revistaService = new RevistaService();
            revistaService.inserir(revista);

            System.out.println("Processamento concluído arquivo: ".concat(args[0]));

        }

    }
}
