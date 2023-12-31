package main.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "guests")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({ "password", "creditCard" })
public class Guest {
	@Id
	@GeneratedValue
	private UUID guestId;
//	@Enumerated(EnumType.STRING)
//	private Gender gender;
	private String firstName;
	private String lastName;
//	private String language;
//	private LocalDate dateOfBirth;
//	private String countryOfBirth;
//	private String cityOfBirth;
//	private String countryOfResidence;
//	private String cityOfResidence;
	private String citizenship;
//	private String documentType;
//	private String documentNumber;
	private String email;
//	private String password;
	private String phone;
	private String note;
//	private String foodIntolerance;
//	@Convert(converter = CreditCardConverter.class)
//	private String creditCard;
//	private String reasonOfTheTrip;
//	@OneToMany(mappedBy = "guest", cascade = CascadeType.REMOVE)
//	@JsonManagedReference
//	@JsonIgnore
//	private List<Reservation> reservations = new ArrayList<>();

	public Guest(String firstName, String lastName, String citizenship, String email, String phone, String note) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.citizenship = citizenship;
		this.email = email;
		this.phone = phone;
		this.note = note;
	}

//	public Guest(Gender gender, String firstName, String lastName, String language, LocalDate dateOfBirth,
//			String countryOfBirth, String cityOfBirth, String countryOfResidence, String cityOfResidence,
//			String citizenship, String documentType, String documentNumber, String email, String password, String phone,
//			String note, String foodIntolerance, String creditCard, String reasonOfTheTrip,
//			List<Reservation> reservations) {
//		this.gender = gender;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.language = language;
//		this.dateOfBirth = dateOfBirth;
//		this.countryOfBirth = countryOfBirth;
//		this.cityOfBirth = cityOfBirth;
//		this.countryOfResidence = countryOfResidence;
//		this.cityOfResidence = cityOfResidence;
//		this.citizenship = citizenship;
//		this.documentType = documentType;
//		this.documentNumber = documentNumber;
//		this.email = email;
//		this.password = password;
//		this.phone = phone;
//		this.note = note;
//		this.foodIntolerance = foodIntolerance;
//		this.creditCard = creditCard;
//		this.reasonOfTheTrip = reasonOfTheTrip;
//		this.reservations = reservations;
//	}

}
