package com.teks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MyRepo extends JpaRepository<User,Integer>{

}
