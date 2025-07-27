package SpringBootAnnotation.example.Annotation.repository;

import SpringBootAnnotation.example.Annotation.entity.Person;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    // 1. JPQL query using index param
    @Query("SELECT p FROM Person p WHERE p.email = ?1")
    Person findByEmail(String email);

    // 2. Named parameter
    @Query("SELECT p FROM Person p WHERE p.name = :name")
    List<Person> findByName(@Param("name") String name);

    // 3. Native query with @Param
    @Query(value = "SELECT * FROM person WHERE email LIKE %:email%", nativeQuery = true)
    List<Person> searchEmailNative(@Param("email") String emailPart);

    // 4. Pagination with countQuery
    @Query(
            value = "SELECT p FROM Person p WHERE p.name LIKE %:keyword%",
            countQuery = "SELECT COUNT(p) FROM Person p WHERE p.name LIKE %:keyword%"
    )
    Page<Person> searchPaginated(@Param("keyword") String keyword, Pageable pageable);

    // 5. Query with hints (read-only)
    @Query("SELECT p FROM Person p")
    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.READ_ONLY, value = "true"))
    List<Person> findAllReadOnly();

}