package com.sagala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagala.entity.Customer;
import com.sagala.service.CustomerService;

@Controller
public class MainController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String findAll(Model model) {
		List<Customer> customers =customerService.findAll();
		model.addAttribute("customers", customers);
		return "home";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int customerId) {
		customerService.delete(customerId);
		return "redirect:/list";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("customerId") int customerId, Model model) {
		Customer customer =customerService.findById(customerId);
		model.addAttribute("customer", customer);
		return "customer-form";
	}
}
