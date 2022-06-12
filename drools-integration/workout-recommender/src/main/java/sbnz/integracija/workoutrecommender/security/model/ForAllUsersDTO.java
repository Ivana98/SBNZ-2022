package sbnz.integracija.workoutrecommender.security.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForAllUsersDTO {
    private Long userId;
    private String email;
    private String name;
    private String surname;
    private String userAuthority;
}
