import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParkingApp extends JFrame implements ActionListener {

    private JPanel inputPanel, radioPanel, buttonPanel;
    private JLabel lblPlate, lblType, lblHours, lblExtra, lblResult;
    private JTextField txtPlate, txtHours;
    private JRadioButton rbMotor, rbCar;
    private ButtonGroup bgType;
    private JCheckBox chkLostTicket;
    private JButton btnCalculate, btnReset;

    public ParkingApp() {
        setTitle("Parking Fee Calculator");
        setSize(350, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        lblPlate = new JLabel("  License Plate:");
        txtPlate = new JTextField();
        inputPanel.add(lblPlate);
        inputPanel.add(txtPlate);

        lblType = new JLabel("  Vehicle Type:");
        radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rbMotor = new JRadioButton("Motorcycle", true);
        rbCar = new JRadioButton("Car");
        bgType = new ButtonGroup();
        bgType.add(rbMotor);
        bgType.add(rbCar);
        radioPanel.add(rbMotor);
        radioPanel.add(rbCar);
        inputPanel.add(lblType);
        inputPanel.add(radioPanel);

        lblHours = new JLabel("  Hours Parked:");
        txtHours = new JTextField();
        inputPanel.add(lblHours);
        inputPanel.add(txtHours);

        lblExtra = new JLabel("  Penalty:");
        chkLostTicket = new JCheckBox("Lost Ticket (+20k)");
        inputPanel.add(lblExtra);
        inputPanel.add(chkLostTicket);

        buttonPanel = new JPanel(new FlowLayout());
        btnCalculate = new JButton("Calculate");
        btnReset = new JButton("Reset");
        buttonPanel.add(btnCalculate);
        buttonPanel.add(btnReset);

        lblResult = new JLabel("Total Fee: Rp 0", SwingConstants.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(lblResult, BorderLayout.SOUTH);

        btnCalculate.addActionListener(this);
        btnReset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculate) {
            String plate = txtPlate.getText();
            int hours = Integer.parseInt(txtHours.getText());
            int rate = rbMotor.isSelected() ? 2000 : 5000;
            int total = hours * rate;

            if (chkLostTicket.isSelected()) {
                total += 20000;
            }

            lblResult.setText("Plate " + plate + " - Total Fee: Rp " + total);
        } else if (e.getSource() == btnReset) {
            txtPlate.setText("");
            txtHours.setText("");
            rbMotor.setSelected(true);
            chkLostTicket.setSelected(false);
            lblResult.setText("Total Fee: Rp 0");
        }
    }

    public static void main(String[] args) {
        new ParkingApp().setVisible(true);
    }
}