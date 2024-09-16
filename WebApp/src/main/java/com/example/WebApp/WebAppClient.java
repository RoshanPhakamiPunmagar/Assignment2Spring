/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebApp;

import org.springframework.cloud.openfeign.FeignClient;

/**
 *
 * @author caleb
 */
@FeignClient(name = "recommendationClient", url = "http://localhost:8333")

public class WebAppClient {
    
}
