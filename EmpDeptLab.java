package jpamvcexam.mainview;

import jpamvcexam.model.dto.Book;

import javax.persistence.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EmpDeptLab {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
        EntityManager em = factory.createEntityManager();
        Random rand = new Random();
        int num = rand.nextInt(2);
        System.out.println(num);
        boolean result;
        if(num==1)
            result=true;
        else
            result=false;
        Scanner scan = new Scanner(System.in);
        if(result){
            System.out.print("사원명을 입력하세요 : ");
            String inputName = scan.nextLine();
            String jpql = "select e.dept.dname from Emp e where e.ename = :un";

            TypedQuery<String> q = em.createQuery(jpql, String.class);
            q.setParameter("un", inputName);
            String deptName;
            try {
                deptName = q.getSingleResult();
                System.out.printf("%s의 근무부서 - %s\n", inputName, deptName);
            } catch(NoResultException e) {
                System.out.printf("부서를 찾을 수 없네요..ㅜㅜ \n");
            }
        }else {
            System.out.print("부서명을 입력하세요 : ");
            String inputDept = scan.nextLine();
            String jpql = "select e.ename from Emp e where e.dept.dname = :un";

            TypedQuery<String> q = em.createQuery(jpql, String.class);
            q.setParameter("un", inputDept);
            List<String> deptName;
            if(!q.getResultList().isEmpty()) {
                deptName = q.getResultList();
                System.out.printf("%s의 부서에 근무하는 직원\n", inputDept);
                for (String dn:
                     deptName) {
                    System.out.println(dn);
                }
            } else {
                System.out.printf("직원들을 찾을 수 없네요.ㅜㅜ \n");
            }
        }
        scan.close();
        factory.close();
    }
}
