package model;
public class Book {
	private int id;
	private String title; 
	
	public Book(int id, String title) {
	super();
	this.id = id;
	this.title = title;
	}
	
	public int getId() {
		return id;
		}
	
	public void setId(int id) {
		this.id = id;
		}
	         
	public Book(String title) {
		super();
		this.title = title;
		}
	
	public Book() {
		super();
		}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
		}
	
	public String getTitle() {
      return title;
	}
	
	public void setTitle(String title) {
	this.title = title;
}


}