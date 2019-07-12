/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
* Copyright (c) 2019 FedEx Services, Inc. All Rights Reserved.* * * * * * * * * * * * * *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*/
package com.infogain.ordermanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.ordermanagement.beans.Item;

/** This class is used for 
 * @author Sharad.Jain
 *
 */
@Repository
public interface ItemRepository extends 
JpaRepository<Item, Long>{
 
}
