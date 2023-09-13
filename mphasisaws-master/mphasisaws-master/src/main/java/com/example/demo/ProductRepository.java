package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
                                                    //PojoClass,pK type
public interface ProductRepository extends JpaRepository<Product,Integer> {
//this interface has all the crud operations with predefined methods in it 
//in this interface if we need our own query we can frame it by using JPQL @Query	
}
