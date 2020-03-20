package ft.training.by.bean;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CharAdapter extends XmlAdapter<String, Character> {

    @Override
    public Character unmarshal(String s) throws Exception {
        if (s.length() > 0) {
            return s.charAt(0);
        } else {
            return ' ';
        }
    }

    @Override
    public String marshal(Character c) throws Exception {
        return new String(new char[]{c});
    }
}
