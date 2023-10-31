package jpamvcexam.model.dto;

import jpamvcexam.model.entity.Locker;
import jpamvcexam.model.entity.Team;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="emp")
public class Emp {
    @Id
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private LocalDate hiredate;
    private int sal;
    private int comm;
    // 연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "deptno")
    private Dept dept;


}
