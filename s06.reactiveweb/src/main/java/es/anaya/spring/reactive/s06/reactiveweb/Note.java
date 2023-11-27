package es.anaya.spring.reactive.s06.reactiveweb;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Note {
	
    @Id
    private ObjectId _id;
    private String text;
    private Date date;
    
    public Note () {}
    
    
	public Note(String text) {
		_id = new ObjectId();
		this.text = text;
		date = new Date();
	}


	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Note [_id=" + _id + ", text=" + text + ", date=" + date + "]";
	}

	
}
