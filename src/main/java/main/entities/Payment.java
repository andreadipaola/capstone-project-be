package main.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.entities.enums.PaymentStatus;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
public class Payment {
	@Id
	@GeneratedValue
	@Column(name = "payment_id")
	private UUID paymentId;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	private LocalDateTime paymentDateTime;
	@OneToOne
	@JoinColumn(name = "invoice_id")
	@JsonBackReference
	private Invoice invoice;

	public Payment(PaymentStatus paymentStatus, LocalDateTime paymentDateTime, Invoice invoice) {
		this.paymentStatus = paymentStatus;
		this.paymentDateTime = paymentDateTime;
		this.invoice = invoice;
	}

}
