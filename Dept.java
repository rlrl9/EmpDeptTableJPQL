package jpamvcexam.model.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dept {
    @Id
    @Column(name = "deptno")
    private int deptno;
    private String dname;
    private String loc_code;
}
