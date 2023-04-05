package ee.nets.ipmparserdemo;

import ee.nets.ipmparserdemo.service.UnPackIsoMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileReader;

@SpringBootTest
class IpmParserTest {

    static final String TEST_FILE_NAME = "src/test/resources/pay202303066638.ipm";
    @Autowired
    private UnPackIsoMessage unPackIsoMessage;

    @Test
    void parseIpmFile() {

        try (BufferedReader br = new BufferedReader(new FileReader(TEST_FILE_NAME))) {

            String strCurrentLine;

            while ((strCurrentLine = br.readLine()) != null) {
                System.out.printf("%n%s%n%s%n%s%n", "----UnParsed IsoMessage -----", strCurrentLine, "----Parsed IsoMessage -----");
                unPackIsoMessage.unpackMessage(strCurrentLine);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

