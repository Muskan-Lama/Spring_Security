package com.tothenew.muskan.springsecurity1.CouponRepo;


import com.tothenew.muskan.springsecurity1.Entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository  extends JpaRepository<Coupon,Integer> {
     Coupon findByCode(String code);
}
