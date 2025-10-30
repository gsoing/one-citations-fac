package org.gso.profiles.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gso.profiles.dto.ProfileDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class ProfileModel {

    @Id
    private String id;
    private String userId;
    @Email
    private String mail;
    private int age;
    private String firstName;
    private String lastName;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime modified;

    public ProfileDto toDto() {
        return new ProfileDto(
                this.id,
                this.userId,
                this.mail,
                this.age,
                this.firstName,
                lastName,
                this.created,
                this.modified);
    }
}
