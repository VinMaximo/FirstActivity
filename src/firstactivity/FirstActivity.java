package firstactivity;

import java.io.FileReader;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class FirstActivity {

    public static void main(String[] args) {
        ReadFile();
    }

    private static void ReadFile() {
        String stopWords = "de \n" + "a \n" + "o \n" + "que \n" + "e \n" + "do \n" + "da \n" + "em \n" + "um \n" + "para \n" + "é \n" + "com \n" + "não \n" + "uma \n" + "os \n" + "no \n" + "se \n"
                + "na \n" + "por \n" + "mais \n" + "as \n" + "dos \n" + "como \n" + "mas \n" + "foi \n" + "ao \n" + "ele \n" + "das \n" + "tem \n" + "à \n" + "seu \n" + "sua \n" + "ou \n" + "ser \n" + "quando \n" + "muito \n" + "há \n" + "nos \n" + "já \n" + "está \n" + "eu \n" + "também \n" + "só \n" + "pelo \n" + "pela \n" + "até \n" + "isso \n" + "ela \n" + "entre \n"
                + "era \n" + "depois \n" + "sem \n" + "mesmo \n" + "aos \n" + "ter \n" + "seus \n" + "quem \n" + "nas \n" + "me \n" + "esse \n" + "eles \n" + "estão \n" + "você \n" + "tinha \n" + "foram \n" + "essa \n" + "num \n" + "nem \n" + "suas \n" + "meu \n" + "às \n" + "minha \n" + "têm \n" + "numa \n" + "pelos \n" + "elas \n" + "havia \n" + "seja \n" + "qual \n" + "será \n" + "nós \n" + "tenho \n" + "lhe \n" + "deles \n" + "essas \n" + "esses \n" + "pelas \n" + "este \n" + "fosse \n" + "dele \n" + "tu \n" + "te \n" + "vocês \n" + "vos \n" + "lhes \n" + "meus \n" + "minhas\n" + "teu \n" + "tua\n" + "teus\n" + "tuas\n" + "nosso \n" + "nossa\n" + "nossos\n" + "nossas\n" + "dela \n" + "delas \n" + "esta \n" + "estes \n" + "estas \n" + "aquele \n" + "aquela \n" + "aqueles \n" + "aquelas \n" + "isto \n" + "aquilo \n" + "estou\n" + "está\n" + "estamos\n" + "estão\n" + "estive\n" + "esteve\n" + "estivemos\n" + "estiveram\n" + "estava\n" + "estávamos\n" + "estavam\n" + "estivera\n" + "estivéramos\n" + "esteja\n" + "estejamos\n" + "estejam\n" + "estivesse\n" + "estivéssemos\n" + "estivessem\n" + "estiver\n" + "estivermos\n" + "estiverem\n" + "hei\n" + "há\n" + "havemos\n" + "hão\n" + "houve\n" + "houvemos\n" + "houveram\n" + "houvera\n" + "houvéramos\n" + "haja\n" + "hajamos\n" + "hajam\n" + "houvesse\n" + "houvéssemos\n" + "houvessem\n" + "houver\n" + "houvermos\n" + "houverem\n" + "houverei\n" + "houverá\n" + "houveremos\n" + "houverão\n" + "houveria\n" + "houveríamos\n" + "houveriam\n" + "sou\n" + "somos\n" + "são\n" + "era\n" + "éramos\n" + "eram\n" + "fui\n" + "foi\n" + "fomos\n" + "foram\n" + "fora\n" + "fôramos\n" + "seja\n" + "sejamos\n" + "sejam\n" + "fosse\n" + "fôssemos\n" + "fossem\n" + "for\n" + "formos\n" + "forem\n" + "serei\n" + "será\n" + "seremos\n" + "serão\n" + "seria\n" + "seríamos\n" + "seriam\n" + "tenho\n" + "tem\n" + "temos\n" + "tém\n" + "tinha\n" + "tínhamos\n" + "tinham\n" + "tive\n" + "teve\n" + "tivemos\n" + "tiveram\n" + "tivera\n" + "tivéramos\n" + "tenha\n" + "tenhamos\n" + "tenham\n" + "tivesse\n" + "tivéssemos\n" + "tivessem\n" + "tiver\n" + "tivermos\n" + "tiverem\n" + "terei\n" + "terá\n" + "teremos\n" + "terão\n" + "teria\n" + "teríamos\n" + "teriam";

        Scanner in;
        try {

            // Busca o arquivo na pasta
            String texto = Paths.get(System.getProperty("user.dir")).toString();
            System.out.println(texto + "\\data.txt");
            String pastLine;

            String line = null;
            in = new Scanner(new FileReader(texto + "\\data.txt"));

            List<String> words = new ArrayList<>();
            int countLines = 0;
            int countPhrases = 0;
            List<String> aux = new ArrayList<>();
            List<List<String>> paragraphs = new ArrayList<>();

            // Percorre o documento linha por linha
            while (in.hasNextLine()) {

                // Variável para mapear 
                countLines++;

                // Variável usada para verificar se começou um novo parágrafo
                pastLine = line;
                line = removerAcentos(in.nextLine());

                // Verificação se tem um novo parágrafo iniciando
                if ((pastLine != null && pastLine.isEmpty() && !line.isEmpty()) || pastLine == null) {
                    System.out.println("\nO parágrafo se inicia na linha: " + countLines);
                    countPhrases = 0;
                }

                // Verificação para ver se o parágrafo terminou, caso o contrário eu adiciono a frase no array de linhas do meu parágrafo
                if ((pastLine != null && !pastLine.isEmpty() && line.isEmpty())) {
                    paragraphs.add(aux);
                    System.out.println("Numero de frases: " + aux.size());
                    aux = new ArrayList<>();
                } else if (!line.isEmpty()) {
                    aux.add(line);
                }

                if (!line.isEmpty()) {
                    countPhrases++;
                }

                // Verifica a quantidade de sentenças 
                if (line.contains("?") || line.contains(".") || line.contains("!")) {
                    countPhrases++;
                }

                // Separo as palavras por espaço
                String frutas[] = line.split(" ");

                // Percorre todas as palavras e mostram em que linha estão
                for (String fruta : frutas) {
                    words.add(fruta);
                    System.out.println("Palavra: " + fruta + ", na linha: " + countLines);

                }

            }

            // Ordena as palavras em ordem alfabética
            Collections.sort(words, (String s1, String s2) -> {
                s1 = s1.toLowerCase();
                s2 = s2.toLowerCase();
                return s1.compareToIgnoreCase(s2);
            });

            
            // Verifica a quantidade de vezes que a palavra aparece no texto
            for (int i = 0; i < words.size(); i++) {
                List<String> auxiliar = words;
                int ocorrencias = 0;
                for (int j = 0; j < auxiliar.size(); j++) {
                    if (auxiliar.get(j).equals(words.get(i))) {
                        ocorrencias++;
                    }

                }
                System.out.println(words.get(i) + " acontece " + ocorrencias + " vezes \n");
                i = i + ocorrencias;
            }

            // Mostra o parágrafo, quantas linhas ele tem, número de palavras com e sem stop words e verifica quantas vezes a palavra repete e a distância entre elas
            for (int i = 0; i < paragraphs.size(); i++) {
                System.out.println("\n \nParágrafo " + i);
                System.out.println("\n O paragrafo possui " + paragraphs.get(i).size() + " frases \n");
                for (int j = 0; j < paragraphs.get(i).size(); j++) {
                    int countInSentence = 0;
                    int countWithoutSW = 0;
                    String l = paragraphs.get(i).get(j).replace(",", "");
                    String frutas[] = l.split(" ");
                    List<String> paragrafo = paragraphs.get(i);
                    List<String> verifiedWords = new ArrayList<>();

                    for (int k = 0; k < frutas.length; k++) {
                        if (!verifiedWords.contains(frutas[k])) {
                            verifyRepeatedWords(paragrafo, frutas[k]);
                        }

                        if (!stopWords.contains(frutas[k])) {
                            countWithoutSW++;
                        }
                        countInSentence++;
                    }

                    System.out.println("\nA frase possui " + countInSentence + " palavras com stop words");
                    System.out.println("A frase possui " + countWithoutSW + " palavras sem stop words");
                }
            }

            in.close();
        } catch (Exception ex) {
            String exception = ex.getMessage();
        }

    }

    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    private static void verifyRepeatedWords(List<String> paragraph, String word) {
        int count = 0;
        int ocorrencias = 0;
        int firstPosition = 0;
        for (int j = 0; j < paragraph.size(); j++) {
            String l = paragraph.get(j).replace(",", "");
            String frutas[] = l.split(" ");
            System.out.println(l);
            for (int k = 0; k < frutas.length; k++) {
                count++;

                if (frutas[k].equals(word)) {
                    if (ocorrencias == 0) {
                        ocorrencias++;
                        firstPosition = count;
                    } else {
                        System.out.println("Palavra: \"" + word + "\" Distância entre as palavras é de " + (count - firstPosition) + " palavras");
                        firstPosition = count;
                        System.out.println("");
                    }
                }
            }

        }

    }

}
