### Конвертер систем счисления

На вход программе подаётся число в двоичной, восьмеричной, десятичной или шестнадцатиричной системе счисления. Нужно перевести его в любую другую из упомянутых.

[Источник](https://stepik.org/lesson/349851/step/10?discussion=3534771&thread=solutions&unit=333706)

<!-- tabs: start -->
#### **Python**

```python
from tkinter import *
from tkinter.messagebox import showwarning
from tkinter.ttk import Radiobutton

NUMBER_SYSTEMS = [
    ('двоичная', 2, bin),
    ('восьмеричная', 8, oct),
    ('десятичная', 10, int),
    ('шестнадцатиричная', 16, hex)]
FROM_WHICH_SYSTEM = 'Из какой системы счисления переводим?'
TO_WHICH_SYSTEM = 'В какую систему счисления переводим?'


def boh(input):
    number = int(input)
    print(bin(number)[2:])
    print(oct(number)[2:])
    print(hex(number).upper()[2:])


def add_rbuttons(row_, selected):
    r_buttons = [Radiobutton(
        window,
        padding=15,
        text=NUMBER_SYSTEMS[i][0],
        value=i,
        variable=selected)
        for i in range(4)]
    r_buttons[0].grid(row=row_, column=0)
    r_buttons[1].grid(row=row_, column=1)
    r_buttons[2].grid(row=row_, column=2, columnspan=2)
    r_buttons[3].grid(row=row_, column=4, columnspan=2)


def add_big_label(row_, text_):
    label = Label(
        window,
        text=text_
    )
    label.grid(
        row=row_, column=0, columnspan=4, sticky=W, padx=5, pady=5
    )
    return label


def convert():
    from_system = source_selected.get()
    input_str = input_number_field.get()
    to_system = target_selected.get()

    try:
        int_number = int(input_str, NUMBER_SYSTEMS[from_system][1])
    except ValueError:
        showwarning(
            'Предупреждение',
            f"""Ваше число {input_str} не может быть числом в системе
            по основанию {NUMBER_SYSTEMS[from_system][1]}""")
        return

    if to_system == 2:
        result = int_number
    else:
        result = NUMBER_SYSTEMS[to_system][2](int_number)[2:]

    result_field.delete(0, END)
    result_field.insert(0, result)


window = Tk()
window.title('Конвертер систем счисления')
window.geometry('600x300')

# grid lvl 0
choose_source_sistem_label = add_big_label(0, FROM_WHICH_SYSTEM)

# grid lvl 1
source_selected = IntVar(value=3)
add_rbuttons(1, source_selected)

# grid lvl 2
input_label = Label(window, text='Введите число:', padx=5, pady=20)
input_label.grid(row=2, column=0)

input_number_field = Entry(window, validate='focusout', width=10)
input_number_field.grid(row=2, column=1)
input_number_field.focus()

# grid lvl 3
choose_label = add_big_label(3, TO_WHICH_SYSTEM)

# grid lvl 4
target_selected = IntVar(value=2)
add_rbuttons(4, target_selected)

# grid lvl 5
btn_convert = Button(window, text='Перевести', command=convert,)
btn_convert.grid(row=5, column=0, padx=10, pady=5, sticky=W)

result_field = Entry(window, width=10)
result_field.grid(row=5, column=1)

window.mainloop()
```
#### **Test Python**

```python
from boh import boh
import pytest


@pytest.mark.parametrize('input, expected', [
    ('10', '1010\n12\nA\n'),
    ('128', '10000000\n200\n80\n'),
    ('150', '10010110\n226\n96\n'),
    ('18765', '100100101001101\n44515\n494D\n')
])
def test_boh(input, expected, capsys):
    boh(input)
    captured = capsys.readouterr().out
    assert captured == expected

```

#### **Java**

```java
package numerical.BOH;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BOH {
    public static final String FROM_WHICH_SYSTEM = "Из какой системы счисления переводим?";
    public static final String TO_WHICH_SYSTEM = "В какую систему счисления переводим?";
    public static final String ENTER_NUMBER = "Введите число:";
    private static final List<NumberSistem> systems = List.of(
            new NumberSistem(
                    2,
                    "двоичная",
                    Integer::toBinaryString),
            new NumberSistem(
                    8,
                    "восьмеричная",
                    Integer::toOctalString),
            new NumberSistem(
                    10,
                    "десятичная",
                    String::valueOf),
            new NumberSistem(
                    16,
                    "шестнадцатиричная",
                    Integer::toHexString)

    );
    private static final List<Integer> indicesSelectedRBttns = new ArrayList<>(
            List.of(0, 2));
    private static JPanel content;

    public static void boh(String input) {
        int number = Integer.parseInt(input);
        System.out.println(Integer.toBinaryString(number));
        System.out.println(Integer.toOctalString(number));
        System.out.println(Integer.toHexString(number).toUpperCase());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Конвертер систем счисления");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container root = frame.getContentPane();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        frame.getRootPane().setBorder(
                BorderFactory.createEmptyBorder(8, 8, 8, 8));

        content = (JPanel) frame.getContentPane();
        createPanelUI(content);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private static void createPanelUI(Container container) {
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.BOTH;

        // 1 row
        constraints.gridy = 0;
        JLabel chooseSourceSistemLabel = new JLabel(FROM_WHICH_SYSTEM);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        container.add(chooseSourceSistemLabel, constraints);

        // 2 row
        constraints.gridy = 1;
        createRButtons(container, 0, constraints);

        // 3 row
        constraints.gridy = 2;
        constraints.gridx = GridBagConstraints.RELATIVE;
        JLabel inputNumberLabel = new JLabel(ENTER_NUMBER);
        container.add(inputNumberLabel, constraints);

        JTextField inputNumberField = new JTextField();
        container.add(inputNumberField, constraints);

        // 4 row
        constraints.gridy = 3;
        JLabel chooseTargetSistemLabel = new JLabel(TO_WHICH_SYSTEM);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        container.add(chooseTargetSistemLabel, constraints);

        // 5 row
        constraints.gridy = 4;
        createRButtons(container, 1, constraints);

        // 6 row
        constraints.gridy = 5;
        constraints.gridx = GridBagConstraints.RELATIVE;
        JButton convertButton = new JButton("Перевести");
        container.add(convertButton, constraints);

        JTextField resultField = new JTextField();
        container.add(resultField, constraints);

        convertButton.addActionListener(e -> resultField.setText(
                convert(indicesSelectedRBttns.get(0),
                        indicesSelectedRBttns.get(1),
                        inputNumberField.getText())));
    }

    private static String convert(int source, int target, String numberStr) {
        int number;
        int fromBase = systems.get(source).getBase();
        try {
            number = Integer.parseInt(numberStr, fromBase);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    content,
                    String.format("Ваше число %s не является числом%n"
                            + "в системе счисления по основанию %d..",
                            numberStr, fromBase),
                    "Ошибка!",
                    JOptionPane.ERROR_MESSAGE);
            return new String();
        }

        return systems.get(target).convertFromDecimal().apply(number);
    }

    private static void createRButtons(
            Container container,
            int indxGrpBtns,
            GridBagConstraints constraints) {
        constraints.gridwidth = 1;
        List<JRadioButton> rbuttons = IntStream
                .range(0, 4)
                .mapToObj(i -> new JRadioButton(systems.get(i).getTitle()))
                .collect(Collectors.toList());
        ButtonGroup group = new ButtonGroup();
        rbuttons.forEach(group::add);
        for (int j = 0; j < 4; j++) {
            JRadioButton rButton = rbuttons.get(j);
            constraints.gridx = j;
            container.add(rButton, constraints);
            final int k = j;
            rButton.addActionListener(e -> {
                if (rButton.isSelected()) {
                    indicesSelectedRBttns.set(indxGrpBtns, k);
                }
            });
        }

        rbuttons.get(indicesSelectedRBttns.get(indxGrpBtns)).setSelected(true);
    }
}

package numerical.BOH;

import java.util.function.Function;

public class NumberSistem {
    private final int base;
    private final String title;
    private final Function<Integer, String> convertFromDecimal;

    public NumberSistem(int base, String title,
            Function<Integer, String> convertFromDecimal) {
        this.title = title;
        this.base = base;
        this.convertFromDecimal = convertFromDecimal;
    }

    public String getTitle() {
        return title;
    }

    public int getBase() {
        return base;
    }

    public Function<Integer, String> convertFromDecimal() {
        return convertFromDecimal;
    }

}
```
#### **Test Java**

```java
package numerical.BOH;

import static org.junit.Assert.assertEquals;
import static numerical.BOH.BOH.boh;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestBOH {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String sep = System.lineSeparator();

    @BeforeEach
    void setSystemOut() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void testBOH(String input, String expected) {
        boh(input);
        assertEquals(expected, out.toString());
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(
                        "10",
                        String.join(
                                sep, "1010", "12", "A") + sep),
                Arguments.of(
                        "128",
                        String.join(
                                sep, "10000000", "200", "80") + sep),
                Arguments.of(
                        "150",
                        String.join(
                                sep, "10010110", "226", "96") + sep),
                Arguments.of(
                        "18765",
                        String.join(
                                sep, "100100101001101", "44515", "494D") + sep));
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }
}
```

#### **JavaScript**

```javascript

```
#### **Test JavaScript**

```javascript

```
<!-- tabs: end -->

[Ещё по теме:](https://pythonru.com/uroki/obuchenie-python-gui-uroki-po-tkinter?ysclid=lrx4m3d38e853075901#%D0%A3%D0%BA%D0%B0%D0%B7%D0%B0%D0%BD%D0%B8%D0%B5-%D1%82%D0%B8%D0%BF%D0%B0-%D1%84%D0%B0%D0%B9%D0%BB%D0%BE%D0%B2-%D1%80%D0%B0%D1%81%D1%88%D0%B8%D1%80%D0%B5%D0%BD%D0%B8%D0%B5-%D1%84%D0%B8%D0%BB%D1%8C%D1%82%D1%80%D0%B0-%D1%84%D0%B0%D0%B9%D0%BB%D0%BE%D0%B2)

[Ещё по теме:](https://metanit.com/python/tkinter/2.4.php?ysclid=lrx9dww6iq389464315)

[Ещё по теме:](https://www.geeksforgeeks.org/python-gui-tkinter/)

[Ещё по теме:](https://ipsoftware.ru/pdf/Swing_2nd_ed_Ivan_P.pdf)

[Ещё по теме:](https://www.geeksforgeeks.org/java-awt-gridbaglayout-class/)

[Ещё по теме:](https://www.javaguides.net/2019/07/java-swing-radio-button-example.html)
