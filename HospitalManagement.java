import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HospitalManagement extends JFrame implements ActionListener {

    private JTextField patientIdField, nameField, ageField, diagnosisField;
    private JTextArea displayArea;
    private ArrayList<Patient> patients;

    public HospitalManagement() {
        
        patients = new ArrayList<>();

        
        setTitle("Hospital Management System");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10));

        
        inputPanel.add(new JLabel("Patient ID:"));
        patientIdField = new JTextField();
        inputPanel.add(patientIdField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Diagnosis:"));
        diagnosisField = new JTextField();
        inputPanel.add(diagnosisField);

        
        JButton addButton = new JButton("Add Patient");
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String id = patientIdField.getText();
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String diagnosis = diagnosisField.getText();

        
        Patient newPatient = new Patient(id, name, age, diagnosis);
        patients.add(newPatient);

        
        displayArea.append("Patient ID: " + id + "\n");
        displayArea.append("Name: " + name + "\n");
        displayArea.append("Age: " + age + "\n");
        displayArea.append("Diagnosis: " + diagnosis + "\n");
        displayArea.append("--------------------------------------------------\n");

        
        patientIdField.setText("");
        nameField.setText("");
        ageField.setText("");
        diagnosisField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HospitalManagement::new);
    }
}


class Patient {
    private String id;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(String id, String name, int age, String diagnosis) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    
}
