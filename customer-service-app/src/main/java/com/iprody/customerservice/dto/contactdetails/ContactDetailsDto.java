package com.iprody.customerservice.dto.contactdetails;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ContactDetailsDto {

    private Long id;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String telegramId;

    private Instant createdAt;

    private Instant updatedAt;

}


