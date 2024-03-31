package com.javaexpress.repository;


//import java.util.Locale.Category;
import com.javaexpress.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
 