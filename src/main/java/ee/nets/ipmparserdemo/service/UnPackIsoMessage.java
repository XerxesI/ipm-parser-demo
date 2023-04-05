package ee.nets.ipmparserdemo.service;

import ee.nets.ipmparserdemo.iso.IPMAsciiPackager;
import ee.nets.ipmparserdemo.iso.PDS;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.tlv.TLVList;
import org.jpos.tlv.TLVMsg;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeMap;

@Service
public class UnPackIsoMessage {
    Hashtable<Integer, PDS> pdsFields = new Hashtable<>();

    public void unpackMessage(String input) throws Exception {
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(new IPMAsciiPackager());

        isoMsg.unpack(input.getBytes(StandardCharsets.UTF_8));
        System.out.printf("MTI = %s%n", isoMsg.getMTI());

        for (int i = 1; i <= isoMsg.getMaxField(); i++) {
            if (isoMsg.hasField(i)) {
                if (i == 55) {
                    System.out.printf("Field (%s) = %s%n", i, isoMsg.getString(i));
                    TLVList tlvData = new TLVList();
                    tlvData.unpack(isoMsg.getBytes(55));
                    for (TLVMsg tLVMsg : tlvData.getTags()) {
                        System.out.printf("EMVtag (%s) = %s%n",
                                Integer.toHexString(tLVMsg.getTag()), ISOUtil.hexString(tLVMsg.getValue()));
                    }
                } else if (i == 48 || i == 62 || i == 123) {
                    System.out.printf("Field (%2s)%n", i);
                    unpackPDS(isoMsg.getString(i));
                    TreeMap<Integer, PDS> tm = new TreeMap<>(pdsFields);
                    Set<Integer> keys = tm.keySet();
                    for (Integer l : keys) {
                        System.out.printf("    %s%n", tm.get(l));
                    }
                } else {
                    System.out.printf("Field (%2s) = %s%n", i, isoMsg.getString(i));
                }
            }
        }
    }

    public void unpackPDS(String s) {
        int curpos = 0;
        String tagName;
        int len;
        String value;
        while (curpos < s.length() - 1) {
            tagName = s.substring(curpos, curpos + 4);
            curpos += 4;
            len = Integer.parseInt(s.substring(curpos, curpos + 3));
            curpos += 3;
            value = s.substring(curpos, curpos + len);
            curpos += len;
            pdsFields.put(Integer.valueOf(tagName), new PDS(tagName, len, value));
        }
    }
}
