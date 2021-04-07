package com.example.vmw.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeInventoryResource {

//    @GetMapping("/{userId}")
//    public List<CatalogItem> getCatalog (@PathVariable("userId") String userId){
//        UserRating ratings = userRatingInfo.getUserRating(userId);
//        return ratings.getRatings().stream().map(rating -> {
//            return movieInfo.getCatalogItem(rating);
//        }).collect(Collectors.toList());
//
//    }


}
