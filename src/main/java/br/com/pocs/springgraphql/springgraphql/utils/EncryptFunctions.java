package br.com.pocs.springgraphql.springgraphql.utils;

import org.apache.commons.codec.binary.Hex;

public class EncryptFunctions {

    public static byte[] unhex(String texto) throws Exception{
        return Hex.decodeHex(texto.replace("-", ""));
    }

    public static String hex(byte[] texto) throws Exception{
        return Hex.encodeHexString(texto);
    }
}
