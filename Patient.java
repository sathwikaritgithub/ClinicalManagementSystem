public class Patient {
    private int id;
    private String name;
    private String contactNumber;
    private String medicalHistory;

    public Patient(int id, String name, String contactNumber, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.medicalHistory = medicalHistory;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                '}';
    }
}
