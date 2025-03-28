
import com.boostphysioclinic.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class BoostPhysioClinicalTest {
    private BoostPhysioClinic clinic;
    private Physiotherapist physiotherapist;
    private Patient patient;
    private Treatment treatment;

    @BeforeEach
    public void setUp() {
        clinic = new BoostPhysioClinic();
        physiotherapist = new Physiotherapist("Dr. Test", "Test Address", "555-TEST");
        patient = new Patient("Test Patient", "Patient Address", "555-PATIENT");
        treatment = new Treatment("Test Treatment", "Test Expertise",
                LocalDateTime.now(), physiotherapist);

        physiotherapist.addTreatment(treatment);
        clinic.addPhysiotherapist(physiotherapist);
        clinic.addPatient(patient);
    }

    @Test
    public void testBookAppointment() {
        Appointment appointment = clinic.bookAppointment(patient, treatment);

        assertNotNull(appointment);
        assertEquals(treatment, appointment.getTreatment());
        assertEquals(patient, appointment.getPatient());
        assertEquals(AppointmentStatus.BOOKED, appointment.getStatus());
    }

    @Test
    public void testCancelAppointment() {
        Appointment appointment = clinic.bookAppointment(patient, treatment);
        clinic.cancelAppointment(appointment);

        assertEquals(AppointmentStatus.CANCELLED, appointment.getStatus());
    }

    @Test
    public void testCheckInAppointment() {
        Appointment appointment = clinic.bookAppointment(patient, treatment);
        clinic.checkInAppointment(appointment);

        assertEquals(AppointmentStatus.ATTENDED, appointment.getStatus());
    }

    @Test
    public void testFindTreatmentsByExpertise() {
        assertEquals(1, clinic.findTreatmentsByExpertise("Test Expertise").size());
    }

    @Test
    public void testFindTreatmentsByPhysiotherapistName() {
        assertEquals(1, clinic.findTreatmentsByPhysiotherapistName("Dr. Test").size());
    }
}
