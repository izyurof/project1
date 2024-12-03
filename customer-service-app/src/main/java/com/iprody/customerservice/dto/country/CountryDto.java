package com.iprody.customerservice.dto.country;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class CountryDto {

    @NotNull
    private Long id;

    @NotNull
    private String countryCode;

    @NotNull
    @Size(max = 60)
    private String name;

    private Instant createdAt;

    private Instant updatedAt;

}



