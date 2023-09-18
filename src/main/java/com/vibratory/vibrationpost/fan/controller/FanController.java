package com.vibratory.vibrationpost.fan.controller;

import com.vibratory.vibrationpost.fan.exception.FanException;
import com.vibratory.vibrationpost.fan.model.Fan;
import com.vibratory.vibrationpost.fan.services.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fan")
public class FanController {

    private FanService fanService;

    @Autowired
    public FanController(FanService fanService){
        this.fanService = fanService;
    }

    @PostMapping
    public ResponseEntity<Fan> create(@RequestBody Fan fan)throws FanException{
        fan = fanService.create(fan);
        return new ResponseEntity<>(fan, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id)throws FanException{
        Fan fan = fanService.getById(id);
        return new ResponseEntity<>(fan,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Fan>> getAllFans(){
        List<Fan> fans = fanService.getAllFans();
        return new ResponseEntity<>(fans, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fan> updateById(@PathVariable Long id,@RequestBody Fan fan) throws FanException {
        Fan updatedFan = fanService.updateFan(id,fan);
        return new ResponseEntity<>(fan,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fan> deleteFan(@PathVariable Long id)throws FanException{
        fanService.deleteFan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
