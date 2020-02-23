package informationhandlinglight.training.by;

import informationhandlinglight.training.by.bean.TextComponent;
import informationhandlinglight.training.by.service.ReadCommand;
import informationhandlinglight.training.by.service.SortingCommand;
import informationhandlinglight.training.by.service.exception.ServiceException;
import informationhandlinglight.training.by.service.parser.TextParser;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void restore() {
        ReadCommand readCommand = new ReadCommand();
        String expected = null;
        try {
            expected = readCommand.exec();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        TextParser textParser = new TextParser(null);
        TextComponent component = textParser.parse(expected);
//        SortingCommand sortingCommand = new SortingCommand();
//        sortingCommand.sortParagraphsByNumberOfSentences(component);
        String actual = component.restore().append("\r\n").toString();
        System.out.println(expected);

        Assert.assertEquals(expected, actual);
    }
}
