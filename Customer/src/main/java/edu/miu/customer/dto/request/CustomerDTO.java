package edu.miu.customer.dto.request;

import edu.miu.customer.entity.Address;
import lombok.*;

/**
 * NewCustomerDTO
 *
 * @author Tushig Battumur
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {

    private String firstname, lastname;

    private String phone, email;

    private Address address;

}
