/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
* Copyright (c) 2019 FedEx Services, Inc. All Rights Reserved.* * * * * * * * * * * * * *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*/
package com.infogain.ordermanagement;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infogain.ordermanagement.beans.CustOrder;

/** This class is used for 
 * @author Sharad.Jain
 *
 */
public interface OrderRepository extends 
JpaRepository<CustOrder, Long>{
 
}
