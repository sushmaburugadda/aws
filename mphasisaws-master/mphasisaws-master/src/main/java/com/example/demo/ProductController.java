package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ProductController {
	@Autowired
	ProductDAO dao;
	Logger log=Logger.getAnonymousLogger();
//this is a demo line
	@RequestMapping("/")
	public ModelAndView displayHome(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		log.info("object for model and view created ");
		mv.setViewName("index.jsp");
		log.info("going to the page index.jsp");
		return mv;
	}

	@RequestMapping("/insert")
	public ModelAndView insert(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		log.info("object for model and view created ");
		Product product=new Product();
		product.setPname(request.getParameter("pname"));
		product.setCost(Integer.parseInt(request.getParameter("pcost")));
		log.info("setting of values done" +product.getPname()+"  "+product.getCost());
		Product order=dao.insert(product);
		if(order!=null) {
			mv.setViewName("success.jsp");
			log.info("going to success.jsp page");
		}
		else {
			mv.setViewName("fail.jsp");
			log.info("going to fail.jsp page");
		}
		return mv;
	}

	@RequestMapping("/display")
	public ModelAndView display(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		log.info("object for model and view created ");
		Product product=new Product();
		List<Product> order=dao.getall();
		mv.addObject("list",order);
		mv.setViewName("display.jsp");
		return mv;
	}


}