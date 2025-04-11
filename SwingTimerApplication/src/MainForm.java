import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

public class MainForm extends JFrame {

    private JPanel mainPanel;
    private JPanel settingsPanel;

    private JPanel timePanel;
    private JPanel countdownPanel;
    private JRadioButton onTime;
    private JRadioButton countdown;
    private JFormattedTextField onTimeField;
    private JFormattedTextField countdownField;

    private JPanel StartCancelPanel;
    private JButton STARTButton;
    private JButton CANCELButton;

    private JPanel colorPanel;
    private JButton ColorChooser;

    private JPanel speedChooser;
    private JLabel SpeedLabel;
    private JComboBox speed;


    public MainForm() {
        this.setContentPane(mainPanel);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                showOptionDialog();
            }
        });
    }

    private void showOptionDialog() {
        int optionDialog = JOptionPane.showOptionDialog(null, "Choose option", "Option dialog",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Settings", "Close"}, null);

        switch (optionDialog) {
            case JOptionPane.YES_OPTION:
                StartTimer();
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "Application will close");
                System.exit(0);
                break;
            case -1:
                JOptionPane.showMessageDialog(null, "You have to choose an option!");
                break;
        }
    }

    private void StartTimer() {
        setFrameProperties();
        selectOption();
        chooseColor();
        chooseSpeed();
        selectStartOrCancel();
    }


    public void setFrameProperties() {
        JFrame settingsFrame = new JFrame("Settings");
        settingsFrame.setSize(500, 300);
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
        settingsFrame.setContentPane(settingsPanel);
        settingsFrame.setVisible(true);
    }

    public void selectOption() {
        ActionListener osListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("onTime")) {
                    onTimeField.setEnabled(true);
                    countdownField.setEnabled(false);
                }
                if (e.getActionCommand().equals("countdown")) {
                    onTimeField.setEnabled(false);
                    countdownField.setEnabled(true);
                }
            }
        };


        ButtonGroup myChoices = new ButtonGroup();

        onTimeField.setColumns(10);
        onTime.setActionCommand("onTime");
        onTime.addActionListener(osListener);
        myChoices.add(onTime);
        onTime.setSelected(true);
        onTimeField.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                try {
                    MaskFormatter formatter = new MaskFormatter("##:##:##");
                    formatter.setPlaceholderCharacter('_');
                    return formatter;
                } catch (ParseException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
        timePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        timePanel.add(onTime);
        timePanel.add(onTimeField);
        settingsPanel.add(timePanel);

        countdown.setActionCommand("countdown");
        countdown.addActionListener(osListener);
        myChoices.add(countdown);
        NumberFormatter formatter = new NumberFormatter(NumberFormat.getIntegerInstance());
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(60);
        formatter.setAllowsInvalid(false);
        countdownField.setFormatterFactory(new DefaultFormatterFactory(formatter));
        countdownField.setColumns(10);
        countdownField.setEnabled(false);
        countdownPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        countdownPanel.add(countdown);
        countdownPanel.add(countdownField);
        settingsPanel.add(countdownPanel);
    }

    public void chooseColor() {
        ColorChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewWindow();
            }
        });
        colorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        colorPanel.add(ColorChooser);
        settingsPanel.add(colorPanel);
    }

    public void chooseSpeed() {
        speedChooser.setLayout(new FlowLayout(FlowLayout.LEFT));
        speedChooser.add(SpeedLabel);
        speedChooser.add(speed);
        settingsPanel.add(speedChooser);
    }

    public void selectStartOrCancel() {
        StartCancelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        StartCancelPanel.add(STARTButton);
        StartCancelPanel.add(CANCELButton);

        CANCELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        settingsPanel.add(StartCancelPanel);
    }

    private void openNewWindow() {
        JFrame colorFrame = new JFrame("Rainbow!");
        colorFrame.setSize(300, 300);
        Color backgroundColor = JColorChooser.showDialog(null, "Choose background color", Color.pink);
        if (backgroundColor != null) {
            colorFrame.getContentPane().setBackground(backgroundColor);
        }
        colorFrame.setLocationRelativeTo(null);
        colorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
        colorFrame.setVisible(true);
    }


    public static void main(String[] args) {
        MainForm frame = new MainForm();
        frame.setVisible(false);
    }
}

