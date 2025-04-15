import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Timer;


public class MainForm extends JFrame {

    // UI Components
    private JPanel mainPanel, timerOptionsPanel, onTimePanel, countdownPanel, controlButtonsPanel, colorPanel, speedChooserPanel;
    private JRadioButton onTimeRadioButton, countdownRadioButton;
    private JFormattedTextField onTimeField, countdownField;
    private JButton startButton, stopButton, colorChooser;
    private JLabel speedLabel;
    private JComboBox<Integer> blinkSpeedComboBox;

    // State
    private Color selectedColor = Color.WHITE;
    private Timer timer;
    private JFrame blinkingFrame;
    private boolean isBlinking = false;

    // Constants
    private static final String TITLE_APPLICATION = "Timer Application";
    private static final String TITLE_BLINKING_FRAME = "Blinking Window";
    private static final Dimension DEFAULT_SIZE = new Dimension(300, 300);
    private static final String[] DIALOG_OPTIONS = {"Settings", "Close"};
    private static final String TIME_MASK = "##:##:##";


    public MainForm() {
        this.setContentPane(mainPanel);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                showOptionDialog();
            }
        });
    }
    /**
     * Shows initial dialog with "Settings" and "Close" options.
     */
    private void showOptionDialog() {
        int choice = JOptionPane.showOptionDialog(null, "Choose option", "Option dialog",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, DIALOG_OPTIONS, null);
        if (choice == JOptionPane.YES_OPTION) {
            initializeComponents();
        }
    }

    /**
     * Shows initial dialog with "Settings" and "Close" options.
     */
    private void initializeComponents() {
        showSettingsWindow();
        initializeTimerOptions();
        initializeColorChooser();
        initializeSpeedChooser();
        initializeControlButtons();
    }

    /**
     * Configures main window settings.
     */
    public void showSettingsWindow() {
        this.setTitle(TITLE_APPLICATION);
        this.setSize(DEFAULT_SIZE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setVisible(true);
    }

    /**
     * Initializes timer option radio buttons and input fields.
     */
    public void initializeTimerOptions() {

        ButtonGroup timerOptions = new ButtonGroup();
        timerOptions.add(onTimeRadioButton);
        timerOptions.add(countdownRadioButton);

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

        onTimeRadioButton.setActionCommand("onTime");
        onTimeRadioButton.addActionListener(osListener);
        onTimeRadioButton.setSelected(true);

        countdownRadioButton.setActionCommand("countdown");
        countdownRadioButton.addActionListener(osListener);

        layoutTimerPanels();
        configureTimeFormatters();

    }

    /**
     * Sets layout for "on time" and "countdown" panels.
     */
    private void layoutTimerPanels() {
        onTimePanel.setLayout(new GridBagLayout());
        countdownPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //on-time option
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 15, 5, 15);
        onTimePanel.add(onTimeRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        onTimePanel.add(onTimeField, gbc);

        // countdown option
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 15, 5, 15);
        countdownPanel.add(countdownRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        countdownPanel.add(countdownField, gbc);

        timerOptionsPanel.setLayout(new BoxLayout(timerOptionsPanel, BoxLayout.Y_AXIS));
        timerOptionsPanel.add(onTimePanel);
        timerOptionsPanel.add(countdownPanel);
        this.add(timerOptionsPanel);
    }

    /**
     * Configures input format for on-time and countdown fields.
     */
    private void configureTimeFormatters() {
        try {
            MaskFormatter timeFormatter = new MaskFormatter(TIME_MASK);
            timeFormatter.setPlaceholderCharacter('_');
            onTimeField.setFormatterFactory(new DefaultFormatterFactory(timeFormatter));

            NumberFormatter countdownFormatter = new NumberFormatter(NumberFormat.getIntegerInstance());
            countdownFormatter.setValueClass(Integer.class);
            countdownFormatter.setMinimum(1);
            countdownFormatter.setMaximum(60);
            countdownFormatter.setAllowsInvalid(false);
            countdownField.setFormatterFactory(new DefaultFormatterFactory(countdownFormatter));
            countdownField.setEnabled(false);
        } catch (ParseException e) {
            handleFormatException(e);
        }
    }

    private void handleFormatException(Exception e) {
        JOptionPane.showMessageDialog(this, "Error configuring time format: " + e.getMessage(),
                "Format Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Initializes color picker button.
     */
    public void initializeColorChooser() {
        colorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        colorChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Choose background color", selectedColor);
                if (color != null && !color.equals(Color.WHITE)) {
                    selectedColor = color;
                    colorPanel.setForeground(color);
                }
            }
        });
        colorPanel.add(colorChooser);
        this.add(colorPanel);
    }

    /**
     * Initializes blink speed dropdown.
     */
    public void initializeSpeedChooser() {
        speedChooserPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        speedChooserPanel.add(speedLabel);
        speedChooserPanel.add(blinkSpeedComboBox);
        this.add(speedChooserPanel);
    }

    /**
     * Initializes Start and Stop buttons.
     */
    public void initializeControlButtons() {
        layoutControlButtons();
        startButton.addActionListener(e -> {
            disableControls();
            startTimer();
        });

        stopButton.addActionListener(e -> {
            stopTimer();
            if (blinkingFrame != null) blinkingFrame.dispose();
            enableControls();
        });
        stopButton.setEnabled(false);
    }

    private void layoutControlButtons() {
        controlButtonsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Start Button
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 15, 5, 15);
        controlButtonsPanel.add(startButton, gbc);

        // Stop button
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        controlButtonsPanel.add(stopButton, gbc);

        this.add(controlButtonsPanel);
    }

    /**
     * Disables input controls after timer starts.
     */
    private void disableControls() {
        onTimeRadioButton.setEnabled(false);
        countdownRadioButton.setEnabled(false);
        onTimeField.setEnabled(false);
        countdownField.setEnabled(false);
        colorChooser.setEnabled(false);
        blinkSpeedComboBox.setEnabled(false);
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    /**
     * Enables controls after timer or blinking stops.
     */
    private void enableControls() {
        onTimeRadioButton.setEnabled(true);
        countdownRadioButton.setEnabled(true);
        onTimeField.setEnabled(onTimeRadioButton.isSelected());
        countdownField.setEnabled(countdownRadioButton.isSelected());
        colorChooser.setEnabled(true);
        blinkSpeedComboBox.setEnabled(true);
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    /**
     * Starts the countdown or on-time timer.
     */
    private void startTimer() {
        if (timer != null) timer.cancel();
        timer = new Timer();

        long delay = 0;
        if (selectedColor == null || selectedColor == Color.white) {
            JOptionPane.showMessageDialog(null, "Please choose a color before starting! (Not white)");
            enableControls();
            return;
        }
        if (countdownRadioButton.isSelected()) {
            try {
                delay = ((Number) countdownField.getValue()).longValue() * 1000;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number of seconds!");
                enableControls();
                return;
            }
        } else {
            try {
                LocalTime setTime = LocalTime.parse(onTimeField.getText(), DateTimeFormatter.ofPattern("HH:mm:ss"));
                LocalTime now = LocalTime.now();
                long setTimeSeconds = setTime.toSecondOfDay();
                long nowSeconds = now.toSecondOfDay();
                if (setTimeSeconds <= nowSeconds) {
                    delay = (24 * 60 * 60 - nowSeconds + setTimeSeconds) * 1000;
                } else {
                    delay = (setTimeSeconds - nowSeconds) * 1000;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Incorrect time format!");
                enableControls();
                return;
            }
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> startBlinkingWindow());
            }
        }, delay);
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
        isBlinking = false;
    }

    /**
     * Starts blinking frame and handles color toggling.
     */
    private void startBlinkingWindow() {
        blinkingFrame = new JFrame(TITLE_BLINKING_FRAME);
        blinkingFrame.setSize(DEFAULT_SIZE);
        blinkingFrame.setLocation(
                this.getX() + this.getWidth() + 10, this.getY()
        );

        blinkingFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isBlinking = false;
                enableControls();
            }
        });

        blinkingFrame.setVisible(true);

        Object selectedInterval = blinkSpeedComboBox.getSelectedItem();
        int blinkingInterval = Integer.parseInt(selectedInterval.toString()) * 1000;

        isBlinking = true;

        Timer blinkTimer = new Timer();
        blinkTimer.scheduleAtFixedRate(new TimerTask() {
            boolean toggle = true;

            @Override
            public void run() {
                if (!isBlinking) {
                    blinkTimer.cancel();
                    return;
                }
                SwingUtilities.invokeLater(() -> {
                    blinkingFrame.getContentPane().setBackground(toggle ? selectedColor : Color.WHITE);
                    toggle = !toggle;
                });
            }
        }, 0, blinkingInterval);
    }

    public static void main(String[] args) {
         new MainForm();
    }
}


