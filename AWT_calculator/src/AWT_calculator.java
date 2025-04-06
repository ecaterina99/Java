import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AWT_calculator extends Frame {

    private TextField firstNumber, secondNumber, result;
    private Choice operatorChoice;
    private ArrayList<Operator> operators;

    public AWT_calculator() {
        initializeUI();
        setupComponents();
        centerWindow();
        setVisible(true);
    }

    private void initializeUI() {
        setTitle("Calculator");
        setBackground(Color.getHSBColor(0.75f, 0.3f, 0.9f));
        setSize(500, 300);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
    }

    private void setupComponents() {
        GridBagConstraints gbc = new GridBagConstraints();

        initializeOperators();

        addFirstNumberComponents(gbc);

        addOperatorComponents(gbc);

        addSecondNumberComponents(gbc);

        addCalculateButton(gbc);

        addResultComponents(gbc);
    }

    private void initializeOperators() {
        operators = new ArrayList<>();
        operators.add(new Operator(1, '+'));
        operators.add(new Operator(2, '-'));
        operators.add(new Operator(3, '*'));
        operators.add(new Operator(4, '/'));
    }

    private void addFirstNumberComponents(GridBagConstraints gbc) {
        Label label1 = new Label("Enter first number:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 5, 5);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        add(label1, gbc);

        firstNumber = new TextField(10);
        firstNumber.setBackground(Color.getHSBColor(25, 4, 50));
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        add(firstNumber, gbc);
    }

    private void addOperatorComponents(GridBagConstraints gbc) {
        Label label2 = new Label("Choose operator:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        add(label2, gbc);

        operatorChoice = new Choice();
        for (Operator operator : operators) {
            operatorChoice.add(String.valueOf(operator.getOperator()));
        }

        operatorChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Choice c = (Choice) e.getSource();
                Operator selectedOperator = operators.get(c.getSelectedIndex());
                System.out.println("Selected operator id: " + selectedOperator.getId());
            }
        });
        operatorChoice.setBackground(Color.getHSBColor(25, 4, 50));

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(operatorChoice, gbc);
    }

    private void addSecondNumberComponents(GridBagConstraints gbc) {
        Label label3 = new Label("Enter second number:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(label3, gbc);

        secondNumber = new TextField(10);
        secondNumber.setBackground(Color.getHSBColor(25, 4, 50));
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(secondNumber, gbc);
    }


    private void addCalculateButton(GridBagConstraints gbc) {
        Button calculateButton = new Button("Calculate");
        calculateButton.setBackground(Color.getHSBColor(25, 4, 6));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(calculateButton, gbc);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });
    }

    private void addResultComponents(GridBagConstraints gbc) {
        Label label4 = new Label("The result is: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0;
        add(label4, gbc);

        result = new TextField(10);
        result.setEditable(false);
        result.setBackground(Color.getHSBColor(25, 4, 50));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(result, gbc);
    }

    private void centerWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;
        setLocation(x, y);
    }

    private void calculateResult() {
        try {
            double x = Double.parseDouble(firstNumber.getText());
            double y = Double.parseDouble(secondNumber.getText());
            char operator = operatorChoice.getSelectedItem().charAt(0);
            double result = calculate(x, y, operator);
            System.out.println("Result: " + result);
            this.result.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            result.setText("Error");
            System.out.println("Invalid input!");
        }
    }

    private double calculate(double x, double y, char operator) {
        return switch (operator) {
            case '+' -> x + y;
            case '-' -> x - y;
            case '*' -> x * y;
            case '/' -> (y != 0) ? x / y : 0;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        new AWT_calculator();
    }
}


class Operator {
    public int id;
    public char operator;

    public Operator(int id, char operator) {
        this.id = id;
        this.operator = operator;
    }

    public int getId() {
        return id;
    }

    public char getOperator() {
        return operator;
    }
}


