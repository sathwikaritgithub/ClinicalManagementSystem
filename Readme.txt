Instructions for Interactive Console
Add Patient:

Enter patient details as prompted to add a new patient to the system.
Remove Patient:

Enter the patient ID to remove a patient from the system.
Update Patient:

Enter the patient ID and updated details to update a patient's information.
Add Doctor:

Enter doctor details as prompted to add a new doctor to the system.
Remove Doctor:

Enter the doctor ID to remove a doctor from the system.
Update Doctor:

Enter the doctor ID and updated details to update a doctor's information.
Schedule Appointment:

Enter the patient ID, doctor ID, and appointment date and time (in the format yyyy-MM-ddTHH:mm) to schedule a new appointment. The system checks for conflicts before scheduling.
Exit:

Choose this option to exit the system.
Exception Handling
Basic input validation is done within methods to prevent scheduling conflicts.
Error messages are printed to the console for invalid operations, such as scheduling conflicts.
The interactive console provides prompts and handles invalid inputs by guiding the user back to the menu.
Brief Report on Application Design
The Clinic Management System uses Object-Oriented Programming principles to encapsulate
 the attributes and behaviors related to patients, doctors, and appointments. 
 The ClinicManagementSystem class acts as the main controller, managing collections of patients, doctors, and appointments using Java Collections Framework (HashMap and ArrayList). 
 Exception handling ensures smooth user interactions and prevents conflicts in scheduling appointments.
  The interactive console allows administrators to perform operations interactively, promoting modularity, reusability, and maintainability of the code.