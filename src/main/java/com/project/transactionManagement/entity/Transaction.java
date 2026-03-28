package com.project.transactionManagement.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //to auto generate value for primary key, Identity type because MySQL does not support SEQUENCE
	private Integer id;
	private Integer userId;
	private LocalDateTime timestamp;  //why not Date ?
	private Double amount;
	private String type;
}
