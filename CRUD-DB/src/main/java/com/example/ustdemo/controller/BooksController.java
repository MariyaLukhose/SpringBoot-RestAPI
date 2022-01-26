package com.example.ustdemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ustdemo.model.Books;

@RestController
public class BooksController {
	private static Map<String,Books> bookrepo= new HashMap();
	static {
		Books testing=new Books();
		testing.setBookid("1");
		testing.setBookname("Selenium Beginners");
		bookrepo.put(testing.getBookid(), testing);
		
		Books dev=new Books();
		dev.setBookid("2");
		dev.setBookname("Java programming");
		bookrepo.put(dev.getBookid(), dev);
		
		Books devOps=new Books();
		devOps.setBookid("3");
		devOps.setBookname("Jenkins");
		bookrepo.put(devOps.getBookid(), devOps);
	}
	@RequestMapping("/books")
	public ResponseEntity<Object> getBooks(){
		return new ResponseEntity<> (bookrepo.values(),HttpStatus.OK);
	}
	//@RequestMapping(value="/books",method=RequestMethod.POST)
	@PostMapping("/books")
	public ResponseEntity<Object> createBooks(@RequestBody Books book){
		return new ResponseEntity<> ("Books created successfully",HttpStatus.CREATED);
	}
	//@RequestMapping(value="/books/{bookid}",method=RequestMethod.PUT)
	@PutMapping("/books/{bookid}")
	public ResponseEntity<Object> updateBooks(@PathVariable("bookid") String bookid,@RequestBody Books book){
		bookrepo.remove(bookid);
		book.setBookid(bookid);
		bookrepo.put(bookid, book);
		return new ResponseEntity<> ("Books updated successfully",HttpStatus.OK);
	}
	//@RequestMapping(value="/books/{bookid}",method=RequestMethod.DELETE)
	@DeleteMapping("/books/{bookid}")
	public ResponseEntity<Object> deleteBooks(@PathVariable("bookid") String bookid){
		bookrepo.remove(bookid);
		return new ResponseEntity<> ("Books deleted successfully",HttpStatus.OK);
	}
}