package efs.task.todoapp;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;

public class Base64Utils {
    public static String encode(final String value){
        // konwersja do byte
        final byte[] valueBytes = value.getBytes(StandardCharsets.ISO_8859_1);

        // pobranie encodera
        final Encoder base64Encoder = Base64.getEncoder();

        // konwersja
        final String base64EncodedValue = base64Encoder.encodeToString(valueBytes);

        // reprezentacja
        return base64EncodedValue;
    }

    public static String decode(final String value){
        final Decoder base64Decoder = Base64.getDecoder();

        final byte[] decodedValueBytes = base64Decoder.decode(value);

        // konwersja danych binarnych
        return new String(decodedValueBytes, StandardCharsets.ISO_8859_1);
    }
}
