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