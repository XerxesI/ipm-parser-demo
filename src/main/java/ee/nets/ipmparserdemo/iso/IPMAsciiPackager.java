package ee.nets.ipmparserdemo.iso;

import org.jpos.iso.*;

public class IPMAsciiPackager extends ISOBasePackager {

    protected ISOFieldPackager[] fld = {
            /*000*/ new IFA_NUMERIC(4, "MESSAGE TYPE INDICATOR"),
            /*001*/ new IFA_BITMAP(16, "BIT MAP"),
            /*002*/ new IFA_LLNUM(19, "PAN - PRIMARY ACCOUNT NUMBER"),
            /*003*/ new IFA_NUMERIC(6, "PROCESSING CODE"),
            /*004*/ new IFA_NUMERIC(12, "AMOUNT, TRANSACTION"),
            /*005*/ new IFA_NUMERIC(12, "AMOUNT, SETTLEMENT"),
            /*006*/ new IFA_NUMERIC(12, "AMOUNT, CARDHOLDER BILLING"),
            /*007*/ new IFA_NUMERIC(10, "TRANSMISSION DATE AND TIME"),
            /*008*/ new IFA_NUMERIC(8, "AMOUNT, CARDHOLDER BILLING FEE"),
            /*009*/ new IFA_NUMERIC(8, "CONVERSION RATE, SETTLEMENT"),
            /*010*/ new IFA_NUMERIC(8, "CONVERSION RATE, CARDHOLDER BILLING"),
            /*011*/ new IFA_NUMERIC(6, "SYSTEM TRACE AUDIT NUMBER"),
            /*012*/ new IFA_NUMERIC(12, "TIME, LOCAL TRANSACTION"),
            /*013*/ new IFA_NUMERIC(4, "DATE, LOCAL TRANSACTION"),
            /*014*/ new IFA_NUMERIC(4, "DATE, EXPIRATION"),
            /*015*/ new IFA_NUMERIC(6, "DATE, SETTLEMENT"),
            /*016*/ new IFA_NUMERIC(4, "DATE, CONVERSION"),
            /*017*/ new IFA_NUMERIC(4, "DATE, CAPTURE"),
            /*018*/ new IFA_NUMERIC(4, "MERCHANTS TYPE"),
            /*019*/ new IFA_NUMERIC(3, "ACQUIRING INSTITUTION COUNTRY CODE"),
            /*020*/ new IFA_NUMERIC(3, "PAN EXTENDED COUNTRY CODE"),
            /*021*/ new IFA_NUMERIC(3, "FORWARDING INSTITUTION COUNTRY CODE"),
            /*022*/ new IF_CHAR(12, "POINT OF SERVICE DATA CODE"),
            /*023*/ new IFA_NUMERIC(3, "CARD SEQUENCE NUMBER"),
            /*024*/ new IFA_NUMERIC(3, "FUNCTION CODE"),
            /*025*/ new IFA_NUMERIC(4, "MESSAGE REASON CODE"),
            /*026*/ new IFA_NUMERIC(4, "MCC"),
            /*027*/ new IFA_NUMERIC(1, "AUTHORIZATION IDENTIFICATION RESP LEN"),
            /*028*/ new IFA_NUMERIC(6, "DATE, RECONCILIATION"),
            /*029*/ new IFA_NUMERIC(3, "RECONCILIATION INDICATOR"),
            /*030*/ new IFA_NUMERIC(24, "AMOUNTS, ORIGINAL"),
            /*031*/ new IFA_LLCHAR(99, "ACQUIRER REFERENCE DATA"),
            /*032*/ new IFA_LLNUM(11, "ACQUIRING INSTITUTION IDENT CODE"),
            /*033*/ new IFA_LLNUM(11, "FORWARDING INSTITUTION IDENT CODE"),
            /*034*/ new IFA_LLCHAR(28, "PAN EXTENDED"),
            /*035*/ new IFA_LLNUM(37, "TRACK 2 DATA"),
            /*036*/ new IFA_LLLCHAR(104, "TRACK 3 DATA"),
            /*037*/ new IF_CHAR(12, "RETRIEVAL REFERENCE NUMBER"),
            /*038*/ new IF_CHAR(6, "AUTHORIZATION IDENTIFICATION RESPONSE"),
            /*039*/ new IFA_NUMERIC(3, "RESPONSE CODE"),
            /*040*/ new IFA_NUMERIC(3, "SERVICE RESTRICTION CODE"),
            /*041*/ new IF_CHAR(8, "CARD ACCEPTOR TERMINAL IDENTIFICACION"),
            /*042*/ new IF_CHAR(15, "CARD ACCEPTOR IDENTIFICATION CODE"),
            /*043*/ new IFA_LLCHAR(99, "CARD ACCEPTOR NAME/LOCATION"),
            /*044*/ new IFA_LLCHAR(99, "ADITIONAL RESPONSE DATA"),
            /*045*/ new IFA_LLCHAR(76, "TRACK 1 DATA"),
            /*046*/ new IFA_LLLCHAR(999, "ADITIONAL DATA - ISO"),
            /*047*/ new IFA_LLLCHAR(999, "ADITIONAL DATA - NATIONAL"),
            /*048*/ new IFA_LLLCHAR(999, "ADITIONAL DATA - PRIVATE"),
            /*049*/ new IF_CHAR(3, "CURRENCY CODE, TRANSACTION"),
            /*050*/ new IF_CHAR(3, "CURRENCY CODE, SETTLEMENT"),
            /*051*/ new IF_CHAR(3, "CURRENCY CODE, CARDHOLDER BILLING"),
            /*052*/ new IFA_BINARY(8, "PIN DATA"),
            /*053*/ new IFA_LLBINARY(16, "SECURITY RELATED CONTROL INFORMATION"),
            /*054*/ new IFA_LLLCHAR(120, "ADDITIONAL AMOUNTS"),
            /*055*/ new IFA_LLLABINARY(999, "CHIP DATA"),
            /*056*/ new IFA_LLNUM(35, "ORIGINAL DATA"),
            /*057*/ new IFA_NUMERIC(3, "AUTHORIZATION LIFE CYCLE CODE"),
            /*058*/ new IFA_LLNUM(11, "AUTHORIZATION AGENT ID CODE"),
            /*059*/ new IFA_LLLCHAR(999, "TRANSPORT DATA"),
            /*060*/ new IFA_LLLCHAR(999, "RESERVED NATIONAL"),
            /*061*/ new IFA_LLLCHAR(999, "RESERVED NATIONAL"),
            /*062*/ new IFA_LLLCHAR(999, "RESERVED PRIVATE"),
            /*063*/ new IFA_LLLCHAR(999, "RESERVED PRIVATE"),
            /*064*/ new IFA_BINARY(8, "MESSAGE AUTHENTICATION CODE FIELD"),
            /*065*/ new IFA_BINARY(8, "BITMAP, EXTENDED"),
            /*066*/ new IFA_LLLCHAR(204, "AMOUNTS, ORIGINAL FEES"),
            /*067*/ new IFA_NUMERIC(2, "EXTENDED PAYMENT CODE"),
            /*068*/ new IFA_NUMERIC(3, "RECEIVING INSTITUTION COUNTRY CODE"),
            /*069*/ new IFA_NUMERIC(3, "SETTLEMENT INSTITUTION COUNTRY CODE"),
            /*070*/ new IFA_NUMERIC(3, "NETWORK MANAGEMENT INFORMATION CODE"),
            /*071*/ new IFA_NUMERIC(8, "MESSAGE NUMBER"),
            /*072*/ new IFA_LLLCHAR(999, "DATA RECORD"),
            /*073*/ new IFA_NUMERIC(6, "DATE ACTION"),
            /*074*/ new IFA_NUMERIC(10, "CREDITS NUMBER"),
            /*075*/ new IFA_NUMERIC(10, "CREDITS REVERSAL NUMBER"),
            /*076*/ new IFA_NUMERIC(10, "DEBITS NUMBER"),
            /*077*/ new IFA_NUMERIC(10, "DEBITS REVERSAL NUMBER"),
            /*078*/ new IFA_NUMERIC(10, "TRANSFER NUMBER"),
            /*079*/ new IFA_NUMERIC(10, "TRANSFER REVERSAL NUMBER"),
            /*080*/ new IFA_NUMERIC(10, "INQUIRIES NUMBER"),
            /*081*/ new IFA_NUMERIC(10, "AUTHORIZATION NUMBER"),
            /*082*/ new IFA_NUMERIC(10, "INQUIRIES, REVERSAL NUMBER"),
            /*083*/ new IFA_NUMERIC(10, "PAYMENTS NUMBER"),
            /*084*/ new IFA_NUMERIC(10, "PAYMENTS, REVERSAL NUMBER"),
            /*085*/ new IFA_NUMERIC(10, "FEE COLLECTIONS, NUMBER"),
            /*086*/ new IFA_NUMERIC(16, "CREDITS, AMOUNT"),
            /*087*/ new IFA_NUMERIC(16, "CREDITS, REVERSAL AMOUNT"),
            /*088*/ new IFA_NUMERIC(16, "DEBITS, AMOUNT"),
            /*089*/ new IFA_NUMERIC(16, "DEBITS, REVERSAL AMOUNT"),
            /*090*/ new IFA_NUMERIC(10, "AUITHORIZATIONS, REVERSAL NUMBER"),
            /*091*/ new IFA_NUMERIC(3, "TRANSACTION DEST. COUNTRY CODE"),
            /*092*/ new IFA_NUMERIC(3, "TRANSACTION ORIG. COUNTRY CODE"),
            /*093*/ new IFA_LLCHAR(11, "TRANSACTION DEST. ID CODE"),
            /*094*/ new IFA_LLCHAR(11, "TRANSACTION ORIG. ID CODE"),
            /*095*/ new IFA_LLCHAR(99, "CARD ISSUER REFERENCE DATA"),
            /*096*/ new IFA_LLLABINARY(999, "MESSAGE SECURITY CODE"),
            /*097*/ new IF_CHAR(17, "AMOUNT, NET SETTLEMENT"),
            /*098*/ new IF_CHAR(25, "PAYEE"),
            /*099*/ new IFA_LLNUM(11, "SETTLEMENT INSTITUTION IDENT CODE"),
            /*100*/ new IFA_LLNUM(11, "RECEIVING INSTITUTION IDENT CODE"),
            /*101*/ new IFA_LLCHAR(17, "FILE NAME"),
            /*102*/ new IFA_LLCHAR(28, "ACCOUNT IDENTIFICATION 1"),
            /*103*/ new IFA_LLCHAR(28, "ACCOUNT IDENTIFICATION 2"),
            /*104*/ new IFA_LLLCHAR(100, "TRANSACTION DESCRIPTION"),
            /*105*/ new IFA_NUMERIC(16, "CREDITS, CHARGEBACK AMOUNT"),
            /*106*/ new IFA_NUMERIC(16, "DEBITS, CHARGEBACK AMOUNT"),
            /*107*/ new IFA_NUMERIC(10, "CREDITS, CHARGEBACK NUMBER"),
            /*108*/ new IFA_NUMERIC(10, "DEBITS, CHARGEBACK NUMBER"),
            /*109*/ new IFA_LLCHAR(84, "CREDITS, FEE AMOUNTS"),
            /*110*/ new IFA_LLCHAR(84, "DEBITS, FEE AMOUNTS"),
            /*111*/ new IFA_LLLCHAR(999, "RESERVED ISO USE"),
            /*112*/ new IFA_LLLCHAR(999, "RESERVED NATIONAL USE"),
            /*113*/ new IFA_LLLCHAR(999, "RESERVED NATIONAL USE"),
            /*114*/ new IFA_LLLCHAR(999, "RESERVED NATIONAL USE"),
            /*115*/ new IFA_LLLCHAR(999, "RESERVED NATIONAL USE"),
            /*116*/ new IFA_LLLCHAR(999, "RESERVED NATIONAL USE"),
            /*117*/ new IFA_LLLCHAR(999, "RESERVED NATIONAL USE"),
            /*118*/ new IFA_LLLCHAR(999, "RESERVED NATIONAL USE"),
            /*119*/ new IFA_LLLCHAR(999, "RESERVED NATIONAL USE"),
            /*120*/ new IFA_LLLCHAR(999, "RESERVED PRIVATE USE"),
            /*121*/ new IFA_LLLCHAR(999, "RESERVED PRIVATE USE"),
            /*122*/ new IFA_LLLCHAR(999, "RESERVED PRIVATE USE"),
            /*123*/ new IFA_LLLCHAR(999, "RESERVED PRIVATE USE"),
            /*124*/ new IFA_LLLCHAR(999, "RESERVED PRIVATE USE"),
            /*125*/ new IFA_LLLCHAR(999, "RESERVED PRIVATE USE"),
            /*126*/ new IFA_LLLCHAR(999, "RESERVED PRIVATE USE"),
            /*127*/ new IFA_LLLCHAR(999, "RESERVED PRIVATE USE"),
            /*128*/ new IFA_BINARY(8, "MESSAGE AUTHENTICATION CODE FIELD"),
    };

    public IPMAsciiPackager() {
        super();
        setFieldPackager(this.fld);
    }
}
