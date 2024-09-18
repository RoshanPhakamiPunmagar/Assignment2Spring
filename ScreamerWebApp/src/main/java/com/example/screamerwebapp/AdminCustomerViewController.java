package com.example.screamerwebapp;

import feign.FeignException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller @RequestMapping("/admin/customer/view")
public class AdminCustomerViewController {
    private final AdminCustomerClient adminCustomerClient;

    public AdminCustomerViewController(AdminCustomerClient adminCustomerClient) {
        this.adminCustomerClient = adminCustomerClient;
    }


    @GetMapping("/all")
    public String listCustomers(Model model) {
        List<Customer> customers = adminCustomerClient.listCustomers();
        model.addAttribute("customers", customers);
        return "customer-list";
    }

    @GetMapping("/customers/blocked")
    public String listBlockedCustomers(Model model) {
        List<Customer> blockedCustomers = adminCustomerClient.listBlockedCustomers();
        model.addAttribute("customers", blockedCustomers);
        return "blocked-customers";
    }

    @GetMapping("/customers/unblocked")
    public String listUnblockedCustomers(Model model) {
        List<Customer> unblockedCustomers = adminCustomerClient.listUnblockedCustomers();
        model.addAttribute("customers", unblockedCustomers);
        return "unblocked-customers";
    }

    @GetMapping("/customers/status/{id}")
    public String checkCustomerStatus(@PathVariable Long id, Model model) {
        boolean isBlocked = adminCustomerClient.checkCustomerStatus(id);
        model.addAttribute("isBlocked", isBlocked);
        return "customer-status";
    }

    @PostMapping("block/{id}")
    public String blockCustomer(@PathVariable Long id) {
        adminCustomerClient.blockCustomers(id);
        return "redirect:/admin/customer/view/all";
    }

    @PostMapping("unblock/{id}")
    public String unblockCustomer(@PathVariable Long id) {
        adminCustomerClient.unblockCustomers(id);
        return "redirect:/admin/customer/view/all";
    }
}
