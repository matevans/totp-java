/**
 * Example Java code to generate TOTP codes for use on HMRC API Platform
 *
 * See https://github.com/samdjstevens/java-totp
 *
 */

import dev.samstevens.totp.code.DefaultCodeGenerator;
import dev.samstevens.totp.code.HashingAlgorithm;
import dev.samstevens.totp.exceptions.CodeGenerationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TOTP {

    private TOTP() {}

    public static void main(String[] args) throws CodeGenerationException, java.text.ParseException{

        String secret = "TEST";
        int interval = 30;

        if (args.length > 0) {
            secret = args[0];
        }
        System.out.println("Using secret = "+ secret);

        DefaultCodeGenerator totpGenerator  = new DefaultCodeGenerator(HashingAlgorithm.SHA512, 8);

        // Generate TOTP for 2021-06-01T00:00:00.000
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date1 = dateFormat.parse("2021-06-01T00:00:00.000+0100");
        long counter1  = date1.getTime() / 1000 / interval;
        String totpCode1 = totpGenerator.generate(secret, counter1);
        System.out.println(date1 +" = "+ totpCode1);

        // Generate TOTP for now
        Date date2  = new Date();
        long counter2  = date2.getTime() / 1000 / interval;
        String totpCode2 = totpGenerator.generate(secret, counter2);
        System.out.println(date2 +" = "+ totpCode2);

    }
}
