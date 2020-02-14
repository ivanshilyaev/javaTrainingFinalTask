package informationhandlinglight.training.by.service;

import informationhandlinglight.training.by.bean.TextComponent;
import informationhandlinglight.training.by.bean.TextComposite;

import java.util.Collections;
import java.util.Comparator;

public class SortingCommand {
    public void sortParagraphsByNumberOfSentences(TextComponent component) {
        /*
         * 1. собрать текст на уровне абзацев
         * 2. отсортировать абзацы по количеству предлож
         * 3. распарсить текст
         */
        Collections.sort(((TextComposite) component).getComponents(),
                new Comparator<TextComponent>() {
                    @Override
                    public int compare(TextComponent o1, TextComponent o2) {
                        return ((TextComposite) o1).getComponentsSize() -
                                ((TextComposite) o2).getComponentsSize();
                    }
                });
    }

    public void sortWordsInSentenceByLength(TextComponent component) {
        for (int i = 0; i < ((TextComposite) component).getComponentsSize(); ++i) {
            TextComponent temp = component.getChild(i);
            for (int j = 0; j < ((TextComposite) temp).getComponentsSize(); ++j) {
                Collections.sort(((TextComposite) temp.getChild(j)).getComponents(),
                        new Comparator<TextComponent>() {
                            @Override
                            public int compare(TextComponent o1, TextComponent o2) {
                                return o1.getChild(0).restore().toString().length() -
                                        o2.getChild(0).restore().toString().length();
                            }
                        });
            }
        }
    }

    public void sortLexemesByNumberOfGivenCharacter(TextComponent component, final char symbol) {
        Collections.sort(((TextComposite) component).getComponents(),
                new Comparator<TextComponent>() {
                    @Override
                    public int compare(TextComponent o1, TextComponent o2) {
                        return (int) (o1.restore().toString().chars().filter(ch -> ch == symbol).count() -
                                o2.restore().toString().chars().filter(ch -> ch == symbol).count());
                    }
                });
    }
}
