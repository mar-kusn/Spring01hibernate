package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    //    Listę autorów, których email zaczyna się od wskazanego ciągu znaków.
    @Query("SELECT a FROM Author a WHERE a.email LIKE ?1%")
    List<Author> readByCustomEmailStartBy(String email);

    //    Listę autorów których pesel zaczyna się od wskazanych znaków, np 83.
    @Query("SELECT a FROM Author a WHERE a.pesel LIKE ?1%")
    List<Author> readByCustomPeselStartBy(String pesel);
}
