package challenge;

import java.util.HashMap;
import java.util.Map;

public class CriptografiaCesariana implements Criptografia {

    private final static Integer LETRA_A_MINUSCULA_ASCII = 97;
    private final static Integer LETRA_Z_MINUSCULA_ASCII = 122;
    private final static Integer NUMERO_PULO_CASAS = 3;

    public static Map<Integer, Integer> alfabetoAsciiCifrado = new HashMap<>();
    public static Map<Integer, Integer> alfabetoAsciiDecifrado = new HashMap<>();

    @Override
    public String criptografar(String texto) {
        return converterTexto(texto, true);
        //throw new UnsupportedOperationException("esse method nao esta implementado aainda");
    }

    @Override
    public String descriptografar(String texto) {
        return converterTexto(texto, false);
        //throw new UnsupportedOperationException("esse method nao esta implementado aainda");
    }

    private static String converterTexto(String texto, boolean isCriptografar) {

        if(texto.isEmpty()) throw new IllegalArgumentException();

        StringBuffer textoConvertido = new StringBuffer();
        texto = texto.toLowerCase();

        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.substring(i, i + 1).toCharArray()[0];
            buscarCaracterCorrespondente(isCriptografar ? alfabetoAsciiCifrado : alfabetoAsciiDecifrado, textoConvertido, letra);
        }
        return textoConvertido.toString();
    }

    private static void buscarCaracterCorrespondente(Map<Integer, Integer> asciiMap, StringBuffer textoConvertido, char letra) {
        int asciiCodigo = letra;
        if(asciiMap.containsKey(asciiCodigo)) {
            textoConvertido.append((char)asciiMap.get(asciiCodigo).intValue());
        } else {
            textoConvertido.append(letra);
        }
    }

    static  {
        for (int codigoAscii = LETRA_A_MINUSCULA_ASCII; codigoAscii <= LETRA_Z_MINUSCULA_ASCII; codigoAscii++) {

            if(codigoAscii - NUMERO_PULO_CASAS >= LETRA_A_MINUSCULA_ASCII) {
                alfabetoAsciiDecifrado.put(codigoAscii, codigoAscii - NUMERO_PULO_CASAS);
                alfabetoAsciiCifrado.put(codigoAscii - NUMERO_PULO_CASAS, codigoAscii);
            } else {
                // Trata casos que precisa retornar ao final do alfabeto
                int primeirosPulos = codigoAscii - LETRA_A_MINUSCULA_ASCII;
                int pulosRestantes = LETRA_Z_MINUSCULA_ASCII - (NUMERO_PULO_CASAS - primeirosPulos -1);
                alfabetoAsciiDecifrado.put(codigoAscii, pulosRestantes);
                alfabetoAsciiCifrado.put(pulosRestantes, codigoAscii);
            }

        }
    }

}
