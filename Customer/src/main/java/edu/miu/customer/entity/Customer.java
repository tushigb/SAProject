package edu.miu.customer.entity;

import edu.miu.customer.dto.request.CustomerDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Customer
 *
 * @author Tushig Battumur
 **/

@Document("customers")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private String customerId;

    private String firstname, lastname;

    private String phone, email;

    private Address address;

    public void fill(CustomerDTO customerDTO) {
        setFirstname(customerDTO.getFirstname());
        setLastname(customerDTO.getLastname());
        setPhone(customerDTO.getPhone());
        setEmail(customerDTO.getEmail());
        setAddress(customerDTO.getAddress());
    }

}
