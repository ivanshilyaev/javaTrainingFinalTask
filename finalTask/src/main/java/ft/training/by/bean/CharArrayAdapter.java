package ft.training.by.bean;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CharArrayAdapter extends XmlAdapter<String, char[]> {
    @Override
    public char[] unmarshal(String s) throws Exception {
        return s.toCharArray();
    }

    @Override
    public String marshal(char[] chars) throws Exception {
        return new String(chars);
    }
}
