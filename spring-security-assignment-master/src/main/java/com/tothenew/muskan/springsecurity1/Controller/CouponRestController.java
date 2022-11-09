package com.tothenew.muskan.springsecurity1.Controller;


import com.tothenew.muskan.springsecurity1.CouponRepo.CouponRepository;
import com.tothenew.muskan.springsecurity1.Entity.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
    @Autowired
    CouponRepository couponRepository;

    @RequestMapping(value = "/coupons",method = RequestMethod.POST)
    public Coupon create(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }

    @RequestMapping(value = "/coupons/{code}",method = RequestMethod.GET)
    public Coupon getCoupons(@PathVariable("code") String code){
        return couponRepository.findByCode("SUPERSALE");
    }

}
