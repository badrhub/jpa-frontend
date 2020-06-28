package controllers;

import java.util.Arrays;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import model.Book;


@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	RestTemplate restTemplate;
	private static final String URL_API_BOOK ="http://localhost:2099/jpaFST/books";
	
	@RequestMapping
	public String home( Model model , @ModelAttribute("book")Book b) {
		System.out.println("home entreeeeeeeeeee");
		ResponseEntity<Book[]> response =restTemplate.getForEntity(URL_API_BOOK  , Book[].class);
		System.out.println("home wasiiiiiite");
		Book[] resultats = response.getBody();
		if(b != null) {
			model.addAttribute("book", b);
		}else {
			model.addAttribute("book", new Book(0, ""));
		}
		model.addAttribute("books", Arrays.asList(resultats));
		System.out.println("home sortiiiiiiiiiiiiiiiii");
		return "home";
		}
	
	@RequestMapping("/{id}")
	public String getOne(@PathVariable("id") int id, Model model , RedirectAttributes ra) {
		ResponseEntity<Book> response =restTemplate.getForEntity(URL_API_BOOK + "/" + id, Book.class);
		Book b = response.getBody();
		ra.addFlashAttribute("book", b);
		return "redirect:/books";
		}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") int id) {
		restTemplate.delete(URL_API_BOOK +"/" + id);
		return "redirect:/books";
		} 
	
	@RequestMapping(value = "/add", params="add" , method = RequestMethod.POST)
	public String addBook(@Valid Book b, BindingResult results, RedirectAttributes ra) {
		restTemplate.postForEntity(URL_API_BOOK + "/add", b, HttpStatus.class);
		ra.addFlashAttribute("book", b);
		return "redirect:/books";
		}
	
	@RequestMapping(value = "/add", params="update")
	public String updateBook(@ModelAttribute("book")Book b, Model model ,RedirectAttributes ra) {
		restTemplate.put(URL_API_BOOK, b);
		ra.addFlashAttribute("book",b);
		return "redirect:/books";
		}
	}