package ee.nets.ipmparserdemo.iso;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PDS {

    private final String tagName;
    private final int len;
    private final String value;

    public String toString() {
        return String.format("Pds (%s) = %s", tagName, value);
    }

}
